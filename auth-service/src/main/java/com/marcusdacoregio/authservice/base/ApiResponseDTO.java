package com.marcusdacoregio.authservice.base;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponseDTO<T> {

    private T status;
    private Boolean success = false;
    private T message;
    private T data;

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setMessage(T message) {
        this.message = message;
    }

    public T getMessage() {
        return message;
    }

    public void setStatus(T status) {
        this.status = status;
    }

    public T getStatus() {
        return status;
    }


}
