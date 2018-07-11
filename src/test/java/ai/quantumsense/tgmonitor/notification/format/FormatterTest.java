package ai.quantumsense.tgmonitor.notification.format;

import ai.quantumsense.tgmonitor.notification.AbsTest;
import org.junit.Test;

/**
 * Test formatting a PatternMatch to an HTML string for sending as email body.
 */
public class FormatterTest extends AbsTest {

    @Test
    public void formatBody() {
        System.out.println(formatter.getBody(patternMatch));
    }

    @Test
    public void formatSubject() {
        System.out.println(formatter.getSubject(patternMatch));
    }
}
