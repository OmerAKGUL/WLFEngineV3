package com.mdsap.wlf.db.domain.matchParams;

import lombok.Data;

@Data
public class MatchFields {

    private String fieldName;
    private Double fieldScore;

    public MatchFields(String fieldName, Integer fieldScore) {
        this.fieldName = fieldName;
        this.fieldScore =Double.valueOf(fieldScore);
    }
}
