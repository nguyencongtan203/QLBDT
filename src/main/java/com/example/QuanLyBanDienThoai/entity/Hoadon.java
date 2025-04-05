package com.example.QuanLyBanDienThoai.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
public class Hoadon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mahd;

    @ManyToOne
    @JoinColumn(name = "manv", insertable = false, updatable = false)
    private Nhanvien nhanVien;

    @ManyToOne
    @JoinColumn(name = "madh", insertable = false, updatable = false)
    private Donhang donHang;

    private BigDecimal tongtien;
    private Timestamp ngaytao;

    public Nhanvien getNhanvien() {
        return nhanVien;
    }

    public void setNhanvien(Nhanvien nhanvien) {
        this.nhanVien = nhanvien;
    }

    public Donhang getDonhang() {
        return donHang;
    }

    public void setDonhang(Donhang donhang) {
        this.donHang = donhang;
    }

    public int getMahd() {
        return mahd;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

    public BigDecimal getTongtien() {
        return tongtien;
    }

    public void setTongtien(BigDecimal tongtien) {
        this.tongtien = tongtien;
    }

    public Timestamp getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Timestamp ngaytao) {
        this.ngaytao = ngaytao;
    }
}
