package com.knoldus.demo;

import com.knoldus.kafka.TweetConsumer;

public class ConsumerDemo {

    public static void main(String[] args) {
        new TweetConsumer().consumeTweets();
    }

}
