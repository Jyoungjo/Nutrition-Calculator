package com.example.nutritioncalculator;

import lombok.Data;

@Data
public class ResponseDTO {
    private String message;

    public static ResponseDTO getInstance(String message) {
        ResponseDTO response = new ResponseDTO();
        response.setMessage(message);
        return response;
    }
}
