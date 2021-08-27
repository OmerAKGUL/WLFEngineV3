package com.mdsap.wlf.db.domain;
import java.io.Serializable;

import javax.persistence.*;

import com.mdsap.wlf.db.config.AfparamvalParams;
import com.mdsap.wlf.db.domain.enumeration.Addrtype;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;

import java.sql.Timestamp;


/**
 * The persistent class for the "VITXTxnQueueDev" database table.
 *
 */
@Entity
@Data @NoArgsConstructor
@Table(schema = "WLF" ,name = "vtopitxtxnqueue")
public class ITXTxnQueue implements Serializable {
	private static final long serialVersionUID = 1L;

	private static Logger log  = Logger.getLogger(ITXTxnQueue.class);

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

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

	public String getDataSc(String value)
	{
		switch (value) {
			case AfparamvalParams.MATCH_FIELD_FULL_NAME:
				return this.getScfullname();
		/*	case AfparamvalParams.MATCH_FIELD_CITY:
				return this.getSccity();
			case AfparamvalParams.MATCH_FIELD_ADDRESS:
				return this.getScaddress();

		 */
			case AfparamvalParams.MATCH_FIELD_NATIONALITY:
				return this.getScnationality();
			case AfparamvalParams.MATCH_FIELD_NATIONALITY_ID:
				return this.getScnationalid();

		}
		return null;
	}


	public String getDataRc(String value)
	{
		switch (value) {
			case AfparamvalParams.MATCH_FIELD_FULL_NAME:
				return this.getRcfullname();
		/*	case AfparamvalParams.MATCH_FIELD_CITY:
				return this.getRccity();
			case AfparamvalParams.MATCH_FIELD_ADDRESS:
				return this.getRcaddress();

		 */
			case AfparamvalParams.MATCH_FIELD_NATIONALITY:
				return this.getRcnationality();
			case AfparamvalParams.MATCH_FIELD_NATIONALITY_ID:
				return this.getRcnationalid();

		}
		return null;
	}

	public ITXTxnQueueMatchedArchive getRowAsMatchedArchive()
	{
		ITXTxnQueueMatchedArchive row = new ITXTxnQueueMatchedArchive();
		row.setMatchTxnID(this.getId());
		row.setEtljobstart(this.getEtljobstart());
		row.setEtljobsessiond(this.getEtljobsessiond());
		row.setCreatedt(this.getCreatedt());
		row.setUpdatedt(this.getUpdatedt());
		row.setCreateusr(this.getCreateusr());
		row.setUpdateusr(this.getUpdateusr());
		row.setWfstate(this.getWfstate());
		row.setWfprocid(this.getWfprocid());
		row.setScsyscustid(this.getScsyscustid());
		row.setScname(this.getScname());
		row.setScmidname(this.getScmidname());
		row.setScsurname(this.getScsurname());
		row.setScfullname(this.getScfullname());
		row.setScbirthdate(this.getScbirthdate());
		row.setSccommtitle(this.getSccommtitle());
		row.setScaddresstype(this.getScaddresstype());
		row.setScaddress(this.getScaddress());
		row.setSccity(this.getSccity());
		row.setScnationality(this.getScnationality());
		row.setScnationalid(this.getScnationalid());
		row.setScidtype(this.getScidtype());
		row.setScidno(this.getScidno());
		row.setScgender(this.getScgender());
		row.setSaorgid(this.getSaorgid());
		row.setSaorgname(this.getSaorgname());
		row.setSasyscode(this.getSasyscode());
		row.setSabranchcode(this.getSabranchcode());
		row.setSaname(this.getSaname());
		row.setRcsyscustid(this.getRcsyscustid());
		row.setRcname(this.getRcname());
		row.setRcmidname(this.getRcmidname());
		row.setRcsurname(this.getRcsurname());
		row.setRcfullname(this.getRcfullname());

		row.setRcbirthdate(this.getRcbirthdate());
		row.setRccommtitle(this.getRccommtitle());
		row.setRcaddresstype(this.getRcaddresstype());
		row.setRcaddress(this.getRcaddress());
		row.setRccity(this.getRccity());
		row.setRcnationality(this.getRcnationality());
		row.setRcnationalid(this.getRcnationalid());
		row.setRcidtype(this.getRcidtype());
		row.setRcidno(this.getRcidno());
		row.setRcgender(this.getRcgender());
		row.setRaorgid(this.getRaorgid());
		row.setRaorgname(this.getRaorgname());
		row.setRasyscode(this.getRasyscode());
		row.setRaname(this.getRaname());
		row.setTxnchanneltype(this.getTxnchanneltype());
		row.setTxnsysid(this.getTxnsysid());
		row.setTxnprodtype(this.getTxnprodtype());
		row.setTxnprodname(this.getTxnprodname());
		row.setTxnamount(this.getTxnamount());
		row.setTxndescr(this.getTxndescr());
		row.setTxnentitiesupd(this.getTxnentitiesupd());
		row.setTxnagentorgid(this.getTxnagentorgid());
		row.setTxnagentbrachid(this.getTxnagentbrachid());
		row.setTxnagenttype(this.getTxnagenttype());
		row.setTxnagentaccid(this.getTxnagentaccid());
		row.setTxnorderdate(this.getTxnorderdate());
		row.setTxnvaluedate(this.getTxnvaluedate());
		row.setRctype(this.getRctype());
		row.setRatype(this.getRatype());
		row.setSatype(this.getSatype());
		row.setSctype(this.getSctype());
		row.setTxntypeid(this.getTxntypeid());
		row.setTxncurrency(this.getTxncurrency());
		row.setEtljobtype(this.getEtljobtype());
		return row;
	}

}