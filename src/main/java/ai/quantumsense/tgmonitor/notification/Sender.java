package ai.quantumsense.tgmonitor.notification;

import java.util.Set;

public interface Sender {
    /**
     * Send an email to one or multiple email addresses.
     * @param emails Destination email addresses
     * @param text Email body in HTML
     * @param subject Subject line
     * @param html if true, 'text' is assumed to be HTML, otherwise plain text
     */
    void send(Set<String> emails, String text, String subject, boolean html);
}
