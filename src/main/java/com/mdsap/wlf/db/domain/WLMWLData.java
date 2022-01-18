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

	@Column(name="AddressData")
	private String addressData;

	@Temporal(TemporalType.DATE)
	@Column(name="BirthDateData")
	private Date birthDateData;

	@Column(name="CityData")
	private String cityData;

	@Column(name="CountryData")
	private String countryData;

	@Column(name="CreateDT")
	private Timestamp createDT;

	@Column(name="CreateUsr")
	private Integer createUsr;

	@Column(name="NameData")
	private String nameData;

	@Column(name="TINNumberData")
	private String TINNumberData;

	@Column(name="UpdateDT")
	private Timestamp updateDT;

	@Column(name="UpdateUsr")
	private Integer updateUsr;

	@Column(name="WFProcID")
	private Integer WFProcID;

	@Column(name="WFState")
	private String WFState;

	@Column(name="wlmwltype")
	private String WLType;

	@Column(name="keyword")
	private String KeyWord;

	@Column(name="PublisherName")
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