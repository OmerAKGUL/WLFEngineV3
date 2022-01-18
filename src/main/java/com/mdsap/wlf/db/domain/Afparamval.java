package com.mdsap.wlf.db.domain;

import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Data
@Table(schema = "WLF" ,name = "AFParamval")
public class Afparamval {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    @Column(name = "Code")
    private String code;


    @Column(name = "IdxNo", nullable = false)
    private Integer idxno;



    @Column(name = "ParamType", nullable = false)
    private String paramtype;


    @Column(name = "ParamGrpName", nullable = false)
    private String paramgrpname;


    @Column(name = "ValueType")
    private String valuetype;

    @Column(name = "ValueFormat")
    private String valueformat;

    @Column(name = "ValueUnit")
    private String valueunit;

    @Column(name = "Value")
    private String value;

    @Column(name = "Descr")
    private String descr;

    @Column(name = "OwnerSys")
    private String ownersys;

    @Column(name = "CreateDT")
    private Timestamp createdt;

    @Column(name = "UpdateDT")
    private Timestamp updatedt;

    @Column(name = "CreateUsr")
    private Integer createusr;

    @Column(name = "UpdateUsr")
    private Integer updateusr;

    @Column(name = "WFState")
    private String wfstate;

    @Column(name = "WFProcID")
    private Integer wfprocid;

}
