package com.dto;

public class LoginDTO {
    // old fields
    private String email;
    private String password;
    
    // New AJAX fields
    private boolean success;
    private String error;
    private String redirectUrl;
    
    // Generate getters/setters (ALT+INSERT in IntelliJ)
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }
    
    public String getError() { return error; }
    public void setError(String error) { this.error = error; }
    
    public String getRedirectUrl() { return redirectUrl; }
    public void setRedirectUrl(String redirectUrl) { this.redirectUrl = redirectUrl; }
}
