package com.mdsap.wlf.match.threads.algorithms;

import lombok.Data;
import me.xdrop.fuzzywuzzy.FuzzySearch;
@Data
public class Fuzzy {

	private String source;
	private String target;
	private int distance;
 
	
    public Fuzzy() {
    	 
    }
	
	public Fuzzy(String src,String trg) {
		
		setSource(src);
		setTarget(trg);
	 
		
	}
	
	public int getResult(String src,String trg)
	{ 
		setSource(src);
		setTarget(trg);

		setDistance( FuzzySearch.ratio(src, trg ));
		 
		return getDistance();
	}
	
	
	 

}
