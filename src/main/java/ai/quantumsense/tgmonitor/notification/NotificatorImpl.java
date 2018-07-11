package ai.quantumsense.tgmonitor.notification;

import ai.quantumsense.tgmonitor.backend.InteractorImpl;
import ai.quantumsense.tgmonitor.backend.Notificator;
import ai.quantumsense.tgmonitor.backend.pojo.PatternMatch;
import ai.quantumsense.tgmonitor.monitor.data.MonitorDataFactory;

import java.util.Set;

public class NotificatorImpl implements Notificator {

    private Formatter formatter;
    private Sender sender;
    private MonitorDataFactory monitorDataFactory;

    public NotificatorImpl(Formatter formatter, Sender sender, MonitorDataFactory monitorDataFactory) {
        this.formatter = formatter;
        this.sender = sender;
        this.monitorDataFactory = monitorDataFactory;
    }

    @Override
    public void notify(PatternMatch match) {
        Set<String> emails = monitorDataFactory.getMonitorData().getEmails();
        String text = formatter.getBody(match);
        String subject = formatter.getSubject(match);
        sender.send(emails, text, subject, true);
    }
}
