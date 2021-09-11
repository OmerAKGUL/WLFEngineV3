package com.mdsap.wlf.match.threads.algorithms;

 
import com.mdsap.wlf.db.config.AfparamvalParams;
import org.apache.log4j.Logger;
 
import lombok.Data;
@Data
public class Algorithms {

	
	private Exact exact;
	private Levenshtein levenshtein;
	private Fuzzy fuzzy;
	private String algoritmType;
	
	private static Logger log  = Logger.getLogger(Algorithms.class);
	
	
	public Algorithms()
    {
		// Defult Algorithm is Exact
    	this.algoritmType= AfparamvalParams.MATCH_ALGORITHM_EXACT;
    	
    	
    	exact = new Exact();
    	levenshtein = new Levenshtein();
    	fuzzy = new Fuzzy();
    	
    	//PropertyConfigurator.configure("src/main/resources/log4j.properties");
    	
    }
	
	
    public Algorithms(String algoritmType)
    {
    	this.algoritmType=algoritmType;
    	exact = new Exact();
    	levenshtein = new Levenshtein();
    	fuzzy = new Fuzzy();
    	
    	//PropertyConfigurator.configure("src/main/resources/log4j.properties");
    }
	
    public double getResultNew(String src,String trg)
	{



    	if(src == null || trg == null)
    		return 0;
    	
    	double distance=0;
    	
    	try {
			// All field will use exact match except FULL_NAME
    		//if(!fieldName.equals(AfparamvalParams.MATCH_FIELD_FULL_NAME))
    		//	return exact.getResult( src, trg);


    	switch(algoritmType) {
    	
    	  case AfparamvalParams.MATCH_ALGORITHM_LEVENSTEIN:
    	    // Levenshtein Algorithm
    		  distance = levenshtein.getResult( src, trg);
    	    break;
    	    
    	  case AfparamvalParams.MATCH_ALGORITHM_EXACT:
    	    // Exact Algorithm
    		  distance = exact.getResult(src, trg);
			  break;
    	  case AfparamvalParams.MATCH_ALGORITHM_FUZZY:
      	    // Fuzzy Algorithm
      		  distance = fuzzy.getResult(src, trg);
      	    break;
    	    
    	  default:
      	    // Exact Algorithm
			  distance = exact.getResult(src, trg);
		}
		 
    	} catch (Exception e) {
    		
    		
    		log.error("Error in matching algorithm type : "+algoritmType);
    		log.error("Error in matching source : "+src+"  / "+"Error in matching target : "+trg);
    		log.error(e.toString());
		}
		 
		 
		
		 return distance;


	}


	public double getResultExact(String src,String trg)
	{



		if(src == null || trg == null)
			return 0;

		double distance=0;

		try {
			// Exact Algorithm
			distance = exact.getResult(src, trg);

		} catch (Exception e) {


			log.error("Error in matching algorithm type : "+exact);
			log.error("Error in matching source : "+src+"  / "+"Error in matching target : "+trg);
			log.error(e.toString());
		}



		return distance;


	}


	public double getResult(String src,String trg,String fieldName)
	{



		if(src == null || trg == null)
			return 0;

		double distance=0;

		try {
			// All field will use exact match except FULL_NAME
			//if(!fieldName.equals(AfparamvalParams.MATCH_FIELD_FULL_NAME))
			//	return exact.getResult( src, trg);


			switch(algoritmType) {

				case AfparamvalParams.MATCH_ALGORITHM_LEVENSTEIN:
					// Levenshtein Algorithm
					distance = levenshtein.getResult( src, trg);
					break;

				case AfparamvalParams.MATCH_ALGORITHM_EXACT:
					// Exact Algorithm
					distance = exact.getResult(src, trg);
					break;
				case AfparamvalParams.MATCH_ALGORITHM_FUZZY:
					// Fuzzy Algorithm
					distance = fuzzy.getResult(src, trg);
					break;

				default:
					// Exact Algorithm
					distance = exact.getResult(src, trg);
			}

		} catch (Exception e) {


			log.error("Error in matching algorithm type : "+algoritmType);
			log.error("Error in matching source : "+src+"  / "+"Error in matching target : "+trg);
			log.error(e.toString());
		}



		return distance;


	}



}
