package com.example.QuanLyBanDienThoai.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@IdClass(ChitietdonhangId.class)
public class Chitietdonhang {
    @Id
    @Column(name = "madh")
    private int madh;

    @Id
    @Column(name = "masp")
    private int masp;

    @ManyToOne
    @JoinColumn(name = "madh", insertable = false, updatable = false)
    private Donhang donHang;

    @ManyToOne
    @JoinColumn(name = "masp", insertable = false, updatable = false)
    private Sanpham sanPham;

    private int soluong;
    private BigDecimal dongia;
    private BigDecimal thanhtien;

    public Donhang getDonHang() {
        return donHang;
    }

    public void setDonHang(Donhang donHang) {
        this.donHang = donHang;
    }

    public Sanpham getSanPham() {
        return sanPham;
    }

    public void setSanPham(Sanpham sanPham) {
        this.sanPham = sanPham;
    }

    public int getMadh() {
        return madh;
    }

    public void setMadh(int madh) {
        this.madh = madh;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public BigDecimal getDongia() {
        return dongia;
    }

    public void setDongia(BigDecimal dongia) {
        this.dongia = dongia;
    }

    public BigDecimal getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(BigDecimal thanhtien) {
        this.thanhtien = thanhtien;
    }
}
