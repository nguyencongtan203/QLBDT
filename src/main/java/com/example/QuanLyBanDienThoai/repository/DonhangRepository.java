package com.example.QuanLyBanDienThoai.repository;

import com.example.QuanLyBanDienThoai.entity.Donhang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonhangRepository extends JpaRepository<Donhang,Integer> {
}
