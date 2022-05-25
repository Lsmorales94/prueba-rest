package com.ceiba.model.entity;

public class ResponseJson {
	boolean successful = false;
    String msg;
    String data;
    
    public ResponseJson(boolean successful, String msg) {
        this.successful = successful;
        this.msg = msg;
    }
    
	public boolean isSuccessful() {
		return successful;
	}
	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
