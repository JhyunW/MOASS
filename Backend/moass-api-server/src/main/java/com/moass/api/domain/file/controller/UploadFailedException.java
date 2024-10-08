package com.moass.api.domain.file.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import software.amazon.awssdk.core.SdkResponse;
import software.amazon.awssdk.http.SdkHttpResponse;

import java.util.Optional;

@AllArgsConstructor
public class UploadFailedException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private int statusCode;
    private Optional<String> statusText;

    public UploadFailedException(SdkResponse response) {

        SdkHttpResponse httpResponse = response.sdkHttpResponse();
        if (httpResponse != null) {
            this.statusCode = httpResponse.statusCode();
            this.statusText = httpResponse.statusText();
        } else {
            this.statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
            this.statusText = Optional.of("UNKNOWN");
        }

    }
}
