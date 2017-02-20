package com.knoldus.twitter;

import com.knoldus.kafka.TweetProducer;
import com.knoldus.utils.ConfigReader;
import com.knoldus.utils.Tweet;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import twitter4j.*;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

import java.io.IOException;

public class TwitterFeed {

    private ConfigReader configReader = new ConfigReader();

    private TwitterStream getTwitterConfig() {

        Configuration twitterConf = new ConfigurationBuilder()
                .setOAuthConsumerKey(configReader.getTwitterConsumerKey())
                .setOAuthConsumerSecret(configReader.getTwitterConsumerSecretKey())
                .setOAuthAccessToken(configReader.getTwitterAccessToken())
                .setOAuthAccessTokenSecret(configReader.getTwitterAccessSecretToken())
                .build();
        return new TwitterStreamFactory(twitterConf).getInstance();
    }

    public void sendTweetsToKafka() throws TwitterException, IOException {

        StatusListener listener = new StatusListener() {
            public void onStatus(Status status) {
                Tweet tweet = new Tweet(status.getUser().getName(),
                        status.getText(),
                        status.getFavoriteCount(),
                        status.getUser().isVerified(),
                        status.isRetweet());
                new TweetProducer().send(tweet);
                System.out.println("Sent: " + tweet);
            }

            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
            }

            public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
            }

            public void onScrubGeo(long l, long l1) {

            }

            public void onStallWarning(StallWarning stallWarning) {

            }

            public void onException(Exception ex) {
                ex.printStackTrace();
            }
        };

        TwitterStream twitterStream = getTwitterConfig();
        twitterStream.addListener(listener);
        twitterStream.sample("en");

    }

}
