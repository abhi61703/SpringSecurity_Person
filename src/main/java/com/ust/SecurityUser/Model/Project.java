package com.ust.SecurityUser.Model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "project")

public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectId;
    private String psNumber;
    private String projectName;
    private String projectDescription;
    private String projectLink;
    @Enumerated(value = EnumType.STRING)
    private ProjectStatus projectStatus;

}
