package com.kby.home.safety.api.web;

/**
 * Created by zhangpeng12 on 2017/5/15.
 */
public class QueryRoomStatusRequest extends Request {
    private int roomType;


    public int getRoomType() {
        return roomType;
    }

    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }
}
