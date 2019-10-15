package com.ebbinghaus.repository.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_task")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "task_value")
    private String taskValue;

    @Column(name = "update_time")
    private String updateTime;

    @Column(name = "mm_5")
    private Integer mm5;

    @Column(name = "mm_30")
    private Integer mm30;

    @Column(name = "hh_12")
    private Integer hh12;

    @Column(name = "dd_1")
    private Integer dd1;

    @Column(name = "dd_2")
    private Integer dd2;

    @Column(name = "dd_4")
    private Integer dd4;

    @Column(name = "dd_7")
    private Integer dd7;

    @Column(name = "dd_15")
    private Integer dd15;

    @Column(name = "dd_30")
    private Integer dd30;

    @Column(name = "mt_3")
    private Integer mt3;

    @Column(name = "mt_6")
    private Integer mt6;
}
