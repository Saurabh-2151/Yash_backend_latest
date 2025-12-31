package com.company.attendance.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDateTime;

@Data
public class CaseDocumentDto {
    private Long id;
    
    @NotBlank(message = "Document name is required")
    private String documentName;
    
    private String fileName;
    private String filePath;
    private String fileType;
    private Long fileSize;
    private String description;
    private Long caseId;
    private String caseNumber;
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long createdBy;
    private Long updatedBy;
    
    // For file upload
    private MultipartFile file;
    
    // Explicit getters/setters used by services/controllers (defensive if Lombok is not processed)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
