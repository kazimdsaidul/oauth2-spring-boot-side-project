package com.marcusdacoregio.authservice.model;

public class ApiResponseDTO<T> {
    private T version;
    private T success;
    private T data;

    public void setVersion(T version) {

        this.version = version;
    }

    public void setSuccess(T success) {

        this.success = success;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
