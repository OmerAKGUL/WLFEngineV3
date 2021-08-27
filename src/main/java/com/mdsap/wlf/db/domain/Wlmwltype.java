package com.mdsap.wlf.db.domain;

        import lombok.Data;

        import javax.persistence.*;
        import java.io.Serializable;
        import java.sql.Timestamp;
        import java.time.Instant;
        import java.time.LocalDateTime;

@Entity
@Data
@Table(schema = "WLF" ,name = "Wlmwltype")
public class Wlmwltype implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "descr")
    private String descr;

    @Column(name = "publishercat")
    private String publishercat;

    @Column(name = "publisherorgid")
    private Integer publisherorgid;

    @Column(name = "publishername")
    private String publishername;

    @Column(name = "publishformat")
    private String publishformat;

    @Column(name = "filteringtype")
    private String filteringtype;

    @Column(name = "createdt")
    private Instant createdt;

    @Column(name = "updatedt")
    private Instant updatedt;

    @Column(name = "createusr")
    private Integer createusr;

    @Column(name = "updateusr")
    private Integer updateusr;

    @Column(name = "wfstate")
    private String wfstate;

    @Column(name = "wfprocid")
    private String wfprocid;




}