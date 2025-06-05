package com.example.back_end.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
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
    private Integer department_id;
    private Integer position_id;
    private Integer salary;
    private Date join_date;
    private Integer status; // 0: inactive, 1: active, 2: probation

}
