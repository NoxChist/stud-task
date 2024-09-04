package org.example.studenttask.service;

import lombok.RequiredArgsConstructor;
import org.example.studenttask.entity.GroupEntity;
import org.example.studenttask.repository.GroupRepository;
import org.example.studenttask.service.abstraction.IStudentTaskService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class GroupService implements IStudentTaskService<GroupEntity> {
    private final GroupRepository groupRepository;

    public GroupEntity getById(Long id) {
        return groupRepository.findById(id).orElse(null);
    }

    @Override
    public Page<GroupEntity> getAll(Pageable pageable) {
        return groupRepository.findAll(pageable);
    }

    @Override
    public GroupEntity save(GroupEntity groupEntity) {
        groupEntity.setDateCreated(LocalDateTime.now());
        return groupRepository.save(groupEntity);
    }
}
