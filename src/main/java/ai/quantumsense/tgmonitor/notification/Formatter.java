package ai.quantumsense.tgmonitor.notification;

import ai.quantumsense.tgmonitor.backend.pojo.PatternMatch;

public interface Formatter {
    /**
     * Format a PatternMatch object into an HTML email body string.
     * @param match
     * @return HTML string
     */
    String formatHtml(PatternMatch match);
}
