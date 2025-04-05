package com.example.QuanLyBanDienThoai.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class Khachhang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int makh;

    @OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Donhang> donHang;

    @OneToOne(mappedBy = "khachHang")
    private Giohang gioHang;

    private String tenkh;
    private String diachi;
    @Column(unique = true)
    private String sdt;
    @Column(unique = true)
    private String email;
    private String matkhau;

    public List<Donhang> getDonHang() {
        return donHang;
    }

    public void setDonHang(List<Donhang> donHang) {
        this.donHang = donHang;
    }

    public Giohang getGioHang() {
        return gioHang;
    }

    public void setGioHang(Giohang gioHang) {
        this.gioHang = gioHang;
    }

    public int getMakh() {
        return makh;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
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
