package com.jimluisf.spring.data.jpa.tutorial.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "course")
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
            cascade = CascadeType.ALL,
            //In case of not having any records in the Course table and trying to persist first in the course_material table
            //this will allow to persist first the course object in the course table to then allow the record to be inserted in the course_material table
            fetch = FetchType.LAZY, // FetchType.LAZY will bring back only the data from the course_material class, this will not include the data from the course table
            //FetchType.EAGER will bring all the dependent data, so in this case it will bring the data from the course_material and from the course tables
            optional = true // By default optional is true, which means that we are allowed to save a courseMaterial without course.
            // If optional = false there course is mandatory to save as part of courseMaterial
    )
    @JoinColumn( // We have to specify to which column from Course we are referring to
            name = "course_id",
            referencedColumnName = "courseId"
    )

    private Course course;


}
