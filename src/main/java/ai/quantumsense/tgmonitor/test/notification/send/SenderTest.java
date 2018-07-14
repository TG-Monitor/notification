package ai.quantumsense.tgmonitor.test.notification.send;

import ai.quantumsense.tgmonitor.test.notification.AbsTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SenderTest extends AbsTest {

    private static Set<String> emails = new HashSet<>(Arrays.asList("danielmweibel@gmail.com", "danielweibel@gmx.ch"));

    public static void main(String[] args) {
        String text = "<h1>Hello World!</h1>See <a href=\"https://stackoverflow.com\">here</a>.";
        String subject = "Test Sending HTML";
        sender.send(emails, text, subject, true);
    }
}
