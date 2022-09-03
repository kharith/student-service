package com.greenlab.studentservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "STUDENT")
public class Student {
    @Id
    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDateTime dob;
    private int nic;
    private LocalDateTime lastModifiedDate;
    private LocalDateTime createdDate;
    private LocalDateTime deletedDate;
}
