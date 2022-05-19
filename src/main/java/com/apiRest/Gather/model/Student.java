package com.apiRest.Gather.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "student")
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Student {

    @Id
    @Column(name="id", nullable = false)
    @SequenceGenerator(name="student_sequence", sequenceName = "student_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    private long id;
    private String firstname;
    private String lastname;
}
