package com.example.QuanLyBanDienThoai.service;

import com.example.QuanLyBanDienThoai.dto.request.KhachHangCreationRequest;
import com.example.QuanLyBanDienThoai.dto.request.KhachHangLoginRequest;
import com.example.QuanLyBanDienThoai.entity.Khachhang;
import com.example.QuanLyBanDienThoai.repository.KhachhangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhachHangService {
    @Autowired
    private KhachhangRepository khachhangRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public List<Khachhang> getAllKhachHang(){
        return khachhangRepository.findAll();
    }

    public Boolean loginAccount(KhachHangLoginRequest request){
        Optional<Khachhang> accountOpt = khachhangRepository.findByEmail(request.getEmail());

        if (accountOpt.isPresent()) {
            Khachhang account = accountOpt.get();
            if (passwordEncoder.matches(request.getMatkhau(), account.getMatkhau())) {

                return true; // Đăng nhập thành công
            }
        }
        return false; // Sai email hoặc mật khẩu
    }

    public String registerAccount(KhachHangCreationRequest request) {
        // Kiểm tra tài khoản đã tồn tại chưa
        Optional<Khachhang> existingAccount = khachhangRepository.findByEmail(request.getEmail());
        if (existingAccount.isPresent()) {
            return "Tài khoản đã tồn tại!";
        }

        // Tạo đối tượng khách hàng mới
        Khachhang newKhachHang = new Khachhang();
        newKhachHang.setTenkh(request.getTenkh());
        newKhachHang.setDiachi(request.getDiachi());
        newKhachHang.setSdt(request.getSdt());
        newKhachHang.setEmail(request.getEmail());

        // Mã hóa mật khẩu
        newKhachHang.setMatkhau(passwordEncoder.encode(request.getMatkhau()));

        // Lưu vào database
        khachhangRepository.save(newKhachHang);

        return "Đăng ký thành công!";
    }

    public Optional<Khachhang> findByEmail(String email){
        return khachhangRepository.findByEmail(email);
    }
}
