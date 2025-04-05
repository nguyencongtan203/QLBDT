package com.example.QuanLyBanDienThoai.repository;

import com.example.QuanLyBanDienThoai.entity.Sanpham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanphamRepository extends JpaRepository<Sanpham,Integer> {
}
