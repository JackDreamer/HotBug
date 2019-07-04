package com.ts.hotbug.testeventbus;

/**
 * 定义单例模式对象，用来定义消息
 */

public class EventDao {

    private String mMessage;

    public EventDao(String message) {
        this.mMessage = message;
    }

    public String getmMessage() {
        return mMessage;
    }

    public void setmMessage(String mMessage) {
        this.mMessage = mMessage;
    }
}
