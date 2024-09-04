package org.example.studenttask.service;

import lombok.RequiredArgsConstructor;
import org.example.studenttask.entity.StudentEntity;
import org.example.studenttask.repository.StudentRepository;
import org.example.studenttask.service.abstraction.IStudentTaskService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@RequiredArgsConstructor
@Service
public class StudentService implements IStudentTaskService<StudentEntity> {
    private final StudentRepository studentRepository;
    private final GroupService groupService;

    @Override
    public Page<StudentEntity> getAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public StudentEntity save(StudentEntity studentEntity) {
        studentEntity.setDateAdmission(new Date());
        return studentRepository.save(studentEntity);
    }

    public ResponseEntity<String> delete(StudentEntity studentEntity) {
        studentRepository.delete(studentEntity);
        if (studentRepository.existsById(studentEntity.getId())) {
            return new ResponseEntity<String>("ERROR", HttpStatusCode.valueOf(400));
        }
        return new ResponseEntity<String>("OK", HttpStatusCode.valueOf(200));
    }

    public Page<StudentEntity> getByGroupId(Pageable pageable, Long groupId) {
        return studentRepository.findAllByGroupId(pageable, groupId);
    }

}
