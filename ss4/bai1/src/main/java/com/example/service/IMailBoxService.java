package com.example.service;

import com.example.model.MailBox;

public interface IMailBoxService {
    MailBox getMailbox();
    void updateMailbox(MailBox mailboxUpdate);
}
