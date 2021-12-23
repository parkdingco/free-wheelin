package com.mathflat.parkdingco.common;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ResultResponse<T> {
    private final T data;
    private final ErrorCode error;

    @Builder
    public ResultResponse(T data, ErrorCode error) {
        this.data = data;
        this.error = error;
    }

    public static <T> ResultResponse<T> success() {
        return new ResultResponse<>(null, null);
    }

    public static <T> ResultResponse<T> success(T data) {
        return new ResultResponse<>(data, null);
    }

    public static <T> ResultResponse<T> fail(T data, ErrorCode error) {
        return new ResultResponse<>(data, error);
    }
}
