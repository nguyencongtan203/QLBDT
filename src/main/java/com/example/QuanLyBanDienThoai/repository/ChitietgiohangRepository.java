package com.example.QuanLyBanDienThoai.repository;

import com.example.QuanLyBanDienThoai.entity.Chitietgiohang;
import com.example.QuanLyBanDienThoai.entity.ChitietgiohangId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChitietgiohangRepository extends JpaRepository<Chitietgiohang, ChitietgiohangId> {
}
