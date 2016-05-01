package com.gorbich.proco.application;

/**
 * Validator Utility class.
 * This class contains validation methods for form fields.
 */
public class Validator {

    /**
     * The method to validate username.
     * @param value
     * @return result message or null
     */
    public static String validate(String value, String name,
                                  int min_chars, int max_chars, String allowed_chars) {

        if (isEmpty(value) != null) {
            return name + isEmpty(value);
        }
        if (hasFewerThanMinimumCharacters(value, min_chars) != null) {
            return hasFewerThanMinimumCharacters(value, min_chars) + name;
        }
        if (hasMoreThanMaximumCharacters(value, max_chars) != null) {
            return hasMoreThanMaximumCharacters(value, max_chars) + name;
        }
        if (containsSpace(value) != null) {
            return containsSpace(value) + name;
        }
        if (containsOtherCharacters(value, allowed_chars) != null) {
            return name + containsOtherCharacters(value, allowed_chars);
        }
        return null;
    }

    /**
     * The method to check if the string is empty
     * @param value
     * @return result message or null
     */
    public static String isEmpty(String value) {
        return (value.equals("") || value == null) ? " is empty" : null;
    }

    /**
     * The method to check if the string has minimum allowed characters.
     * @param value
     * @param chars
     * @return result message or null
     */
    public static String hasFewerThanMinimumCharacters(String value, int chars) {
        return (value.length() < chars) ? "minimum " + chars + " characters allowed in " : null;
    }

    /**
     * The method to check if the string has maximum allowed characters.
     * @param value
     * @param chars
     * @return result message or null
     */
    public static String hasMoreThanMaximumCharacters(String value, int chars) {
       return (value.length() > chars) ? "maximum " + chars + " characters allowed in " : null;
    }

    /**
     * The method checks if the string has spaces.
     * @param value
     * @return result message or null
     */
    public static String containsSpace(String value) {
        return (value.contains(" ")) ? "no spaces allowed in " : null;
    }

    /**
     * The method checks if the string contains unacceptable characters.
     * @param value
     * @param allowed_chars
     * @return result message or null
     */
    public static String containsOtherCharacters(String value, String allowed_chars) {
        char[] chars = value.toCharArray();
        for (char c : chars) {
            if (String.valueOf(c).matches(allowed_chars)) {
                return " contains unacceptable characters";
            }
        }
        return null;
    }

    /**
     * The method checks if the field is empty.
     * @param value
     * @return true or false
     */
    public static boolean fieldIsEmpty(String value) {
        if (value.equals("") || value == null) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean fieldHasAlphabeticChars(String value) {
        try {
            int result = Integer.parseInt(value);
        }
        catch(NumberFormatException nfe)
        {
            return true;
        }
        return false;
    }

}
