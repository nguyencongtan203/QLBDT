package com.example.QuanLyBanDienThoai.repository;

import com.example.QuanLyBanDienThoai.entity.Khachhang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KhachhangRepository extends JpaRepository<Khachhang,Integer> {
    Optional<Khachhang> findByEmail(String email);
}
