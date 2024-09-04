package org.example.studenttask.controller.abstraction;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("")

public abstract class STaskController<T> {
    @GetMapping
    public abstract Page<T> getAll(int page, int size, String sortBy, String sortDir);

    @PostMapping("/create")
    public abstract T save(T t);
}
