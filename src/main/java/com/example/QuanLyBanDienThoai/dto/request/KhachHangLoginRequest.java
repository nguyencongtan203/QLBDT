package com.example.QuanLyBanDienThoai.dto.request;

public class KhachHangLoginRequest {
    private String email;
    private String matkhau;

    public KhachHangLoginRequest(String email, String matkhau) {
        this.email = email;
        this.matkhau = matkhau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }
}
