package com.example.QuanLyBanDienThoai.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@IdClass(ChitietgiohangId.class)
public class Chitietgiohang {
    @Id
    @Column(name = "magh")
    private int magh;

    @Id
    @Column(name = "masp")
    private int masp;

    @ManyToOne
    @JoinColumn(name = "magh", insertable = false, updatable = false)
    private Giohang gioHang;

    @ManyToOne
    @JoinColumn(name = "masp", insertable = false, updatable = false)
    private Sanpham sanPham;

    private int soluong;
    private BigDecimal dongia;
    private BigDecimal thanhtien;

    public Giohang getGioHang() {
        return gioHang;
    }

    public void setGioHang(Giohang gioHang) {
        this.gioHang = gioHang;
    }

    public Sanpham getSanPham() {
        return sanPham;
    }

    public void setSanPham(Sanpham sanPham) {
        this.sanPham = sanPham;
    }

    public int getMagh() {
        return magh;
    }

    public void setMagh(int magh) {
        this.magh = magh;
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
