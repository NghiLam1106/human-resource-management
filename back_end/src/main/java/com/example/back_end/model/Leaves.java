package com.example.back_end.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "leaves")
public class Leaves {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer employee_id;
    private Date start_date;
    private Date end_date;
    private String reason;
    private Integer status; // 0: pending, 1: approved, 2: rejected

}
