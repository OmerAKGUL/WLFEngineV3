package com.mdsap.wlf.engine;

import java.util.List;

import com.mdsap.wlf.mail.SendEmailService;
import org.apache.log4j.Logger;

import com.mdsap.wlf.db.crud.ReadData;
import com.mdsap.wlf.db.domain.*;
import com.mdsap.wlf.db.crud.InsertMatchResults;
import com.mdsap.wlf.match.MatchAll;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Named;

@Data
@Service
public class WlfEngine {


	private static Logger log  = Logger.getLogger(WlfEngine.class);

	@Autowired
	@Named("sendEmailServiceSpringBootImpl")
	private SendEmailService emailServiceSpringBoot;


	@Autowired
	private ReadData config;

	@Autowired
	private InsertMatchResults insertMatchResults ;


	public Boolean startProcess()
	{
		log.info("Process engine is started.");
		
		// Loading all ddata
		Boolean statu =  config.loadConfigData();
		
		if( !statu ) {
		   log.error("Process engine is interrupted.");
			return false;
		  }
			
	    MatchAll matchAll = new MatchAll();
		matchAll.setMatchProperities(config.getMatchProperities());
		matchAll.setMatchProperitiesList(config.getMatchProperitiesList());
	    matchAll.setWlmwlDataList(config.getWlmwldataList());
	    matchAll.setVitxtxnQueueList(config.getVitxtxnQueueList());
	    
 
	    
	    List<MEMatchResult> meMatchResult = matchAll.processMatch();


        statu = insertMatchResults.insertAllMatchResults(meMatchResult,matchAll.getItXTxnQueueMatchedArchive(),matchAll.getLastITXTxnQueueId());
        
        if(!statu) {
        	log.error("Process engine is interrupted !!!");
        	return false;
        }

        // Send Mail
		try {
			emailServiceSpringBoot.setMailResultList(matchAll.getMailResultList());
			emailServiceSpringBoot.sendHtmlEmail();
		} catch (Exception e) {
			log.error("Send mail errors : "+e.toString());

		}

        log.info("Process engine is successfully finish");
        
        log.info("Process engine is successfully finish "+meMatchResult.size());
        
		return true;
	}
	
}
