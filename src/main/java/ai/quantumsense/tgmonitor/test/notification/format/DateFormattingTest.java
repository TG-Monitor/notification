package ai.quantumsense.tgmonitor.test.notification.format;

import ai.quantumsense.tgmonitor.backend.pojo.PatternMatch;
import ai.quantumsense.tgmonitor.backend.pojo.TelegramMessage;
import ai.quantumsense.tgmonitor.test.notification.AbsTest;

public class DateFormattingTest extends AbsTest {

    public static void main(String[] args) {
        int timestamp = 1531897627;  // Should be 2018-07-18 07:07:07 UTC
        TelegramMessage m = new TelegramMessage(msg.getId(), timestamp, "", msg.getSender(), msg.getPeer(), msg.getReplyMessageId());
        System.out.println(formatter.getBody(new PatternMatch(m, patterns)));
    }

}
