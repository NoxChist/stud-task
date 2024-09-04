package org.example.studenttask.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private Date dateAdmission;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", nullable = false)
    private GroupEntity group;

    @JsonProperty("group")
    public String getGroupName() {
        return group.getName();
    }

    @JsonProperty("dateAdmission")
    public String getDateAdmissionFormatted() {
        SimpleDateFormat date = new SimpleDateFormat("dd.MM.yyyy");
        return date.format(dateAdmission);
    }

}
