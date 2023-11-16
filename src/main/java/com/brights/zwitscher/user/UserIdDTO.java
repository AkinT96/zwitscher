package com.brights.zwitscher.user;

public class UserIdDTO {
    private Long userId;

    public UserIdDTO(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

