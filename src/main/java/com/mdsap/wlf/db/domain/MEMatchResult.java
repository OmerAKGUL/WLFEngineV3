package com.mdsap.wlf.db.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;



/**
 * The persistent class for the "MEMatchResultDev" database table.
 *
 */
@Entity
@Data
@Table(schema = "WLF" ,name = "MEMatchResult")
public class MEMatchResult implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Column(name="id")
	private Integer id;

	@Column(name="MatchID")
	private Integer matchID;

	@Column(name="CreateDT")
	private Timestamp createDT;

	@Column(name="CreateUsr")
	private Integer createUsr;

	@Column(name="InvProcID")
	private Integer invProcID;

	@Column(name="MatchConfigCode")
	private String matchConfigCode;

	@Column(name="MatchCtxID")
	private Integer matchCtxID;

	@Column(name="MatchScore")
	private BigDecimal matchScore;

	@Column(name="MatchTxnID")
	private Integer matchTxnID;

	@Column(name="MatchWLType")
	private String matchWLType;

	@Column(name="UpdateDT")
	private Timestamp updateDT;

	@Column(name="UpdateUsr")
	private Integer updateUsr;

	@Column(name="WFProcID")
	private Integer WFProcID;

	@Column(name="WFState")
	private String WFState;


	public MEMatchResult() {

		createDT  = Timestamp.valueOf(LocalDateTime.now());
		updateDT  = createDT;
	}

	@Override
	public String toString() {
		return "MEMatchResult{" +
				"id=" + id +
				", matchID=" + matchID +
				", createDT=" + createDT +
				", createUsr=" + createUsr +
				", invProcID=" + invProcID +
				", matchConfigCode='" + matchConfigCode + '\'' +
				", matchCtxID=" + matchCtxID +
				", matchScore=" + matchScore +
				", matchTxnID=" + matchTxnID +
				", matchWLType='" + matchWLType + '\'' +
				", updateDT=" + updateDT +
				", updateUsr=" + updateUsr +
				", WFProcID=" + WFProcID +
				", WFState='" + WFState + '\'' +
				'}';
	}
}