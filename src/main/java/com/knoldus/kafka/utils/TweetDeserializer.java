package com.knoldus.kafka.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.knoldus.utils.Tweet;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class TweetDeserializer implements Deserializer<Tweet> {

    public void configure(Map<String, ?> map, boolean b) {

    }

    public Tweet deserialize(String s, byte[] bytes) {
        ObjectMapper mapper = new ObjectMapper();
        Tweet tweet = null;
        try {
            tweet = mapper.readValue(bytes, Tweet.class);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return tweet;
    }

    public void close() {

    }
}
