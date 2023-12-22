package com.example.service;

import com.example.model.MailBox;
import com.example.repo.IMailBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailBoxService implements IMailBoxService{
    @Autowired
    private IMailBox iMailBox;
    @Override
    public MailBox getMailbox() {
        return iMailBox.getMailbox();
    }

    @Override
    public void updateMailbox(MailBox mailboxUpdate) {
        iMailBox.updateMailbox(mailboxUpdate);

    }
}
