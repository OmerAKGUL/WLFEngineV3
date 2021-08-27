package com.mdsap.wlf.db.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data
@Table(schema = "WLF" ,name = "itxtxnqueueid")
public class ITXTxnQueueId implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Integer id;

    @Column(name="itxtxnqueueid")
    private Integer itxtxnqueueID;

    @Column(name="inserttime")
    private Timestamp insertTime;

    public ITXTxnQueueId() {

        insertTime  = Timestamp.valueOf(LocalDateTime.now());
        itxtxnqueueID = null;

    }



}