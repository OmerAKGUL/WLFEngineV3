package com.mdsap.wlf.db.domain;
import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

import com.mdsap.wlf.db.config.AfparamvalParams;
import com.mdsap.wlf.db.domain.enumeration.Addrtype;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the "VITXTxnQueueDev" database table.
 *
 */
@Entity
@Data @NoArgsConstructor
@Table(schema = "WLF" ,name = "VTopITXTxnQueue")
public class ITXTxnQueue implements Serializable {
	private static final long serialVersionUID = 1L;

	private static Logger log  = Logger.getLogger(ITXTxnQueue.class);

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

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


	@Column(name="SCMobilePhone")
	private String SCMobilePhone;
	@Column(name="SCEmail")
	private String SCEmail;
	@Column(name = "SCDateofNationalID")
	private Timestamp SCDateofNationalID;
	@Column(name = "SCValidityDateofNationalID")
	private Timestamp SCValidityDateofNationalID;
	@Column(name="SCNationalIDCounty")
	private String SCNationalIDCounty;
	@Column(name="SCCounty")
	private String SCCounty;
	@Column(name="SCAccountNo")
	private String SCAccountNo;
	@Column(name="RCPlaceofBirth")
	private String RCPlaceofBirth;
	@Column(name="RCProfession")
	private String RCProfession;
	@Column(name="RCMobilePhone")
	private String RCMobilePhone;
	@Column(name="RCEmail")
	private String RCEmail;
	@Column(name = "RCDateofNationalID")
	private Timestamp RCDateofNationalID;
	@Column(name="RCValidityDateofNationalID")
	private Timestamp RCValidityDateofNationalID;
	@Column(name="RCNationalIDCounty")
	private String RCNationalIDCounty;
	@Column(name="RCCounty")
	private String RCCounty;
	@Column(name="RCAccountNo")
	private String RCAccountNo;
	@Column(name="CenterName")
	private String CenterName;
	@Column(name="CenterNo")
	private BigDecimal CenterNo;
	@Column(name="PeymentCenterName")
	private String PeymentCenterName;
	@Column(name="PeymentCenterNo")
	private BigDecimal PeymentCenterNo;
	@Column(name="ExchangeRate")
	private BigDecimal ExchangeRate;
	@Column(name="TLAmount")
	private BigDecimal TLAmount;
	@Column(name="Cost")
	private BigDecimal Cost;
	@Column(name="CostType")
	private String CostType;
	@Column(name="PeymentType")
	private String PeymentType;
	@Column(name="PurposeofUsage")
	private String PurposeofUsage;
	@Column(name="SCRCRelation")
	private String SCRCRelation;

	@Column(name="SCFullNameScore")
	private Integer SCFullNameScore;
	@Column(name="SCNationalityScore")
	private Integer SCNationalityScore;
	@Column(name="SCNationalityIDScore")
	private Integer SCNationalityIDScore;
	@Column(name="SCBirthDateScore")
	private Integer SCBirthDateScore;
	@Column(name="SCMAScore")
	private Integer SCMAScore;
	@Column(name="SCMatchAlgorithm")
	private String SCMatchAlgorithm;
	@Column(name="RCFullNameScore")
	private Integer RCFullNameScore;
	@Column(name="RCNationalityScore")
	private Integer RCNationalityScore;
	@Column(name="RCNationalityIDScore")
	private Integer RCNationalityIDScore;
	@Column(name="RCBirthDateScore")
	private Integer RCBirthDateScore;
	@Column(name="RCMAScore")
	private Integer RCMAScore;
	@Column(name="RCMatchAlgorithm")
	private String RCMatchAlgorithm;

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


		row.setSCMobilePhone(this.getSCMobilePhone());
		row.setSCEmail(this.getSCEmail());
		row.setSCDateofNationalID(this.getSCDateofNationalID());
		row.setSCValidityDateofNationalID(this.getSCValidityDateofNationalID());
		row.setSCNationalIDCounty(this.getSCNationalIDCounty());
		row.setSCCounty(this.getSCCounty());
		row.setSCAccountNo(this.getSCAccountNo());
		row.setRCPlaceofBirth(this.getRCPlaceofBirth());
		row.setRCProfession(this.getRCProfession());
		row.setRCMobilePhone(this.getRCMobilePhone());
		row.setRCEmail(this.getRCEmail());
		row.setRCDateofNationalID(this.getRCDateofNationalID());
		row.setRCValidityDateofNationalID(this.getRCValidityDateofNationalID());
		row.setRCNationalIDCounty(this.getRCNationalIDCounty());
		row.setRCCounty(this.getRCCounty());
		row.setRCAccountNo(this.getRCAccountNo());
		row.setCenterName(this.getCenterName());
		row.setCenterNo(this.getCenterNo());
		row.setPeymentCenterName(this.getPeymentCenterName());
		row.setPeymentCenterNo(this.getPeymentCenterNo());
		row.setExchangeRate(this.getExchangeRate());
		row.setTLAmount(this.getTLAmount());
		row.setCost(this.getCost());
		row.setCostType(this.getCostType());
		row.setPeymentType(this.getPeymentType());
		row.setPurposeofUsage(this.getPurposeofUsage());
		row.setSCRCRelation(this.getSCRCRelation());

		return row;
	}

}