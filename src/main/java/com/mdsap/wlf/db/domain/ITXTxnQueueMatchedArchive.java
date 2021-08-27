package com.mdsap.wlf.db.domain;
import java.io.Serializable;

import javax.persistence.*;

import com.mdsap.wlf.db.config.AfparamvalParams;
import com.mdsap.wlf.db.domain.enumeration.Addrtype;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;


/**
 * The persistent class for the "ITXTxnQueueMatchedArchive" database table.
 *
 */
@Entity
@Data
@Table(schema = "WLF" ,name = "itxtxnqueuematchedarchive")
public class ITXTxnQueueMatchedArchive implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "matchedarchivedate")
    private Timestamp matchedarchivedate;

    @Column(name = "etljobstart")
    private Timestamp etljobstart;

    @Column(name = "etljobsessiond")
    private String etljobsessiond;

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

    @Column(name = "scsyscustid")
    private String scsyscustid;


    @Column(name = "scname")
    private String scname;

    @Column(name = "scmidname")
    private String scmidname;

    @Column(name = "scsurname")
    private String scsurname;

    @Column(name = "scfullname")
    private String scfullname;

    @Column(name = "scbirthdate")
    private Timestamp scbirthdate;

    @Column(name = "sccommtitle")
    private String sccommtitle;

    //@Enumerated(EnumType.String)
    @Column(name = "scaddresstype")
    private String scaddresstype;

    @Column(name = "scaddress")
    private String scaddress;

    @Column(name = "sccity")
    private String sccity;

    @Column(name = "scnationality")
    private String scnationality;

    @Column(name = "scnationalid")
    private String scnationalid;

    //@Enumerated(EnumType.String)
    @Column(name = "scidtype")
    private String scidtype;

    @Column(name = "scidno")
    private String scidno;

    @Column(name = "scgender")
    private String scgender;

    @Column(name = "saorgid")
    private Integer saorgid;

    @Column(name = "saorgname")
    private String saorgname;

    @Column(name = "sasyscode")
    private String sasyscode;

    @Column(name = "sabranchcode")
    private String sabranchcode;

    @Column(name = "saname")
    private String saname;

    @Column(name = "rcsyscustid")
    private String rcsyscustid;

    @Column(name = "rcname")
    private String rcname;

    @Column(name = "rcmidname")
    private String rcmidname;

    @Column(name = "rcsurname")
    private String rcsurname;

    @Column(name = "rcfullname")
    private String rcfullname;

    @Column(name = "rcbirthdate")
    private Timestamp rcbirthdate;

    @Column(name = "rccommtitle")
    private String rccommtitle;

    //@Enumerated(EnumType.String)
    @Column(name = "rcaddresstype")
    private Addrtype rcaddresstype;

    @Column(name = "rcaddress")
    private String rcaddress;

    @Column(name = "rccity")
    private String rccity;

    @Column(name = "rcnationality")
    private String rcnationality;

    @Column(name = "rcnationalid")
    private String rcnationalid;

    @Column(name = "rcidtype")
    private String rcidtype;

    @Column(name = "rcidno")
    private String rcidno;

    @Column(name = "rcgender")
    private String rcgender;

    @Column(name = "raorgid")
    private Integer raorgid;

    @Column(name = "raorgname")
    private String raorgname;

    @Column(name = "rasyscode")
    private String rasyscode;

    @Column(name = "rabranchcode")
    private String rabranchcode;

    @Column(name = "raname")
    private String raname;

    @Column(name = "txnchanneltype")
    private String txnchanneltype;

    @Column(name = "txnsysid")
    private String txnsysid;

    @Column(name = "txnprodtype")
    private String txnprodtype;

    @Column(name = "txnprodname")
    private String txnprodname;

    @Column(name = "txnamount")
    private Double txnamount;

    @Column(name = "txndescr")
    private String txndescr;

    @Column(name = "txnentitiesupd")
    private String txnentitiesupd;

    @Column(name = "txnagentorgid")
    private Integer txnagentorgid;

    @Column(name = "txnagentbrachid")
    private String txnagentbrachid;

    @Column(name = "txnagenttype")
    private String txnagenttype;

    @Column(name = "txnagentaccid")
    private String txnagentaccid;

    @Column(name = "txnorderdate")
    private Timestamp txnorderdate;

    @Column(name = "txnvaluedate")
    private Timestamp txnvaluedate;

    @Column(name="rctype")
    private Integer rctype;

    @Column(name="ratype")
    private Integer ratype;

    @Column(name="satype")
    private Integer satype;

    @Column(name="sctype")
    private Integer sctype;

    @Column(name="txntypeid")
    private Integer txntypeid;

    @Column(name="txncurrency")
    private String txncurrency;

    @Column(name="etljobtype")
    private Integer etljobtype;

    @Column(name="matchctxid")
    private Integer matchCtxID;


    @Column(name="matchtxnid")
    private Integer matchTxnID;


    public ITXTxnQueueMatchedArchive() {

        matchedarchivedate  = Timestamp.valueOf(LocalDateTime.now());

    }


}