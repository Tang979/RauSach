package com.example.RauSach;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Role {
    ADMIN("08e3b19c-6a9b-4222-9171-dafa2dd50f4d"),
    EMPLOYEE("40b31cff-fc42-45b8-8121-43d4c37dec4b"), // Vai trò quản trị viên, có quyền cao nhất trong hệ thống.
    USER("cc4c9d8c-b016-454e-9b1d-184be6910bc8"); // Vai trò người dùng bình thường, có quyền hạn giới hạn.
    public final String value; // Biến này lưu giá trị số tương ứng với mỗi vai trò.
}