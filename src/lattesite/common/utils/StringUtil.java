package lattesite.common.utils;

/**
 * Utility methods for working with strings.
 */
public final class StringUtil {

    /**
     * Returns {@code true} if the given string is {@code null} or blank (whitespace only).
     *
     * @param s the string to check
     * @return {@code true} if the string is {@code null} or blank, {@code false} otherwise
     * @throws RuntimeException if the string is the literal text {@code "null"},
     *                          which indicates a likely serialization or data error
     */
    public static boolean isEmpty(String s) {
        if (s != null && s.equals("null")) {
            throw new RuntimeException("Something went seriously wrong. The string is literally \"null\".");
        }
        return s == null || s.trim().length() == 0;
    }

}
