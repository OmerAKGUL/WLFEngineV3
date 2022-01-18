package com.mdsap.wlf.db.domain;

        import lombok.Data;

        import javax.persistence.*;
        import java.io.Serializable;
        import java.sql.Timestamp;
        import java.time.Instant;
        import java.time.LocalDateTime;

@Entity
@Data
@Table(schema = "WLF" ,name = "WLMWLType")
public class Wlmwltype implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Code", nullable = false)
    private String code;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Descr")
    private String descr;

    @Column(name = "PublisherCat")
    private String publishercat;

    @Column(name = "PublisherOrgID")
    private Integer publisherorgid;

    @Column(name = "PublisherName")
    private String publishername;

    @Column(name = "PublishFormat")
    private String publishformat;

    @Column(name = "FilteringType")
    private String filteringtype;

    @Column(name = "CreateDT")
    private Instant createdt;

    @Column(name = "UpdateDT")
    private Instant updatedt;

    @Column(name = "CreateUsr")
    private Integer createusr;

    @Column(name = "UpdateUsr")
    private Integer updateusr;

    @Column(name = "WFState")
    private String wfstate;

    @Column(name = "WFProcID")
    private String wfprocid;




}