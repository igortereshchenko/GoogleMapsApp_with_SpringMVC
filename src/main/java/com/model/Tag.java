package com.model;

/**
 * Created by Ichanskiy on 2017-04-26.
 */
public class Tag {

    private String tag_name;
    private String tag_discriotion;

    public Tag() {
    }

    public Tag(String tag_name, String tag_discriotion) {
        this.tag_name = tag_name;
        this.tag_discriotion = tag_discriotion;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    public String getTag_discriotion() {
        return tag_discriotion;
    }

    public void setTag_discriotion(String tag_discriotion) {
        this.tag_discriotion = tag_discriotion;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tag_name='" + tag_name + '\'' +
                ", tag_discriotion='" + tag_discriotion + '\'' +
                '}';
    }
}
