// src/main/java/com/example/api/dto/AttendanceDTO.java
package com.example.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceDTO {
    private Long id;
    private Long studentId;
    private Integer classId;      // giữ như cũ
    private String studentName;   // ✨ thêm dòng này
    private String status;
    private LocalDateTime date;
    private String note;
}
