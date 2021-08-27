package com.mdsap.wlf.match.threads;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mdsap.wlf.db.config.AfparamvalParams;
import com.mdsap.wlf.db.domain.matchParams.MatchFields;
import com.mdsap.wlf.db.domain.matchParams.MatchProperities;
import com.mdsap.wlf.db.domain.model.MailResult;
import com.mdsap.wlf.match.threads.algorithms.*;

import lombok.Data;

import com.mdsap.wlf.db.domain.*;

import org.apache.log4j.Logger;
 
@Data
public class MatchThreadPoolV1 implements Runnable {
	  
	private static Logger log  = Logger.getLogger(MatchThreadPoolV1.class);
	

	private String threadName;
	private  List<MailResult> mailResultList;
	private List<WLMWLData> wlmwlDataList;
	private List<ITXTxnQueue> vitxtxnQueueList;
	private List<MEMatchResult> meMatchResult;
	private List<ITXTxnQueueMatchedArchive> itXTxnQueueMatchedArchive;

	private Algorithms matchAlgorithms;
	private MatchProperities matchProperities;
	private List<MatchFields> fieldList;
	private int matchingScore;


	
	
    private Boolean isFinish;
	   
    
	public MatchThreadPoolV1(String name) {
	 
	      threadName = name;
	      matchAlgorithms = new Algorithms();
	      mailResultList = new ArrayList<MailResult>();
	      meMatchResult = new ArrayList<MEMatchResult>();
		  itXTxnQueueMatchedArchive =  new ArrayList<ITXTxnQueueMatchedArchive>();
	      
	      setIsFinish(false);
	   }
	
	public MatchThreadPoolV1(String name, List<ITXTxnQueue> vitxtxnQueueDevList, List<WLMWLData> wlmwlDataList, MatchProperities matchProperities) {
	     
	 
		
		  threadName = name;
		  setMatchProperities(matchProperities);
	      setWlmwlDataList(wlmwlDataList);
	      setVitxtxnQueueList(vitxtxnQueueDevList);
	      mailResultList = new ArrayList<MailResult>();
	      matchAlgorithms = new Algorithms(matchProperities.getAlgoritmType());
	      meMatchResult = new ArrayList<MEMatchResult>();
		  itXTxnQueueMatchedArchive =  new ArrayList<ITXTxnQueueMatchedArchive>();
	      setIsFinish(false);
	      
	   }
	

	public void run() {
		
		 
		if(vitxtxnQueueList == null || wlmwlDataList==null) {
			
			log.warn("Thread " +  getThreadName() + " is not start because of null values of list");
			return;
		}
	      try {
	         
	    	  log.info("Thread " +  getThreadName() + " is start");
			  log.info("Thread " +  getThreadName() + " Black List Size : "+wlmwlDataList.size());
			  log.info( "Thread " +  getThreadName() +" Transaction List Size : "+vitxtxnQueueList.size());
			  fieldList= matchProperities.getFieldList();
	    	  int i =0;
	    	  matchingScore =matchProperities.getMatchingScore();
	    	  for (ITXTxnQueue tran : vitxtxnQueueList) {
				
	    		  for (WLMWLData bl : wlmwlDataList) {


	    			  int totalScore= this.getScore(bl,tran);

	    			  if(totalScore>=matchingScore) {

	    			  	 ITXTxnQueueMatchedArchive matchTran = tran.getRowAsMatchedArchive();
	    			  	 matchTran.setMatchCtxID(bl.getWFProcID());
	    			  	 itXTxnQueueMatchedArchive.add(matchTran);



						  MEMatchResult result = new MEMatchResult();
						  result.setWFState(bl.getWFState());
						  result.setWFProcID(bl.getWFProcID());
						  result.setMatchWLType(bl.getWLType());
						  result.setMatchCtxID(bl.getWFProcID());
						  result.setMatchTxnID(tran.getId());
						  result.setMatchScore(BigDecimal.valueOf(totalScore));
						  meMatchResult.add(result);

						  MailResult mailresult = new MailResult();
						  mailresult.setKeyWord(bl.getKeyWord());
						  mailresult.setMatchScore(totalScore);
						  mailresult.setBlakListUid(bl.getId());
						  mailresult.setBlakListType(bl.getWLType());
						  mailresult.setBlakListName(bl.getNameData());
						  mailresult.setBlakListCountry(bl.getCountryData());
						  mailresult.setBlakListTINNumber(bl.getTINNumberData());

						  mailresult.setTransactionId(tran.getId());
						  mailresult.setTxnchanneltype(tran.getTxnchanneltype());
						  mailresult.setTxnprodname(tran.getTxnprodname());
						  mailresult.setTxnsysid(tran.getTxnsysid());

						  mailresult.setScfullname(tran.getScfullname());
						  mailresult.setScnationality(tran.getScnationality());
						  mailresult.setScnationalid(tran.getScnationalid());

						  mailresult.setRcfullname(tran.getRcfullname());
						  mailresult.setRcnationality(tran.getRcnationality());
						  mailresult.setRcnationalid(tran.getRcnationalid());
						  mailResultList.add(mailresult);

					  }

	    			 
	    		  }

	    		  i++;
	    		  if(i%1000==0)
					  log.info("Thread " +  getThreadName() + " finished transaction count is "+i);

			    }
	    	  
	      }catch (Exception e) {
	    	  
	    	  log.warn("Thread " +  getThreadName() + " interrupted.");
	    	  log.error( "Thread " + getThreadName() +" "+e.toString());
	    	  
	    	  setIsFinish(true);
	      }
	    
	       setIsFinish(true);
	       
	       log.info( getThreadName() +" is finish");
	       
	      
	}
	   

