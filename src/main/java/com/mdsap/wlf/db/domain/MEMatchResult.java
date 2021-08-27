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
@Table(schema = "WLF" ,name = "mematchresult")
public class MEMatchResult implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Column(name="id")
	private Integer id;

	@Column(name="matchid")
	private Integer matchID;

	@Column(name="createdt")
	private Timestamp createDT;

	@Column(name="createusr")
	private Integer createUsr;

	@Column(name="invprocid")
	private Integer invProcID;

	@Column(name="matchconfigcode")
	private String matchConfigCode;

	@Column(name="matchctxid")
	private Integer matchCtxID;

	@Column(name="matchscore")
	private BigDecimal matchScore;

	@Column(name="matchtxnid")
	private Integer matchTxnID;

	@Column(name="matchwltype")
	private String matchWLType;

	@Column(name="updatedt")
	private Timestamp updateDT;

	@Column(name="updateusr")
	private Integer updateUsr;

	@Column(name="wfprocid")
	private Integer WFProcID;

	@Column(name="wfstate")
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