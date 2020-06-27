package com.inventorymanagement.model.base;

public class BaseResponse<T> {
    private T data;
    private ErrorResponse errorResponse;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BaseResponse{");
        sb.append("data=").append(data);
        sb.append(", errorResponse=").append(errorResponse);
        sb.append('}');
        return sb.toString();
    }
}
