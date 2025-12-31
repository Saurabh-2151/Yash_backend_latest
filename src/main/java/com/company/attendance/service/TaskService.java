package com.company.attendance.service;
import com.company.attendance.entity.Task;
import com.company.attendance.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    public Task save(Task task) { return taskRepository.save(task); }
    public List<Task> findAll() { return taskRepository.findAll(); }
    public Task getById(Long id) { return taskRepository.findById(id).orElseThrow(); }
    public void delete(Long id) { taskRepository.deleteById(id); }
}

