package com.example.api.dto;

import java.math.BigDecimal;

public class ProgramDTO {
    private Long id;
    private String programName;
    private String programDescription;
    private Integer totalSessions;
    private BigDecimal tuition;

    // Trường ảnh dưới dạng base64
    private String imageBase64;

    // Constructors
    public ProgramDTO() {
    }

    public ProgramDTO(Long id, String programName, String programDescription, Integer totalSessions,
                      BigDecimal tuition, String imageBase64) {
        this.id = id;
        this.programName = programName;
        this.programDescription = programDescription;
        this.totalSessions = totalSessions;
        this.tuition = tuition;
        this.imageBase64 = imageBase64;
    }

    // Getters and Setters
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

    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }
}
