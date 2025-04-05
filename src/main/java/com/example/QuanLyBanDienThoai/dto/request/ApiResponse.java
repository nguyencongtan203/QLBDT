package com.example.QuanLyBanDienThoai.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;

//Chuan hoa API
//Thuoc tinh = null khong can show
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private int code;
    private String message;
    private T result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
