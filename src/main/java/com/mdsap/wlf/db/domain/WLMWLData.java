package com.mdsap.wlf.db.domain;
import java.io.Serializable;
import javax.persistence.*;

import com.mdsap.wlf.db.config.AfparamvalParams;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the "WLMWLDataDev" database table.
 *
 */
@Entity
@Data @NoArgsConstructor
@Table(schema = "WLF" ,name = "VTopWLMWLData")
public class WLMWLData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="addressdata")
	private String addressData;

	@Temporal(TemporalType.DATE)
	@Column(name="birthdatedata")
	private Date birthDateData;

	@Column(name="citydata")
	private String cityData;

	@Column(name="countrydata")
	private String countryData;

	@Column(name="createdt")
	private Timestamp createDT;

	@Column(name="createusr")
	private Integer createUsr;

	@Column(name="namedata")
	private String nameData;

	@Column(name="tinnumberdata")
	private String TINNumberData;

	@Column(name="updatedt")
	private Timestamp updateDT;

	@Column(name="updateusr")
	private Integer updateUsr;

	@Column(name="wfprocid")
	private Integer WFProcID;

	@Column(name="wfstate")
	private String WFState;

	@Column(name="wlmwltype")
	private String WLType;

	@Column(name="keyword")
	private String KeyWord;

	@Column(name="publishername")
	private String PublisherName;

	public String getData(String value)
	{
		switch (value) {
			case AfparamvalParams.MATCH_FIELD_FULL_NAME:
				return this.getNameData();

				/*case AfparamvalParams.MATCH_FIELD_CITY:
				return this.getCityData();
			case AfparamvalParams.MATCH_FIELD_ADDRESS:
				return this.getAddressData();

			 */
			case AfparamvalParams.MATCH_FIELD_NATIONALITY:
				return this.getCountryData();
			case AfparamvalParams.MATCH_FIELD_NATIONALITY_ID:
				return this.getTINNumberData();

		}

		return null;
	}


}