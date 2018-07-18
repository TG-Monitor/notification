package ai.quantumsense.tgmonitor.notification.format;

import ai.quantumsense.tgmonitor.backend.pojo.PatternMatch;
import ai.quantumsense.tgmonitor.backend.pojo.TelegramMessage;
import ai.quantumsense.tgmonitor.notification.Formatter;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class FormatterImpl implements Formatter {

    @Override
    public String getBody(PatternMatch match) {
        TelegramMessage msg = match.getMessage();
        StringBuilder sb = new StringBuilder();

        sb.append("<h1>Matched Patterns</h1>");
        sb.append("<ul>");
        for (String p : match.getPatterns())
            sb.append("<li>" + p + "</li>");
        sb.append("</ul>");

        sb.append("<h1>" + formatMsgIdLink(msg.getPeer().getUsername(), msg.getId(), "Message") + "</h1>");
        sb.append("<p>" + msg.getText() + "</p>");

        sb.append("<h1>Message Details</h1>");
        sb.append("<ul>");
        sb.append("<li>ID: " + msg.getId() + "</li>");
        sb.append("<li>Chat: " + msg.getPeer().getTitle() + " (" + formatUsernameLink(msg.getPeer().getUsername()) + ")</li>");
        sb.append("<li>Sender: " + formatSender(msg.getSender()) + "</li>");
        sb.append("<li>Date: " + formatDate(msg.getDate()) + "</li>");
        sb.append("<li>Reply To ID: " + formatReplyTo(msg) + "</li>");
        sb.append("</ul>");

        return sb.toString();
    }

    @Override
    public String getSubject(PatternMatch match) {
        return "Pattern Match in \"" + match.getMessage().getPeer().getTitle() + "\"";
    }

    private String formatReplyTo(TelegramMessage msg) {
        if (msg.isReply())
            return formatMsgIdLink(msg.getPeer().getUsername(),
                    msg.getReplyMessageId(),
                    String.valueOf(msg.getReplyMessageId()));
        else
            return "N/A";
    }

    private String formatDate(int timestamp) {
        Instant instant = Instant.ofEpochSecond(timestamp);
        ZonedDateTime date = ZonedDateTime.ofInstant(instant, ZoneOffset.UTC);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss 'UTC'");
        return date.format(format);
    }

    private String formatSender(TelegramMessage.Sender sender) {
        String fn = sender.getFirstName();
        String ln = sender.getLastName();
        String un = sender.getUsername();
        if (fn == null && ln == null) {
            if (un == null) return String.valueOf(sender.getId());
            else return formatUsernameLink(un);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(fn == null ? "" : fn + " ");
        sb.append(ln == null ? "" : ln + " ");
        sb.append(un == null ? "" : "(" + formatUsernameLink(un) + ")");
        return sb.toString();
    }

    private String formatMsgIdLink(String username, int msgId, String linkText) {
        return "<a href=\"https://t.me/" + username + "/" + msgId + "\">" + linkText + "</a>";
    }

    private String formatUsernameLink(String username) {
        return "<a href=\"https://t.me/" + username + "\">@" + username + "</a>";
    }
}
