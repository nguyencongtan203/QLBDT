package com.example.QuanLyBanDienThoai.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class Cauhinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mach;

    @OneToMany(mappedBy = "cauHinh", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Chitietcauhinh> chiTietCauHinh;

    private String tench;


    public List<Chitietcauhinh> getChiTietCauHinh() {
        return chiTietCauHinh;
    }

    public void setChiTietCauHinh(List<Chitietcauhinh> chiTietCauHinh) {
        this.chiTietCauHinh = chiTietCauHinh;
    }

    public int getMach() {
        return mach;
    }

    public void setMach(int mach) {
        this.mach = mach;
    }

    public String getTench() {
        return tench;
    }

    public void setTench(String tench) {
        this.tench = tench;
    }
}
