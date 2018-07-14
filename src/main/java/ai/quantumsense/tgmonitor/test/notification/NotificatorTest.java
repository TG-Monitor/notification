package ai.quantumsense.tgmonitor.test.notification;

import ai.quantumsense.tgmonitor.backend.Notificator;
import ai.quantumsense.tgmonitor.entities.Emails;
import ai.quantumsense.tgmonitor.notification.NotificatorImpl;
import ai.quantumsense.tgmonitor.servicelocator.ServiceLocator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Test the NotificatorImpl class.
 */
public class NotificatorTest extends AbsTest {

    private static Notificator notificator = new NotificatorImpl(formatter, sender, new ServiceLocator<Emails>() {
        @Override
        public void registerService(Emails emails) {}
        @Override
        public Emails getService() {
            return new Emails() {
                @Override
                public Set<String> getEmails() {
                    return new HashSet<>(Arrays.asList("danielmweibel@gmail.com", "danielweibel@gmx.ch"));
                }
                @Override
                public void setEmails(Set<String> set) {}
                @Override
                public void addEmail(String s) {}
                @Override
                public void addEmails(Set<String> set) {}
                @Override
                public void removeEmail(String s) {}
                @Override
                public void removeEmails(Set<String> set) {}
            };
        }
    });

    public static void main(String[] args) {
        notificator.notify(patternMatch);
    }
}
