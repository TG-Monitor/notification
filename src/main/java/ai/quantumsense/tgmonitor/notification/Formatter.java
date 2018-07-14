package ai.quantumsense.tgmonitor.notification;

import ai.quantumsense.tgmonitor.backend.pojo.PatternMatch;

public interface Formatter {
    /**
     * Return body for a pattern match notification email in HTML.
     * @param match
     * @return HTML string
     */
    String getBody(PatternMatch match);

    /**
     * Return subject line for a pattern match.
     * @param match
     * @return Subject line
     */
    String getSubject(PatternMatch match);
}
