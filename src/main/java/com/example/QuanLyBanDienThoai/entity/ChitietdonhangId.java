package com.example.QuanLyBanDienThoai.entity;

import java.io.Serializable;
import java.util.Objects;

public class ChitietdonhangId implements Serializable {
    private int madh;
    private int masp;

    public ChitietdonhangId() {
    }

    public ChitietdonhangId(int madh, int masp) {
        this.madh = madh;
        this.masp = masp;
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

    // Override equals và hashCode để đảm bảo so sánh chính xác
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChitietdonhangId that = (ChitietdonhangId) o;
        return Objects.equals(madh, that.madh) && Objects.equals(masp, that.masp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(madh, masp);
    }
}