	private int getScore(WLMWLData wlmwlData, ITXTxnQueue vitxtxnQueue )
	{


		double totalScoreSc =0.0;
		double totalScoreRc =0.0;
		int kalanScoreSc=100;
		int kalanScoreRc=100;
  		double initialDistance;

 		for (MatchFields field:fieldList)
		{

			String str1= vitxtxnQueue.getDataSc(field.getFieldName());
			String str2= wlmwlData.getData(field.getFieldName());

			// For SC
			if((str1 != null && str2 != null)&&(totalScoreSc + kalanScoreSc>= matchingScore)) {

				initialDistance = getInitialDistance(str1.length(), str2.length(), field.getFieldScore());

				initialDistance = initialDistance>field.getFieldScore()?field.getFieldScore():initialDistance;

				if ((totalScoreSc + kalanScoreSc) - (initialDistance) >= matchingScore) {

					totalScoreSc += (field.getFieldScore() / 100) * matchAlgorithms.getResult(str1, str2,field.getFieldName());
					kalanScoreSc -= field.getFieldScore();
				}else
					kalanScoreSc -= field.getFieldScore();


			}else
			kalanScoreSc -= field.getFieldScore();

			 str1=vitxtxnQueue.getDataRc(field.getFieldName());
			// For RC
			if((str1 != null && str2 != null)&&(totalScoreRc + kalanScoreRc>= matchingScore)) {
				initialDistance = getInitialDistance(str1.length(), str2.length(), field.getFieldScore());

				initialDistance = initialDistance>field.getFieldScore()?field.getFieldScore():initialDistance;

				if ((totalScoreRc + kalanScoreRc) - (initialDistance) >= matchingScore) {

					totalScoreRc += (field.getFieldScore() / 100) * matchAlgorithms.getResult(str1, str2,field.getFieldName());
					kalanScoreRc -= field.getFieldScore();
				}else
					kalanScoreRc -= field.getFieldScore();

			}else
			kalanScoreRc -= field.getFieldScore();

		}
		if(totalScoreSc>totalScoreRc)
			return (int)(totalScoreSc);

		return (int)(totalScoreRc);


	}
	 
	private double getInitialDistance(int len1,int len2,double fildScore)
	{
		if( len1== 0 || len2== 0)
			return fildScore;
		int initialLengthDistance= Math.abs(len1  - len2  );

		if(matchAlgorithms.getAlgoritmType().equals(AfparamvalParams.MATCH_ALGORITHM_LEVENSTEIN))
		return (5*initialLengthDistance*fildScore)/100;
		else if(matchAlgorithms.getAlgoritmType().equals(AfparamvalParams.MATCH_ALGORITHM_FUZZY))
			return (5*initialLengthDistance*fildScore)/100;
		else //AfparamvalParams.MATCH_ALGORITHM_EXACT
		{
			if(initialLengthDistance!=0)return fildScore;
			else return 0;

		}


	}

}

	