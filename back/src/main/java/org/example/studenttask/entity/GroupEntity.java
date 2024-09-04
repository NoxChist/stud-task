package org.example.studenttask.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "group_st")
public class GroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDateTime dateCreated;

    @OneToMany(mappedBy = "group")
    private List<StudentEntity> students;

    @JsonProperty("students")
    public int getStudentCount() {
        if (students == null) {
            return 0;
        }
        return students.size();
    }

    public GroupEntity(Long id) {
        this.id = id;
    }
}
