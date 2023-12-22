package com.example.repo;

import com.example.model.MailBox;
import org.springframework.stereotype.Repository;

@Repository
public class MailBoxRepo implements IMailBox{
    private static MailBox mailbox;
    static {
        mailbox = new MailBox();
    }
    @Override
    public MailBox getMailbox() {
        return mailbox;
    }

    @Override
    public void updateMailbox(MailBox mailboxUpdate) {
        mailbox.setLanguage(mailboxUpdate.getLanguage());
        mailbox.setPageSize(mailboxUpdate.getPageSize());
        mailbox.setSpamsFilter(mailboxUpdate.getSpamsFilter());
        mailbox.setSignature(mailboxUpdate.getSignature());
    }

}
