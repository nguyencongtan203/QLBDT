package com.example.QuanLyBanDienThoai.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
@Order(1)
public class DebugFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println("=== INCOMING REQUEST ===");
        System.out.println("URL: " + req.getRequestURL());
        System.out.println("Method: " + req.getMethod());
        System.out.println("Query: " + req.getQueryString());
        chain.doFilter(request, response);
    }
}