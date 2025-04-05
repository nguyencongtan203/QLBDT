package com.example.QuanLyBanDienThoai.repository;

import com.example.QuanLyBanDienThoai.entity.Giohang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiohangRepository extends JpaRepository<Giohang,Integer> {
}
