package com.example.QuanLyBanDienThoai.config;

import com.example.QuanLyBanDienThoai.dto.request.KhachHangCreationRequest;
import com.example.QuanLyBanDienThoai.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Configuration
public class SecurityConfig {
    @Autowired
    private KhachHangService khachHangService;
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers(
//                                "/",
//                                "/api/login",
//                                "/oauth2/**",
//                                "/api/register",
//                                "/api/register-google",
//                                "/css/**",
//                                "/js/**",
//                                "/imgs/**",
//                                "/webjars/**",
//                                "/favicon.ico",
//                                "/error"
//                        ).permitAll()
//                        .requestMatchers("/api/**").authenticated()
//                        .anyRequest().authenticated()
//                )
//                .oauth2Login(oauth2 -> oauth2
//                        .loginPage("/api/login")
//                        .authorizationEndpoint(authorization -> authorization
//                                .baseUri("/oauth2/authorization")
//                        )
//                        .redirectionEndpoint(redirection -> redirection
//                                .baseUri("/login/oauth2/code/google") // Không có dấu / cuối
//                        )
//                        .userInfoEndpoint(userInfo -> userInfo
//                                .userService(customOAuth2UserService())
//                        )
//                        .successHandler(authenticationSuccessHandler())
//                )
//                .sessionManagement(session -> session
//                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//                );
//
//        return http.build();
//    }
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
            .csrf(csrf -> csrf.disable()) // Tắt CSRF nếu cần
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/api/**").permitAll()
                    .anyRequest().authenticated() // POST cần auth
            )
            .httpBasic(Customizer.withDefaults()); //Cách mới để bật HTTP Basic Authentication

    return http.build();
}

//    private void handleOAuth2User(OAuth2User oauth2User) {
//        String email = oauth2User.getAttribute("email");
//        String name = oauth2User.getAttribute("name");
//
//        if (khachHangService.findByEmail(email).isEmpty()) {
//            KhachHangCreationRequest request = new KhachHangCreationRequest();
//            request.setTenkh(name);
//            request.setEmail(email);
//            request.setMatkhau(UUID.randomUUID().toString());
//            request.setDiachi("Chưa cập nhật");
//            request.setSdt("Chưa cập nhật");
//            khachHangService.registerAccount(request);
//        }
//    }
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(List.of("http://localhost:8082"));
//        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
//        configuration.setAllowedHeaders(List.of("*"));
//        configuration.setAllowCredentials(true);
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }

    // Bean cấu hình UserDetailsService cho việc quản lý người dùng (nếu dùng user in-memory)
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("12345")) // Mật khẩu mã hóa
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public OAuth2UserService<OAuth2UserRequest, OAuth2User> customOAuth2UserService() {
//        DefaultOAuth2UserService delegate = new DefaultOAuth2UserService();
//        return userRequest -> {
//            System.out.println("Loading user from Google...");
//            OAuth2User oauth2User = delegate.loadUser(userRequest);
//            System.out.println("User attributes: " + oauth2User.getAttributes());
//            return oauth2User;
//        };
//    }
//
//    @Bean
//    public AuthenticationSuccessHandler authenticationSuccessHandler() {
//        return (request, response, authentication) -> {
//            System.out.println("Authentication successful! Redirecting...");
//            OAuth2User oauth2User = (OAuth2User) authentication.getPrincipal();
//
//            // Xử lý đăng ký/đăng nhập
//            String email = oauth2User.getAttribute("email");
//            String name = oauth2User.getAttribute("name");
//
//            if (khachHangService.findByEmail(email).isEmpty()) {
//                KhachHangCreationRequest requestkh = new KhachHangCreationRequest();
//                requestkh.setTenkh(name);
//                requestkh.setEmail(email);
//                requestkh.setMatkhau(UUID.randomUUID().toString());
//                requestkh.setDiachi("Chưa cập nhật");
//                requestkh.setSdt("Chưa cập nhật");
//                khachHangService.registerAccount(requestkh);
//            }
//
//            response.sendRedirect("/api/findall");
//        };
//    }
//
}
