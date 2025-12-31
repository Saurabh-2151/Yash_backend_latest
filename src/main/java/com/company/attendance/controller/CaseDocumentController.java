package com.company.attendance.controller;

import com.company.attendance.dto.CaseDocumentDto;
import com.company.attendance.service.CaseDocumentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/case-documents")
@RequiredArgsConstructor
public class CaseDocumentController {
    
    private static final Logger log = LoggerFactory.getLogger(CaseDocumentController.class);

    private final CaseDocumentService caseDocumentService;

    @PostMapping("/upload")
    public ResponseEntity<CaseDocumentDto> uploadDocument(
            @RequestParam("file") MultipartFile file,
            @RequestParam("caseId") Long caseId,
            @RequestParam(value = "documentName", required = false) String documentName,
            @RequestParam(value = "description", required = false) String description) {
        log.info("POST /api/case-documents/upload - Uploading document for case: {}", caseId);
        
        try {
            CaseDocumentDto documentDto = new CaseDocumentDto();
            documentDto.setCaseId(caseId);
            documentDto.setDocumentName(documentName);
            documentDto.setDescription(description);
            
            CaseDocumentDto uploadedDocument = caseDocumentService.uploadDocument(documentDto, file);
            return ResponseEntity.status(HttpStatus.CREATED).body(uploadedDocument);
            
        } catch (Exception e) {
            log.error("Error uploading document: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CaseDocumentDto> updateDocument(@PathVariable Long id, @Valid @RequestBody CaseDocumentDto documentDto) {
        log.info("PUT /api/case-documents/{} - Updating document", id);
        try {
            CaseDocumentDto updatedDocument = caseDocumentService.updateDocument(id, documentDto);
            return ResponseEntity.ok(updatedDocument);
        } catch (Exception e) {
            log.error("Error updating document: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CaseDocumentDto> getDocumentById(@PathVariable Long id) {
        log.info("GET /api/case-documents/{} - Fetching document", id);
        try {
            CaseDocumentDto documentDto = caseDocumentService.getDocumentById(id);
            return ResponseEntity.ok(documentDto);
        } catch (Exception e) {
            log.error("Error fetching document: {}", e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/case/{caseId}")
    public ResponseEntity<List<CaseDocumentDto>> getDocumentsByCaseId(@PathVariable Long caseId) {
        log.info("GET /api/case-documents/case/{} - Fetching documents for case", caseId);
        try {
            List<CaseDocumentDto> documents = caseDocumentService.getDocumentsByCaseId(caseId);
            return ResponseEntity.ok(documents);
        } catch (Exception e) {
            log.error("Error fetching documents for case: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<CaseDocumentDto>> searchDocuments(@RequestParam String search) {
        log.info("GET /api/case-documents/search - Searching documents with term: {}", search);
        try {
            List<CaseDocumentDto> documents = caseDocumentService.searchDocuments(search);
            return ResponseEntity.ok(documents);
        } catch (Exception e) {
            log.error("Error searching documents: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
    
    @GetMapping("/case/{caseId}/count")
    public ResponseEntity<Long> getDocumentsCountByCaseId(@PathVariable Long caseId) {
        log.info("GET /api/case-documents/case/{}/count - Getting documents count for case", caseId);
        try {
            Long count = caseDocumentService.getDocumentsCountByCaseId(caseId);
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            log.error("Error getting documents count for case: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
    
    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> downloadDocument(@PathVariable Long id) {
        log.info("GET /api/case-documents/download/{} - Downloading document", id);
        try {
            CaseDocumentDto documentDto = caseDocumentService.getDocumentById(id);
            
            byte[] fileContent = caseDocumentService.downloadDocument(id);
            
            Resource resource = new ByteArrayResource(fileContent) {
                @Override
                public String getFilename() {
                    return documentDto.getFileName();
                }
            };
            
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + documentDto.getFileName() + "\"")
                    .body(resource);
                    
        } catch (IOException e) {
            log.error("Error downloading document: {}", e.getMessage());
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            log.error("Error fetching document for download: {}", e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocument(@PathVariable Long id) {
        log.info("DELETE /api/case-documents/{} - Deleting document", id);
        try {
            caseDocumentService.deleteDocument(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            log.error("Error deleting document: {}", e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}
