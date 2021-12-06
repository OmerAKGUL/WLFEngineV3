package com.mdsap.wlf.db.crud;

 
import java.util.ArrayList;
import java.util.List;

import com.mdsap.wlf.db.config.AfparamvalParams;
import com.mdsap.wlf.db.domain.matchParams.MatchProperities;
import org.apache.log4j.Logger;
import com.mdsap.wlf.db.domain.*;
import com.mdsap.wlf.db.repository.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data @NoArgsConstructor
@Component
public class ReadData {


	@Autowired
	private WLMWLDataRepository repoWLMWLData;

	@Autowired
	private ITXTxnQueueRepository repoVITXTxnQueue;

	@Autowired
	private MEConfigRepository repoMEConfig;

	@Autowired
	private AfparamvalRepository repoAfparamval;


	private List<WLMWLData> wlmwldataList;
	private List<ITXTxnQueue> vitxtxnQueueList;
	private List<MEConfig> meConfigList;
	private List<Afparamval> afparamvalList;
	private List<MatchProperities> matchProperitiesList;
	private MatchProperities matchProperities;


	private static Logger log  = Logger.getLogger(ReadData.class);
	private String MATCH_FIELDS_GROUP_NAME;
	private String MATCH_ALGORITHM_GROUP_NAME;

	public Boolean loadConfigData() {

		log.info("Starting database transaction.");


		matchProperitiesList = new ArrayList<MatchProperities>();

		for(int i=0;i<2;i++) {

			if(i==0) {
				MATCH_FIELDS_GROUP_NAME = AfparamvalParams.MATCH_FIELDS_GROUP_NAME_V1;
				MATCH_ALGORITHM_GROUP_NAME = AfparamvalParams.MATCH_ALGORITHM_GROUP_NAME_V1;
			}else
			{
				MATCH_FIELDS_GROUP_NAME = AfparamvalParams.MATCH_FIELDS_GROUP_NAME_V2;
				MATCH_ALGORITHM_GROUP_NAME = AfparamvalParams.MATCH_ALGORITHM_GROUP_NAME_V2;
			}
			matchProperities = new MatchProperities();

			if (!loadAlgoritmType()) return false;
			if (!loadMatchingScore()) return false;
			if (!loadMatchingFields()) return false;

			if (!matchProperities.controlParam()) {
				log.error("Error when controlling Matching Params !!!");
				return false;
			}

			matchProperitiesList.add(matchProperities);

		}

		if(!loadWLMWLData()) return false;
		if(!loadVITXTxnQueue()) return false;

		log.info("Close database transaction.");
		return true;
		 
	}



	public Boolean loadWLMWLData()
	{
		try {
			log.info("Reading WLMWLData list from database.");


			wlmwldataList = (List<WLMWLData>)repoWLMWLData.findAll();

		}catch (Exception e) {
			// TODO: handle exception
			log.error("Error reading WLMWLData list from database : "+e.toString());
			return false;
		}

		return true;
	}

	public Boolean loadVITXTxnQueue()
	{
		try {
			log.info("Reading vitxtxnQueueList list from database.");


			vitxtxnQueueList = (List<ITXTxnQueue>)repoVITXTxnQueue.findAll();

		}catch (Exception e) {
			// TODO: handle exception
			log.error("Error reading vitxtxnQueue list from database : "+e.toString());
			return false;
		}

		return true;
	}

	public Boolean loadMEConfig()
	{
		try {
			log.info("Reading MEConfig list from database.");


			meConfigList = (List<MEConfig>)repoMEConfig.findAll();

		}catch (Exception e) {
			// TODO: handle exception
			log.error("Error reading MEConfig list from database : "+e.toString());
			return false;
		}

		return true;
	}

	public Boolean loadAlgoritmType()
	{
		try {
			log.info("Reading Algoritm Type from database.");

			afparamvalList= repoAfparamval.findByParamgrpnameAndValue(MATCH_ALGORITHM_GROUP_NAME,AfparamvalParams.MATCH_ALGORITHM_VALUE);

			if(afparamvalList.size()!=1)
			{
				log.error("Number of Algoritm Type, which is 'TRUE', is not equal one !!! ");
				return false;
			}
			matchProperities.setAlgoritmType(afparamvalList.get(0).getCode());

			log.info("Algoritm Type is " +afparamvalList.get(0).getCode());

		}catch (Exception e) {
			// TODO: handle exception
			log.error("Error reading Algoritm Type   from database : "+e.toString());
			return false;
		}



		return true;


	}
	public Boolean loadMatchingScore()
	{
		try {
			log.info("Reading Matching Score from database.");

			afparamvalList= repoAfparamval.findByParamgrpnameAndCode(MATCH_ALGORITHM_GROUP_NAME,AfparamvalParams.MATCH_ALGORITHM_SCORE);

			if(afparamvalList.size()!=1)
			{
				log.error("Number of Matching Score is not equal one !!! ");
				return false;
			}

			try {
				int score = Integer.parseInt(afparamvalList.get(0).getValue());


				matchProperities.setMatchingScore(score);


			} catch (NumberFormatException nfe) {
				log.error("Error data format of Matching Score field : "+nfe.toString());
				return false;
			}
			log.info("Algoritm Matching Score is " +afparamvalList.get(0).getValue());

		}catch (Exception e) {
			// TODO: handle exception
			log.error("Error reading Matching Score from database : "+e.toString());
			return false;
		}



		return true;


	}

	private boolean loadMatchingFields() {

  	 try{

		   log.info("Reading Matching Fields from database.");

		   afparamvalList= repoAfparamval.findByParamgrpnameOrderByValueDesc(MATCH_FIELDS_GROUP_NAME);

		   for(Afparamval param:afparamvalList) {

			   matchProperities.addNewFieldToList(param.getCode(),Integer.parseInt(param.getValue()));
	  		 }

	   }
	   catch(Exception e)
	   {
		   log.error("Error reading Matching Fields from database : "+e.toString());
		   return false;
	   }
		return true;
	}




}
