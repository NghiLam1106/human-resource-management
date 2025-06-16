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
@Table(name = "attendances")
public class Attendances {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date check_in;
    private Date check_out;
    private Date work_date;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employees employee;
}
