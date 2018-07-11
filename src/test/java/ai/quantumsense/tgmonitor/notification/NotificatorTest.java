package ai.quantumsense.tgmonitor.notification;

import ai.quantumsense.tgmonitor.backend.Notificator;
import ai.quantumsense.tgmonitor.monitor.data.MonitorData;
import ai.quantumsense.tgmonitor.monitor.data.MonitorDataFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Test the NotificatorImpl class.
 */
public class NotificatorTest extends AbsTest {

    private static Notificator notificator;

    @BeforeClass
    public static void createNotificator() {
        MonitorDataFactory monitorDataFactory = () -> new MonitorData() {
            @Override
            public Set<String> getPeers() { return null; }
            @Override
            public void setPeers(Set<String> set) { }
            @Override
            public Set<String> getPatterns() { return null; }
            @Override
            public void setPatterns(Set<String> set) { }
            @Override
            public Set<String> getEmails() {
                return new HashSet<>(Arrays.asList("danielmweibel@gmail.com", "danielweibel@gmx.ch"));
            }
            @Override
            public void setEmails(Set<String> set) { }
        };
        notificator = new NotificatorImpl(formatter, sender, monitorDataFactory);
    }

    @Test
    public void notifyMatch() {
        notificator.notify(patternMatch);
    }
}
