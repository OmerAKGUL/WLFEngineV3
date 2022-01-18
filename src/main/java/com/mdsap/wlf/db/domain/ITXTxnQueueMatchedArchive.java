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
@Table(schema = "WLF" ,name = "ITXTxnQueueMatchedArchive")
public class ITXTxnQueueMatchedArchive implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "MatchedArchiveDate")
    private Timestamp matchedarchivedate;

    @Column(name = "ETLJobStart")
    private Timestamp etljobstart;

    @Column(name = "ETLJobSessionD")
    private String etljobsessiond;

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

    @Column(name = "SCSysCustID")
    private String scsyscustid;


    @Column(name = "SCName")
    private String scname;

    @Column(name = "SCMidname")
    private String scmidname;

    @Column(name = "SCSurname")
    private String scsurname;

    @Column(name = "SCFullname")
    private String scfullname;

    @Column(name = "SCBirthDate")
    private Timestamp scbirthdate;

    @Column(name = "SCCommTitle")
    private String sccommtitle;

    //@Enumerated(EnumType.String)
    @Column(name = "SCAddressType")
    private String scaddresstype;

    @Column(name = "SCAddress")
    private String scaddress;

    @Column(name = "SCCity")
    private String sccity;

    @Column(name = "SCNationality")
    private String scnationality;

    @Column(name = "SCNationalID")
    private String scnationalid;

    //@Enumerated(EnumType.String)
    @Column(name = "SCIDType")
    private String scidtype;

    @Column(name = "SCIDNo")
    private String scidno;

    @Column(name = "SCGender")
    private String scgender;

    @Column(name = "SAOrgId")
    private Integer saorgid;

    @Column(name = "SAOrgName")
    private String saorgname;

    @Column(name = "SASysCode")
    private String sasyscode;

    @Column(name = "SABranchCode")
    private String sabranchcode;

    @Column(name = "SAName")
    private String saname;

    @Column(name = "RCSysCustID")
    private String rcsyscustid;

    @Column(name = "RCName")
    private String rcname;

    @Column(name = "RCMidname")
    private String rcmidname;

    @Column(name = "RCSurname")
    private String rcsurname;

    @Column(name = "RCFullname")
    private String rcfullname;

    @Column(name = "RCBirthDate")
    private Timestamp rcbirthdate;

    @Column(name = "RCCommTitle")
    private String rccommtitle;

    //@Enumerated(EnumType.String)
    @Column(name = "RCAddressType")
    private Addrtype rcaddresstype;

    @Column(name = "RCAddress")
    private String rcaddress;

    @Column(name = "RCCity")
    private String rccity;

    @Column(name = "RCNationality")
    private String rcnationality;

    @Column(name = "RCNationalID")
    private String rcnationalid;

    @Column(name = "RCIDType")
    private String rcidtype;

    @Column(name = "RCIDNo")
    private String rcidno;

    @Column(name = "RCGender")
    private String rcgender;

    @Column(name = "RAOrgId")
    private Integer raorgid;

    @Column(name = "RAOrgName")
    private String raorgname;

    @Column(name = "RASysCode")
    private String rasyscode;

    @Column(name = "RABranchCode")
    private String rabranchcode;

    @Column(name = "RAName")
    private String raname;

    @Column(name = "TxnChannelType")
    private String txnchanneltype;

    @Column(name = "TxnSysID")
    private String txnsysid;

    @Column(name = "TxnProdType")
    private String txnprodtype;

    @Column(name = "TxnProdName")
    private String txnprodname;

    @Column(name = "TxnAmount")
    private Double txnamount;

    @Column(name = "TxnDescr")
    private String txndescr;

    @Column(name = "TxnEntitiesUpd")
    private String txnentitiesupd;

    @Column(name = "TxnAgentOrgId")
    private Integer txnagentorgid;

    @Column(name = "TxnAgentBrachId")
    private String txnagentbrachid;

    @Column(name = "TxnAgentType")
    private String txnagenttype;

    @Column(name = "TxnAgentAccID")
    private String txnagentaccid;

    @Column(name = "TxnOrderDate")
    private Timestamp txnorderdate;

    @Column(name = "TxnValueDate")
    private Timestamp txnvaluedate;

    @Column(name="RCType")
    private Integer rctype;

    @Column(name="RAType")
    private Integer ratype;

    @Column(name="SAType")
    private Integer satype;

    @Column(name="SCType")
    private Integer sctype;

    @Column(name="TxnTypeID")
    private Integer txntypeid;

    @Column(name="TxnCurrency")
    private String txncurrency;

    @Column(name="ETLJobType")
    private Integer etljobtype;

    @Column(name="MatchCtxId")
    private Integer matchCtxID;


    @Column(name="MatchTxnId")
    private Integer matchTxnID;


    public ITXTxnQueueMatchedArchive() {

        matchedarchivedate  = Timestamp.valueOf(LocalDateTime.now());

    }


}