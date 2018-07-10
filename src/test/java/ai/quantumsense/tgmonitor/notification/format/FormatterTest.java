package ai.quantumsense.tgmonitor.notification.format;

import ai.quantumsense.tgmonitor.notification.AbsTest;
import ai.quantumsense.tgmonitor.notification.Formatter;
import org.junit.Test;

/**
 * Test formatting a PatternMatch to an HTML string for sending as email body.
 */
public class FormatterTest extends AbsTest {

    @Test
    public void format() {
        Formatter formatter = new FormatterImpl();
        System.out.println(formatter.formatHtml(patternMatch));
    }
}
