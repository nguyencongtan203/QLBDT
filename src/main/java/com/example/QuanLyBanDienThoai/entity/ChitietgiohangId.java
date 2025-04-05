package com.example.QuanLyBanDienThoai.entity;

import java.io.Serializable;
import java.util.Objects;

public class ChitietgiohangId implements Serializable {
    private int magh;
    private int masp;

    public ChitietgiohangId() {
    }

    public ChitietgiohangId(int magh, int masp) {
        this.magh = magh;
        this.masp = masp;
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

    // Override equals và hashCode để đảm bảo so sánh chính xác
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChitietgiohangId that = (ChitietgiohangId) o;
        return Objects.equals(magh, that.magh) && Objects.equals(masp, that.masp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(magh, masp);
    }
}
