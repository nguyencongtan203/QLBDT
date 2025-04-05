package com.example.QuanLyBanDienThoai.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class Hang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mahang;

    @OneToMany(mappedBy = "hang", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Sanpham> sanPham;

    private String tenhang;

    public List<Sanpham> getSanPham() {
        return sanPham;
    }

    public void setSanPham(List<Sanpham> sanPham) {
        this.sanPham = sanPham;
    }

    public int getMahang() {
        return mahang;
    }

    public void setMahang(int mahang) {
        this.mahang = mahang;
    }

    public String getTenhang() {
        return tenhang;
    }

    public void setTenhang(String tenhang) {
        this.tenhang = tenhang;
    }
}
