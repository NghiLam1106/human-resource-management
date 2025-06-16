package com.example.back_end.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String full_name;
    private String email;
    private String phone;
    private String address;
    private Integer gender;
    private Date birth;
    private Integer salary;
    private Date join_date;
    private Integer status; // 0: inactive, 1: active, 2: probation

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departments department;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Positions position;
}
