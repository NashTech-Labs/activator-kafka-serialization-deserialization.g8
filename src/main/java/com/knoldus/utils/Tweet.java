package com.knoldus.utils;

public class Tweet {

    String username;
    String text;
    Boolean isVerified;
    Integer favCount;
    Boolean isReweet;

    public Tweet() {
    }

    public Tweet(String username, String text, int favCount, boolean isVerified, boolean isReweet) {
        this.text = text;
        this.username = username;
        this.favCount = favCount;
        this.isReweet = isReweet;
        this.isVerified = isVerified;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setVerified(Boolean verified) {
        isVerified = verified;
    }

    public void setFavCount(int favCount) {
        this.favCount = favCount;
    }

    public void setReweet(boolean reweet) {
        isReweet = reweet;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public String getText() {
        return this.text;
    }

    public int getFavCount() {
        return this.favCount;
    }

    public Boolean getVerified() {
        return isVerified;
    }

    public Boolean getReweet() {
        return isReweet;
    }

    public String toString() {
        return "Tweet (" + username + ", " + text + ", " + favCount + ", " + isVerified + ", " + isReweet + ")";

    }

}
