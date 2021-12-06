package com.mdsap.wlf.match;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.mdsap.wlf.db.domain.matchParams.MatchProperities;
import com.mdsap.wlf.db.domain.model.MailResult;
import com.mdsap.wlf.match.threads.MatchThreadPoolV1;
import org.apache.log4j.Logger;

import com.mdsap.wlf.db.domain.*;
import com.mdsap.wlf.match.threads.MatchThreadPoolV1;

import lombok.Data;
@Data

public class MatchAll {

	// MatchAll

	private List<MEMatchResult> meMatchResult;
	private  List<MailResult> mailResultList;
	private List<ITXTxnQueueMatchedArchive> itXTxnQueueMatchedArchive;
	private List<WLMWLData> wlmwlDataList;
	private List<ITXTxnQueue> vitxtxnQueueList;
	private MatchProperities matchProperities;
	private ITXTxnQueueId lastITXTxnQueueId;
	private List<MatchProperities> matchProperitiesList;

	private int threadCount;

	private List<MatchThreadPoolV1> threads;
	private ExecutorService executor;

	private static Logger log  = Logger.getLogger(MatchAll.class);



	public MatchAll()
	{

		itXTxnQueueMatchedArchive = new ArrayList<ITXTxnQueueMatchedArchive>();
		meMatchResult = new ArrayList<MEMatchResult>();
		mailResultList= new ArrayList<MailResult>();
		lastITXTxnQueueId = null;
		//wlmwlDataList = new ArrayList<WLMWLData>();
		//vitxtxnQueueDevList = new ArrayList<VITXTxnQueue>();

		threadCount = Runtime.getRuntime().availableProcessors();
		threads = new ArrayList<MatchThreadPoolV1>();

		executor = Executors.newFixedThreadPool(threadCount);

	}

	public List<MEMatchResult> processMatch()
	{
		log.info( "Black List Size : "+wlmwlDataList.size());
		log.info( "Transaction List Size : "+vitxtxnQueueList.size());
		if(vitxtxnQueueList.size()==0) {

			log.warn("There isn't any new transaction!!!");
			return null;
		}
		if(wlmwlDataList.size()==0) {

			log.warn("There isn't any black list record !!!");
			return null;
		}

		try {
			lastITXTxnQueueId = new ITXTxnQueueId();
			lastITXTxnQueueId.setItxtxnqueueID(vitxtxnQueueList.get(vitxtxnQueueList.size()-1).getId());
			int allRows=wlmwlDataList.size();
			if(allRows<vitxtxnQueueList.size())
				allRows=vitxtxnQueueList.size();

			if(allRows<=0)
				return null;

			int maxRow=allRows/threadCount;

			int startIndex=0;
			int endIndex=maxRow;


			log.info("Starting all threads.");
			if(allRows>threadCount)
				for(int i=0;i<threadCount;i++)
				{

					if(i==threadCount-1)
						endIndex=allRows;

					if(wlmwlDataList.size()>vitxtxnQueueList.size())
						threads.add(new MatchThreadPoolV1( "Thread-"+i, vitxtxnQueueList,wlmwlDataList.subList(startIndex, endIndex),matchProperities,matchProperitiesList) );
					else
						threads.add(new MatchThreadPoolV1( "Thread-"+i, vitxtxnQueueList.subList(startIndex, endIndex),wlmwlDataList,matchProperities,matchProperitiesList) );

					Runnable worker = threads.get(i);
					executor.execute(worker);

					startIndex = endIndex;
					endIndex +=maxRow;

				}
			else
			{
				threads.add(new MatchThreadPoolV1( "Thread-"+0, vitxtxnQueueList,wlmwlDataList,matchProperities,matchProperitiesList) );

				Runnable worker = threads.get(0);
				executor.execute(worker);

			}

			executor.shutdown();
			while (!executor.isTerminated()) {}


			log.info( "All threads finished");

			log.info("Consolidating all results.");

			for(MatchThreadPoolV1 thread:threads)
			{
				meMatchResult.addAll(thread.getMeMatchResult());
				itXTxnQueueMatchedArchive.addAll(thread.getItXTxnQueueMatchedArchive());
				mailResultList.addAll(thread.getMailResultList());
			}
		} catch (Exception e) {
			log.error(e.toString());
		}

		log.info("Send all results.");
		return getMeMatchResult();
	}






}
