package com.springbatch.demobatch.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "persons")
public class Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "last_name")
    private String lastName;

    private int age;

    @Column(name = "insertion_date")
    private String insertionDate;

}
