package com.qabujiaban.benjamin.message.entity;

/**
 * @Author: benjamin_v@qq.com
 * @Date: 2021/11/4 14:23
 */


public class Message {

    public String getMessage_ip() {
        return message_ip;
    }

    public void setMessage_ip(String message_ip) {
        this.message_ip = message_ip;
    }

    public String getMessage_user() {
        return message_user;
    }

    public void setMessage_user(String message_user) {
        this.message_user = message_user;
    }

    public String getMessage_content() {
        return message_content;
    }

    public void setMessage_content(String message_content) {
        this.message_content = message_content;
    }

    public String getMessage_city() {
        return message_city;
    }

    public void setMessage_city(String message_city) {
        this.message_city = message_city;
    }

    public String getMessage_status() {
        return message_status;
    }

    public void setMessage_status(String message_status) {
        this.message_status = message_status;
    }

    public String getMessage_fabulous_ip() {
        return message_fabulous_ip;
    }

    public void setMessage_fabulous_ip(String message_fabulous_ip) {
        this.message_fabulous_ip = message_fabulous_ip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage_time() {
        return message_time;
    }

    public void setMessage_time(String message_time) {
        this.message_time = message_time;
    }

    private int id;
    private String message_ip;
    private String message_time;
    private String message_user;
    private String message_content;
    private String message_city;
    private String message_status;
    private String message_fabulous_ip;

}
