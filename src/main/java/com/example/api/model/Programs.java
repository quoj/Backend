package com.example.api.model;

import com.example.api.utils.ImageUtils;
import jakarta.persistence.*;

import java.io.IOException;
import java.math.BigDecimal;

@Entity
@Table(name = "programs")
public class Programs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "program_name", nullable = false, length = 255)
    private String programName;

    @Column(name = "program_description", columnDefinition = "TEXT")
    private String programDescription;

    @Column(name = "total_sessions")
    private Integer totalSessions;

    @Column(name = "tuition", precision = 18, scale = 2)
    private BigDecimal tuition;

    // Lưu ảnh dưới dạng byte[] nén
    @Lob
    @Column(name = "image", columnDefinition = "LONGBLOB")
    private byte[] image;

    // Constructors
    public Programs() {
    }

    // Getter/setter cơ bản
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgramDescription() {
        return programDescription;
    }

    public void setProgramDescription(String programDescription) {
        this.programDescription = programDescription;
    }

    public Integer getTotalSessions() {
        return totalSessions;
    }

    public void setTotalSessions(Integer totalSessions) {
        this.totalSessions = totalSessions;
    }

    public BigDecimal getTuition() {
        return tuition;
    }

    public void setTuition(BigDecimal tuition) {
        this.tuition = tuition;
    }

    // Nén khi set ảnh
    public void setImage(byte[] image) {
        try {
            this.image = ImageUtils.compressImage(image); // Nén ảnh khi lưu
        } catch (IOException e) {
            throw new RuntimeException("Error compressing image", e);
        }
    }

    // Giải nén khi get ảnh
    public byte[] getImage() {
        try {
            return ImageUtils.decompressImage(this.image); // Giải nén ảnh khi lấy
        } catch (IOException e) {
            throw new RuntimeException("Error decompressing image", e);
        }
    }
}