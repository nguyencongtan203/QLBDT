package com.example.QuanLyBanDienThoai.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class Dophangiai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int madpg;

    @OneToMany(mappedBy = "doPhanGiai", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Sanpham> sanPham;

    private String giatri;

    public List<Sanpham> getSanPham() {
        return sanPham;
    }

    public void setSanPham(List<Sanpham> sanPham) {
        this.sanPham = sanPham;
    }

    public int getMadpg() {
        return madpg;
    }

    public void setMadpg(int madpg) {
        this.madpg = madpg;
    }

    public String getGiatri() {
        return giatri;
    }

    public void setGiatri(String giatri) {
        this.giatri = giatri;
    }
}
