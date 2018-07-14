package ai.quantumsense.tgmonitor.test.notification.format;

import ai.quantumsense.tgmonitor.test.notification.AbsTest;

public class FormatterTest extends AbsTest {

    public static void main(String[] args) {
        formatBody();
        formatSubject();
    }

    private static void formatBody() {
        System.out.println(formatter.getBody(patternMatch));
    }

    private static void formatSubject() {
        System.out.println(formatter.getSubject(patternMatch));
    }
}
