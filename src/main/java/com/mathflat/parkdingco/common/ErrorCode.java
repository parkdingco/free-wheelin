package com.mathflat.parkdingco.common;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ErrorCode {
    private final String code;
    private final String message;

    @Builder
    public ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
