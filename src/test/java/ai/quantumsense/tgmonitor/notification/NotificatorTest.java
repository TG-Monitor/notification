package ai.quantumsense.tgmonitor.notification;

import ai.quantumsense.tgmonitor.backend.Interactor;
import ai.quantumsense.tgmonitor.backend.Notificator;
import ai.quantumsense.tgmonitor.backend.pojo.PatternMatch;
import ai.quantumsense.tgmonitor.backend.pojo.TelegramMessage;
import ai.quantumsense.tgmonitor.monitor.Monitor;
import ai.quantumsense.tgmonitor.monitor.MonitorState;
import ai.quantumsense.tgmonitor.notification.format.FormatterImpl;
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
        Interactor interactor = new Interactor() {
            @Override
            public void messageReceived(TelegramMessage telegramMessage) { }
            @Override
            public void matchFound(PatternMatch patternMatch) { }
        };
        Monitor monitor = new Monitor() {
            @Override
            public MonitorState getState() {
                return null;
            }
            @Override
            public void login(String s) {}
            @Override
            public void logout() {}
            @Override
            public void start() {}
            @Override
            public void pause() {}
            @Override
            public String getPhoneNumber() {
                return null;
            }
            @Override
            public Set<String> getPeers() {
                return null;
            }
            @Override
            public void setPeers(Set<String> set) {}
            @Override
            public Set<String> getPatterns() {
                return null;
            }
            @Override
            public void setPatterns(Set<String> set) {}
            @Override
            public Set<String> getEmails() {
                return new HashSet<>(Arrays.asList("danielmweibel@gmail.com", "danielweibel@gmx.ch"));
            }
            @Override
            public void setEmails(Set<String> set) { }
        };
        notificator = new NotificatorImpl(interactor, monitor, new FormatterImpl(), sender);
    }

    @Test
    public void notifyMatch() {
        notificator.notify(patternMatch);
    }
}
