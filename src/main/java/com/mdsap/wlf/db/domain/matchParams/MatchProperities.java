package com.mdsap.wlf.db.domain.matchParams;


import com.mdsap.wlf.db.config.AfparamvalParams;
import com.mdsap.wlf.db.crud.ReadData;
import lombok.Data;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

@Data
public class MatchProperities {

    private String algoritmType;
    private Integer matchingScore;
    private List<MatchFields> fieldList;

    private static Logger log  = Logger.getLogger(ReadData.class);

    public MatchProperities() {

        fieldList = new ArrayList<MatchFields>() ;

    }

    public void addNewFieldToList(String fieldName, Integer fieldScore)
    {
        fieldList.add(new MatchFields(fieldName,fieldScore));

    }


    public boolean controlParam() {

            if(!(controlAlgoritmType()&&controlMatchingScore()&&controlFieldList())) {
                log.error("Control Matching Params failed !!! ");
                return false;
            }
        return true;

    }

    private boolean controlAlgoritmType()
    {

        return true;
    }
    private boolean controlMatchingScore()
    {
        if(this.matchingScore <= 0 || this.matchingScore > 100)
        {
            log.error("Matching Score is out of 0-100 !!!");
            return false;
        }
        return true;
    }
    private boolean controlFieldList()
    {

        double totalScore=0;
        for(MatchFields field:fieldList) {


                if(field.getFieldName().equals(AfparamvalParams.MATCH_FIELD_FULL_NAME))
                    totalScore += field.getFieldScore();
                else if(field.getFieldName().equals(AfparamvalParams.MATCH_FIELD_NATIONALITY))
                totalScore += field.getFieldScore();
                else if(field.getFieldName().equals(AfparamvalParams.MATCH_FIELD_BIRTH_DATE))
                totalScore += field.getFieldScore();
                else if(field.getFieldName().equals(AfparamvalParams.MATCH_FIELD_NATIONALITY_ID))
                    totalScore += field.getFieldScore();

            }


        if(totalScore!=100)
        {
            log.error("Total Score of Fields is out of 100 !!");
            return false;
        }




        return true;
    }
}
