package ai.quantumsense.tgmonitor.notification;

import ai.quantumsense.tgmonitor.backend.Notificator;
import ai.quantumsense.tgmonitor.backend.pojo.PatternMatch;
import ai.quantumsense.tgmonitor.entities.Emails;
import ai.quantumsense.tgmonitor.servicelocator.ServiceLocator;

import java.util.Set;

public class NotificatorImpl implements Notificator {

    private Formatter formatter;
    private Sender sender;
    private ServiceLocator<Emails> emailsLocator;

    public NotificatorImpl(Formatter formatter, Sender sender, ServiceLocator<Emails> emailsLocator) {
        this.formatter = formatter;
        this.sender = sender;
        this.emailsLocator = emailsLocator;
    }

    @Override
    public void notify(PatternMatch match) {
        Set<String> emails = emailsLocator.getService().getEmails();
        String text = formatter.getBody(match);
        String subject = formatter.getSubject(match);
        sender.send(emails, text, subject, true);
    }
}
