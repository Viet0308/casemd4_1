package codegym.service.impl;

import codegym.service.ISendMail_Service;

public interface ISendMailService extends ISendMail_Service {
    void sendMail(String to, String subject, String content);
}
