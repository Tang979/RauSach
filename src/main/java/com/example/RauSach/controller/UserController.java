package com.example.RauSach.controller;

import com.example.RauSach.model.User;
import com.example.RauSach.repository.UserRepository;
import com.example.RauSach.service.EmailService;
import com.example.RauSach.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller // Đánh dấu lớp này là một Controller trong Spring MVC.
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailService emailService;
    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "users/login";
    }

    @GetMapping("/register")
    public String register(@NotNull Model model) {
        model.addAttribute("user", new User()); // Thêm một đối tượng User mới vào model
        return "users/register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") User user, // Validate đối tượng User
            @NotNull BindingResult bindingResult, // Kết quả của quá trình validate
            Model model) {
        if (bindingResult.hasErrors()) { // Kiểm tra nếu có lỗi validate
            var errors = bindingResult.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .toArray(String[]::new);
            model.addAttribute("errors", errors);
            return "users/register"; // Trả về lại view "register" nếu có lỗi
        }

        userService.save(user); // Lưu người dùng vào cơ sở dữ liệu
        userService.setDefaultRole(user.getUsername()); // Gán vai trò mặc định cho người dùng
        return "redirect:/login"; // Chuyển hướng người dùng tới trang "login"
    }
    //Chức năng quên mật khẩu gửi email để lấy lại
    @GetMapping("/forgot")
    public String forgotPasswordForm() {
        return "users/forgot-password";
    }

    @PostMapping("/forgot")
    public String forgotPassword(@RequestParam String email, Model model) {
        Optional<User> user = userRepository.findByEmail(email);
        if (!user.isPresent()) {
            model.addAttribute("error", "Email không tồn tại");
            return "users/forgot-password";
        }
        String token = userService.generateUniqueToken();
        userService.createPasswordResetTokenForUser(user.get(), token);

        String resetUrl = "http://localhost:8080/reset?token=" + token;
        emailService.sendEmail(email, "Đặt lại mật khẩu", "Nhấn vào liên kết để đặt lại mật khẩu: " + resetUrl);

        model.addAttribute("message", "Email reset mật khẩu đã được gửi!");
        return "users/forgot-password";
    }

    @GetMapping("/reset")
    public String showResetPasswordForm(@RequestParam String token, Model model) {
        model.addAttribute("token", token);
        return "users/reset-password";
    }

    @PostMapping("/reset")
    public String resetPassword(@RequestParam String token, @RequestParam String newPassword, Model model) {
        if (!userService.validatePasswordResetToken(token)) {
            model.addAttribute("error", "Token không hợp lệ hoặc đã hết hạn");
            return "users/reset-password";
        }
        String encodedPassword = new BCryptPasswordEncoder().encode(newPassword);  // Mã hóa mật khẩu
        userService.resetPassword(token, encodedPassword);
        return "redirect:/login";
    }
}
