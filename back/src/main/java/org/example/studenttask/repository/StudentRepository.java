package org.example.studenttask.repository;

import org.example.studenttask.entity.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    Page<StudentEntity> findAllByGroupId(Pageable pageable, Long groupId);
}
