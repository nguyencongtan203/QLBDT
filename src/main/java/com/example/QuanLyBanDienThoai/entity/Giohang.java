package com.example.QuanLyBanDienThoai.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class Giohang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int magh;

    @OneToOne
    @JoinColumn(name = "makh", nullable = false, unique = true)
    private Khachhang khachHang;

    @OneToMany(mappedBy = "gioHang", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Chitietgiohang> chiTietGioHang;

    public Khachhang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(Khachhang khachhang) {
        this.khachHang = khachhang;
    }

    public List<Chitietgiohang> getChiTietGioHang() {
        return chiTietGioHang;
    }

    public void setChiTietGioHang(List<Chitietgiohang> chiTietGioHang) {
        this.chiTietGioHang = chiTietGioHang;
    }

    public int getMagh() {
        return magh;
    }

    public void setMagh(int magh) {
        this.magh = magh;
    }

}
