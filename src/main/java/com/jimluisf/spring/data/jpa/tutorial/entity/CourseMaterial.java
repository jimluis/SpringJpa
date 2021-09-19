package com.jimluisf.spring.data.jpa.tutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseMaterial
{
    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne(// adding foreign key
            cascade = CascadeType.ALL
            //In case of not having any records in the Course table and trying to persist first in the course_material table
            //this will allow to persist first the course object in the course table to then allow the record to be inserted in the course_material table
    )
    @JoinColumn( // We have to specify to which column from Course we are referring to
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;


}
