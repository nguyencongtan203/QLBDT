package com.example.QuanLyBanDienThoai.controller;

import com.example.QuanLyBanDienThoai.dto.request.KhachHangCreationRequest;
import com.example.QuanLyBanDienThoai.dto.request.KhachHangLoginRequest;
import com.example.QuanLyBanDienThoai.entity.Khachhang;
import com.example.QuanLyBanDienThoai.service.KhachHangService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/api")
public class KhachHangController {
    @Autowired
    private KhachHangService khachHangService;

    @GetMapping("/findall")
    public String getAllKhachHang(Model model) {
        try {
            List<Khachhang> list = khachHangService.getAllKhachHang();
            model.addAttribute("khachhangList", list);
            return "pages/khachhangList";
        } catch (Exception e) {
            model.addAttribute("message", "Error retrieving list account: " + e.getMessage());
            return "error"; // Một trang lỗi nếu có lỗi xảy ra
        }
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "pages/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        Model model) {
        KhachHangLoginRequest request = new KhachHangLoginRequest(email, password);

        if (khachHangService.loginAccount(request)) {
            return "redirect:/api/findall";
        } else {
            model.addAttribute("error", "Tài khoản hoặc mật khẩu không đúng!");
            return "pages/login";
        }
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "pages/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute KhachHangCreationRequest request, Model model) {
        String message = khachHangService.registerAccount(request);

        if (message.equals("Đăng ký thành công!")) {
            return "redirect:/api/findall";
        } else {
            model.addAttribute("error", message);
            return "pages/register";
        }
    }

    // Xử lý đăng nhập qua Google
    @GetMapping("/register-google")
    public String registerGoogle(@AuthenticationPrincipal OAuth2User oauth2User) {
            return "redirect:/api/findall";
    }

}
