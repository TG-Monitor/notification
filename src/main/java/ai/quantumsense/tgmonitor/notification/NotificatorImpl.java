package ai.quantumsense.tgmonitor.notification;

import ai.quantumsense.tgmonitor.backend.Interactor;
import ai.quantumsense.tgmonitor.backend.Notificator;
import ai.quantumsense.tgmonitor.backend.pojo.PatternMatch;
import ai.quantumsense.tgmonitor.monitor.Monitor;

import java.util.Set;

public class NotificatorImpl implements Notificator {

    private Interactor interactor;
    private Monitor monitor;
    private Formatter formatter;
    private Sender sender;

    public NotificatorImpl(Interactor interactor, Monitor monitor, Formatter formatter, Sender sender) {
        this.interactor = interactor;
        this.monitor = monitor;
        this.formatter = formatter;
        this.sender = sender;
    }

    @Override
    public void notify(PatternMatch match) {
        Set<String> emails = monitor.getEmails();
        String text = formatter.formatHtml(match);
        String subject = "Pattern match in \"" + match.getMessage().getPeer().getTitle() + "\"";
        sender.send(emails, text, subject, true);
    }
}
