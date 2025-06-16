package com.example.back_end.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "leaves")
public class Leaves {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private Date start_date;
    private Date end_date;
    private String reason;
    private Integer status; // 0: pending, 1: approved, 2: rejected

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employees employee;
}
