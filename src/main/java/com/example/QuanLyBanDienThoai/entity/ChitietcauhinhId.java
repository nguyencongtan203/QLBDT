package com.example.QuanLyBanDienThoai.entity;

import java.io.Serializable;
import java.util.Objects;

public class ChitietcauhinhId implements Serializable {
    private int masp;
    private int mach;

    public ChitietcauhinhId() {
    }

    public ChitietcauhinhId(int masp, int mach) {
        this.masp = masp;
        this.mach = mach;
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

    // Override equals và hashCode để đảm bảo so sánh chính xác
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChitietcauhinhId that = (ChitietcauhinhId) o;
        return Objects.equals(masp, that.masp) && Objects.equals(mach, that.mach);
    }

    @Override
    public int hashCode() {
        return Objects.hash(masp, mach);
    }
}
