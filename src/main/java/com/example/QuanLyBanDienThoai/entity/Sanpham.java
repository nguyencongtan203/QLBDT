package com.example.QuanLyBanDienThoai.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
@Entity
public class Sanpham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int masp;

    @OneToMany(mappedBy = "sanPham", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Chitietdonhang> chiTietDonHang;

    @OneToMany(mappedBy = "sanPham", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Chitietgiohang> chiTietGioHang;

    @OneToMany(mappedBy = "sanPham", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Chitietcauhinh> chiTietCauHinh;

    @ManyToOne
    @JoinColumn(name = "madpg", insertable = false, updatable = false)
    private Dophangiai doPhanGiai;

    @ManyToOne
    @JoinColumn(name = "mamau", insertable = false, updatable = false)
    private Mausanpham mauSanPham;

    @ManyToOne
    @JoinColumn(name = "mahang", insertable = false, updatable = false)
    private Hang hang;

    private int tinhtrang;
    private String tensp;
    private BigDecimal gia;
    private String hinhanh;

    public List<Chitietdonhang> getChiTietDonHang() {
        return chiTietDonHang;
    }

    public void setChiTietDonHang(List<Chitietdonhang> chiTietDonHang) {
        this.chiTietDonHang = chiTietDonHang;
    }

    public List<Chitietgiohang> getChiTietGioHang() {
        return chiTietGioHang;
    }

    public void setChiTietGioHang(List<Chitietgiohang> chiTietGioHang) {
        this.chiTietGioHang = chiTietGioHang;
    }

    public List<Chitietcauhinh> getChiTietCauHinh() {
        return chiTietCauHinh;
    }

    public void setChiTietCauHinh(List<Chitietcauhinh> chiTietCauHinh) {
        this.chiTietCauHinh = chiTietCauHinh;
    }

    public Dophangiai getDoPhanGiai() {
        return doPhanGiai;
    }

    public void setDoPhanGiai(Dophangiai doPhanGiai) {
        this.doPhanGiai = doPhanGiai;
    }

    public Mausanpham getMauSanPham() {
        return mauSanPham;
    }

    public void setMauSanPham(Mausanpham mauSanPham) {
        this.mauSanPham = mauSanPham;
    }

    public Hang getHang() {
        return hang;
    }

    public void setHang(Hang hang) {
        this.hang = hang;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public int isTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(int tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }
}
