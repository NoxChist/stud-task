package org.example.studenttask.controller;

import lombok.RequiredArgsConstructor;
import org.example.studenttask.controller.abstraction.STaskController;
import org.example.studenttask.entity.StudentEntity;
import org.example.studenttask.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentController extends STaskController<StudentEntity> {
    private final StudentService baseService;

    private final String defaultSortColm = "name";
    private final String defaultSortDir = "asc";
    private final String defaultSize = "10";

    @GetMapping("/group/{id}")
    public Page<StudentEntity> getByGroupId(@PathVariable Long id,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = defaultSize) int size,
                                            @RequestParam(defaultValue = defaultSortColm) String sortBy,
                                            @RequestParam(defaultValue = defaultSortDir) String sortDir) {
        Sort.Direction direction = Sort.Direction.fromString(sortDir);
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        return baseService.getByGroupId(pageable, id);
    }

    @Override
    public Page<StudentEntity> getAll(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = defaultSize) int size,
                                      @RequestParam(defaultValue = defaultSortColm) String sortBy,
                                      @RequestParam(defaultValue = defaultSortDir) String sortDir) {
        Sort.Direction direction = Sort.Direction.fromString(sortDir);
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        return baseService.getAll(pageable);
    }

    @Override
    public StudentEntity save(@RequestBody StudentEntity studentEntity) {
        return baseService.save(studentEntity);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody StudentEntity studentEntity) {
        return baseService.delete(studentEntity);
    }
}
