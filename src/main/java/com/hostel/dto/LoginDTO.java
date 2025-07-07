package com.hostel.dto;

public class LoginDTO {
    private String email;
    private String password;
public class LoginDTO {
    private String email;
    private String password;
    private boolean success;
    private String error;
    private String redirectUrl;

    // Getters
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public boolean isSuccess() { return success; }
    public String getError() { return error; }
    public String getRedirectUrl() { return redirectUrl; }

    // Setters
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setSuccess(boolean success) { this.success = success; }
    public void setError(String error) { this.error = error; }
    public void setRedirectUrl(String redirectUrl) { this.redirectUrl = redirectUrl; }
}
