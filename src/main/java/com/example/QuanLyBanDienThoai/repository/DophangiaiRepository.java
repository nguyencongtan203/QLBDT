package com.example.QuanLyBanDienThoai.repository;

import com.example.QuanLyBanDienThoai.entity.Dophangiai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DophangiaiRepository extends JpaRepository<Dophangiai,Integer> {
}
