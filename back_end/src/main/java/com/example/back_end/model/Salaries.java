package com.example.back_end.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "salaries")
public class Salaries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double base_salary;
    private Double bonus;
    private Double deductions;
    private Double total;
    private String month_year;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employees employee;
}
