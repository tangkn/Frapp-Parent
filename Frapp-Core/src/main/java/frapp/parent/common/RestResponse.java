package com.tan.frap.common;

public record RestResponse<T>(int status,String message, T payload) {
}
