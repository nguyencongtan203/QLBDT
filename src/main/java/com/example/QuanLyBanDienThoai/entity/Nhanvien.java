package com.example.QuanLyBanDienThoai.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
@Entity
public class Nhanvien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int manv;

    @OneToMany(mappedBy = "nhanVien", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Hoadon> hoaDon;

    private String tennv;
    private String diachi;
    private String sdt;
    private boolean chucvu;
    private Timestamp ngaysinh;
    private String taikhoan;
    private String matkhau;

    public List<Hoadon> getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(List<Hoadon> hoaDon) {
        this.hoaDon = hoaDon;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public boolean isChucvu() {
        return chucvu;
    }

    public void setChucvu(boolean chucvu) {
        this.chucvu = chucvu;
    }

    public Timestamp getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Timestamp ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }
}
