package com.example.back_end.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "salaries")
public class Salaries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer employee_id;
    private Double base_salary;
    private Double bonus;
    private Double deductions;
    private Double total;
    private String month_year;


}
