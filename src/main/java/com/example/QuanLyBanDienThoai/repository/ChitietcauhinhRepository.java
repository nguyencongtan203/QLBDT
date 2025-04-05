package com.example.QuanLyBanDienThoai.repository;

import com.example.QuanLyBanDienThoai.entity.Chitietcauhinh;
import com.example.QuanLyBanDienThoai.entity.ChitietcauhinhId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChitietcauhinhRepository extends JpaRepository<Chitietcauhinh, ChitietcauhinhId> {
}
