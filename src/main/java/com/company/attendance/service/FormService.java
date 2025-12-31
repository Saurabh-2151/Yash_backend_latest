package com.company.attendance.service;
import com.company.attendance.entity.Form;
import com.company.attendance.repository.FormRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class FormService {
    private final FormRepository formRepository;
    public Form save(Form form) { return formRepository.save(form); }
    public List<Form> findAll() { return formRepository.findAll(); }
    public Form getById(Long id) { return formRepository.findById(id).orElseThrow(); }
    public void delete(Long id) { formRepository.deleteById(id); }
}

