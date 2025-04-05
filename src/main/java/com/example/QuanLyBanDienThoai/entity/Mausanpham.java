package com.example.QuanLyBanDienThoai.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class Mausanpham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mamau;

    @OneToMany(mappedBy = "mauSanPham", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Sanpham> sanPham;

    private String giatri;
    public List<Sanpham> getSanPham() {
        return sanPham;
    }

    public void setSanPham(List<Sanpham> sanPham) {
        this.sanPham = sanPham;
    }

    public int getMamau() {
        return mamau;
    }

    public void setMamau(int mamau) {
        this.mamau = mamau;
    }

    public String getGiatri() {
        return giatri;
    }

    public void setGiatri(String giatri) {
        this.giatri = giatri;
    }
}
