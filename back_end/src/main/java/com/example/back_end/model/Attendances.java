package com.example.back_end.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "attendances")
public class Attendances {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer employee_id;
    private Date check_in;
    private Date check_out;
    private Date work_date;

}
