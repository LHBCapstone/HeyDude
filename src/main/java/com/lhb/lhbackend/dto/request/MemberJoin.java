package com.lhb.lhbackend.dto.request;

public class MemberJoin {
    private String name;
    private String email;
    private String password;
    private String passwordCheck;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordCheck() {
        return passwordCheck;
    }
}
