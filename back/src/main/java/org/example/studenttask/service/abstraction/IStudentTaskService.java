package org.example.studenttask.service.abstraction;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStudentTaskService<T> {
    public Page<T> getAll(Pageable pageable);

    public T save(T t);
}
