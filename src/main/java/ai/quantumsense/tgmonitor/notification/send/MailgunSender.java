package ai.quantumsense.tgmonitor.notification.send;

import ai.quantumsense.tgmonitor.notification.Sender;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.Set;

public class MailgunSender implements Sender {

    private String mailgunApiKey;
    private String mailgunDomain;
    private String fromEmail;


    public MailgunSender(String mailgunApiKey, String mailgunDomain, String fromEmail) {
        this.mailgunApiKey = mailgunApiKey;
        this.mailgunDomain = mailgunDomain;
        this.fromEmail = fromEmail;
    }

    @Override
    public void send(Set<String> emails, String text, String subject, boolean html) {
        // JRE must be at least 8u91, otherwise this error occurs:
        // https://github.com/sargue/mailgun/issues/27
        // Quick fix if you don't want to upgrade JRE: import the root certificate
        // to $JAVA_HOME/jre/lib/security/cacerts according to instructions here:
        // https://stackoverflow.com/a/48425037/4747193
        String format = html ? "html" : "text";
        for (String e : emails) {
            try {
                Unirest.post("https://api.mailgun.net/v3/" + mailgunDomain + "/messages")
                        .basicAuth("api", mailgunApiKey)
                        .queryString("from",  "TG-Monitor<" + fromEmail + ">")
                        .queryString("to", e)
                        .queryString("subject", subject)
                        .queryString(format, text)
                        .asJson();
            } catch (UnirestException ex) {
                ex.printStackTrace();
            }
        }
    }
}
