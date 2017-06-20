package com.tinmegali.models;

/**
 * Created by tinmegali on 20/06/17.
 */
public class RestResponse {

    String msg;

    public RestResponse(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
