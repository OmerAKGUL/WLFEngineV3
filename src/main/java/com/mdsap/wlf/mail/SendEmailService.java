package com.mdsap.wlf.mail;

import com.mdsap.wlf.db.domain.MEMatchResult;
import com.mdsap.wlf.db.domain.model.MailResult;

import java.io.IOException;
import java.util.List;

public interface SendEmailService {

    /**
     * Send html emails.
     *
     * @throws IOException
     */
    public void sendHtmlEmail() throws IOException;

    public  void setMailResultList(List<MailResult> mailResultList, List<MEMatchResult> meMatchResult);
    public  List<MailResult> getMailResultList();
}
