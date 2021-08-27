package com.mdsap.wlf.db.crud;

import java.util.List;


import com.mdsap.wlf.db.domain.ITXTxnQueueId;
import com.mdsap.wlf.db.domain.ITXTxnQueueMatchedArchive;
import com.mdsap.wlf.db.domain.model.MailResult;
import com.mdsap.wlf.db.repository.ITXTxnQueueIdRepository;
import com.mdsap.wlf.db.repository.ITXTxnQueueMatchedArchiveRepository;
import com.mdsap.wlf.mail.SendEmailService;
import org.apache.log4j.Logger;

import com.mdsap.wlf.db.domain.MEMatchResult;
import com.mdsap.wlf.db.repository.MEMatchResultRepository;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;

@Data @NoArgsConstructor
@Component
public class InsertMatchResults {


	@Autowired
	private MEMatchResultRepository reporesult;

	@Autowired
	private ITXTxnQueueMatchedArchiveRepository repoITXTxnQueueMatchedArchive;

	@Autowired
	private ITXTxnQueueIdRepository repoITXTxnQueueIdRepository;
	
	private List<MEMatchResult> meMatchResult;
	
	private static Logger log  = Logger.getLogger(InsertMatchResults.class);
 
	
	
	 public Boolean insertAllMatchResults(List<MEMatchResult> meMatchResult_N, List<ITXTxnQueueMatchedArchive> itXTxnQueueMatchedArchive_N, ITXTxnQueueId lastITXTxnQueueId) {

		 
		 if(meMatchResult_N == null || meMatchResult_N.isEmpty())
		 {

			 try {
			 	if(lastITXTxnQueueId != null)
				 repoITXTxnQueueIdRepository.save(lastITXTxnQueueId);

			 } catch (Exception e) {

				 log.error("Match results insert ITXTxnQueueId process error "+ e.toString());
				 return false;
			 }

			 log.warn("Match result table is empty or null."); 
			 return false;
		 }
		 
		 
		 try {
			 log.info("Starting match results insert process.");

			try {
				reporesult.saveAll(meMatchResult_N);
			} catch (Exception e) {

				log.error("Match results insert MEMatchResult process error "+ e.toString());
				return false;
			}
			 try {
			  repoITXTxnQueueMatchedArchive.saveAll(itXTxnQueueMatchedArchive_N);
			 } catch (Exception e) {

				 log.error("Match results insert ITXTxnQueueMatchedArchive process error "+ e.toString());
				 return false;
			 }
			 try {
				 repoITXTxnQueueIdRepository.save(lastITXTxnQueueId);
			 } catch (Exception e) {

				 log.error("Match results insert ITXTxnQueueId process error "+ e.toString());
				 return false;
			 }






	       log.info("Match results insert process is finish with "+meMatchResult_N.size()+" insertions"); 


		 } catch (Exception e) {
	    	 
	    	  log.error("Match results insert process error "+ e.toString()); 
	    	  return false;
		  }




		 
		 return true;
	 }
	 
	 
	
	
	

}
