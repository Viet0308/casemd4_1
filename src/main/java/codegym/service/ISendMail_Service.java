package codegym.service;


public interface ISendMail_Service {
    void sendMail( String to, String subject, String content );
}
