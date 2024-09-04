package org.example.studenttask.controller;

import lombok.RequiredArgsConstructor;
import org.example.studenttask.controller.abstraction.STaskController;
import org.example.studenttask.entity.GroupEntity;
import org.example.studenttask.service.GroupService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/group")
public class GroupController extends STaskController<GroupEntity> {
    private final GroupService baseService;

    private final String defaultSortColm = "dateCreated";
    private final String defaultSortDir = "desc";
    private final String defaultSize = "10";

    /*@GetMapping("/{id}")
    public Page<StudentEntity> getStudentsByGroupId(@PathVariable Long id
    ) {
        return baseService.getStudentsByGroupId(id);
    }*/

    @Override
    public Page<GroupEntity> getAll(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = defaultSize) int size,
                                    @RequestParam(defaultValue = defaultSortColm) String sortBy,
                                    @RequestParam(defaultValue = defaultSortDir) String sortDir) {
        Sort.Direction direction = Sort.Direction.fromString(sortDir);
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        return baseService.getAll(pageable);
    }

    @Override
    public GroupEntity save(@RequestBody GroupEntity groupEntity) {
        System.out.println();
        return baseService.save(groupEntity);
    }

}
