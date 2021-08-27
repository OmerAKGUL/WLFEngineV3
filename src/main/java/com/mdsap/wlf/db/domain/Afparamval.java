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


    @Column(name = "code")
    private String code;


    @Column(name = "idxno", nullable = false)
    private Integer idxno;



    @Column(name = "paramtype", nullable = false)
    private String paramtype;


    @Column(name = "paramgrpname", nullable = false)
    private String paramgrpname;


    @Column(name = "valuetype")
    private String valuetype;

    @Column(name = "valueformat")
    private String valueformat;

    @Column(name = "valueunit")
    private String valueunit;

    @Column(name = "value")
    private String value;

    @Column(name = "descr")
    private String descr;

    @Column(name = "ownersys")
    private String ownersys;

    @Column(name = "createdt")
    private Timestamp createdt;

    @Column(name = "updatedt")
    private Timestamp updatedt;

    @Column(name = "createusr")
    private Integer createusr;

    @Column(name = "updateusr")
    private Integer updateusr;

    @Column(name = "wfstate")
    private String wfstate;

    @Column(name = "wfprocid")
    private Integer wfprocid;

}
