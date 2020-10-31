package com.soc.round1design.dto.response;

import lombok.Data;

@Data
public class UserResponse {

    private int userId;

    public UserResponse(int userId) {
        this.userId = userId;
    }
}
