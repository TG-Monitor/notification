package ai.quantumsense.tgmonitor.test.notification;

import ai.quantumsense.tgmonitor.backend.pojo.PatternMatch;
import ai.quantumsense.tgmonitor.backend.pojo.TelegramMessage;
import ai.quantumsense.tgmonitor.notification.Formatter;
import ai.quantumsense.tgmonitor.notification.Sender;
import ai.quantumsense.tgmonitor.notification.format.FormatterImpl;
import ai.quantumsense.tgmonitor.notification.send.MailgunSender;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Code common to multiple test applications.
 */
public abstract class AbsTest {

    public static TelegramMessage msg;
    static {
        TelegramMessage.Sender sender = new TelegramMessage.Sender(449519549, false, "\ud83e\udd8b \ud83c\uddf0 \ud83c\uddea \ud83c\uddee \ud83e\udd8b", null, "Brenden187");
        TelegramMessage.Peer peer = new TelegramMessage.Peer(1069879618, "(the) English Club", "the_englishclub");
        msg = new TelegramMessage(1305312, 1531003695, "We're good team. I pick the days I have to work late, so I can empty my schedule at the gym nights \uD83D\uDE06", sender, peer, 1305307);
    }
    public static Set<String> patterns = new HashSet<>(Arrays.asList("schedule", "gym"));
    public static PatternMatch patternMatch = new PatternMatch(msg, patterns);
    public static Sender sender;
    static {
        String apiKey = System.getenv("MAILGUN_API_KEY");
        if (apiKey == null)
            throw new RuntimeException("Must set MAILGUN_API_KEY environment variable");
        sender = new MailgunSender(apiKey, "quantumsense.ai", "tg-monitor@quantumsens.ai", "TG-Monitor");
    }
    public static Formatter formatter = new FormatterImpl();
}
