package com.example.homework21.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @Column(columnDefinition = "int default 0")
    private Integer age;

    @Column(columnDefinition = "varchar(30) not null")
    private String email;

    @Column(columnDefinition = "int default 0")
    private Integer salary;

    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private Set<Course> courseSet;

}
