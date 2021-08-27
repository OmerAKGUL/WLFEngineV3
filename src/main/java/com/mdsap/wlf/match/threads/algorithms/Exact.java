package com.mdsap.wlf.match.threads.algorithms;

 
import lombok.Data;

@Data
public class Exact {

	private String source;
	private String target;

	private int distance;
	
	
	public Exact() {}
	
	public Exact(String src,String trg) {
		
		setSource(src);
		setTarget(trg);
		
	}
	
	public int getResult(String src,String trg)
	{ 
		setSource(src);
		setTarget(trg);


		setDistance( (source.equals(target)) == true ? 100:0 );

		return getDistance();
	}
	
	
	 
	
	
	
	
}
