package com.knoldus.kafka.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.knoldus.utils.Tweet;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class TweetSerializer implements Serializer<Tweet> {

    public void configure(Map<String, ?> map, boolean b) {

    }

    public byte[] serialize(String s, Tweet tweet) {
        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            retVal = objectMapper.writeValueAsString(tweet).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retVal;
    }

    public void close() {

    }
}
