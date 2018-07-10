package ai.quantumsense.tgmonitor.notification.send;

import ai.quantumsense.tgmonitor.notification.AbsTest;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Test sending emails.
 */
public class SenderTest extends AbsTest {

    private Set<String> emails = new HashSet<>(Arrays.asList("danielmweibel@gmail.com", "danielweibel@gmx.ch"));

    @Test
    public void sendText() {
        String text = "Hello World!\nSecond line";
        String subject = "Test Sending Text";
        sender.send(emails, text, subject, false);
    }

    @Test
    public void sendHtml() {
        String text = "<h1>Hello World!</h1>See <a href=\"https://stackoverflow.com\">here</a>.";
        String subject = "Test Sending HTML";
        sender.send(emails, text, subject, true);
    }
}
