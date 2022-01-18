package com.mdsap.wlf.db.domain;


import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Data
@Table(schema = "WLF" ,name = "MEConfig")
public class MEConfig {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="Code")
    private String code;

    @Column(name="Name")
    private String name;

    @Column(name="Descr")
    private String descr;

    @Column(name="WLFieldList")
    private String wlFieldList;

    @Column(name="ScheduleID")
    private Integer scheduleID;

    @Column(name="CreateDT")
    private Timestamp createDT;

    @Column(name="UpdateDT")
    private Timestamp updateDT;

    @Column(name="CreateUsr")
    private Integer createUsr;

    @Column(name="UpdateUsr")
    private Integer updateUsr;

    @Column(name="WFState")
    private String wfState;

    @Column(name="WFProcID")
    private Integer wfProcID;



}
