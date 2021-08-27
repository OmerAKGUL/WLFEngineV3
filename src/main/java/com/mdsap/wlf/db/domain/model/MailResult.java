package com.mdsap.wlf.db.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data

public class MailResult {

    private int matchScore;
    private String matchDate;

    private String keyWord;
    private int blakListUid;
    private String blakListType;
    private String blakListName;
    private String blakListTINNumber;
    private String blakListCountry;


    private int transactionId;
    private String txnchanneltype;
    private String txnprodname;
    private String txnsysid;

    private String scfullname;
    private String scnationality;
    private String scnationalid;

    private String rcfullname;
    private String rcnationality;
    private String rcnationalid;


    public MailResult() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        matchDate  = LocalDateTime.now().format(formatter);

    }
}
