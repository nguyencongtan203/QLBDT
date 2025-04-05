package com.example.QuanLyBanDienThoai.entity;

import jakarta.persistence.*;

@Entity
@IdClass(ChitietcauhinhId.class)
public class Chitietcauhinh {
    @Id
    @Column(name = "masp")
    private int masp;

    @Id
    @Column(name = "mach")
    private int mach;

    @ManyToOne
    @JoinColumn(name = "masp", insertable = false, updatable = false)
    private Sanpham sanPham;
    @ManyToOne
    @JoinColumn(name = "mach", insertable = false, updatable = false)
    private Cauhinh cauHinh;

    private String donvi;
    private String giatri;


    public Sanpham getSanpham() {
        return sanPham;
    }

    public void setSanpham(Sanpham sanpham) {
        this.sanPham = sanpham;
    }

    public Cauhinh getCauhinh() {
        return cauHinh;
    }

    public void setCauhinh(Cauhinh cauhinh) {
        this.cauHinh = cauhinh;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public int getMach() {
        return mach;
    }

    public void setMach(int mach) {
        this.mach = mach;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }

    public String getGiatri() {
        return giatri;
    }

    public void setGiatri(String giatri) {
        this.giatri = giatri;
    }
}
