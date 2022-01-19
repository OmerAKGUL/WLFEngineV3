package com.mdsap.wlf.db.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(schema = "WLF" ,name = "EngineClusterConfig")
public class EngineClusterConfig {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="Server")
    private String Server;

    @Column(name="ServerConfigId")
    private Integer ServerConfigId;

    @Column(name="TopNTransaction")
    private Integer TopNTransaction;

}
