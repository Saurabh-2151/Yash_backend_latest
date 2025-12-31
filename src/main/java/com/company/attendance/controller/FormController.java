package com.company.attendance.controller;
import com.company.attendance.dto.FormDto;
import com.company.attendance.entity.Form;
import com.company.attendance.mapper.FormMapper;
import com.company.attendance.service.FormService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api/forms")
@RequiredArgsConstructor
public class FormController {
    private final FormService formService;
    private final FormMapper formMapper;
    @GetMapping
    public ResponseEntity<List<FormDto>> listForms() {
        var forms = formService.findAll();
        var dtos = forms.stream().map(formMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<FormDto> getForm(@PathVariable Long id) {
        return ResponseEntity.ok(formMapper.toDto(formService.getById(id)));
    }
    @PostMapping
    public ResponseEntity<FormDto> createForm(@Valid @RequestBody FormDto dto) {
        Form form = formService.save(formMapper.toEntity(dto));
        return ResponseEntity.ok(formMapper.toDto(form));
    }
    @PutMapping("/{id}")
    public ResponseEntity<FormDto> updateForm(@PathVariable Long id, @RequestBody FormDto dto) {
        Form f = formService.getById(id);
        Form saved = formService.save(formMapper.toEntity(dto));
        return ResponseEntity.ok(formMapper.toDto(saved));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteForm(@PathVariable Long id) {
        formService.delete(id);
        return ResponseEntity.ok().build();
    }
}

