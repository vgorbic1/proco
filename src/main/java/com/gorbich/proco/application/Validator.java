package com.gorbich.proco.application;

import org.apache.log4j.Logger;

/**
 * Created by Vlad on 3/27/2016.
 */
public class Validator {
    //public final Logger log = Logger.getLogger(this.getClass());

    public static String validateUsername(String value) {
        final String NAME = "username";
        final int MIN_CHARACTERS = 3;
        final int MAX_CHARACTERS = 20;
        final String ALLOWED_CHARACTERS = "[^a-zA-Z0-9 ]"; // alphanumeric

        if (isEmpty(value) != null) {
            return NAME + isEmpty(value);
        }
        if (hasFewerThanMinimumCharacters(value, MIN_CHARACTERS) != null) {
            return hasFewerThanMinimumCharacters(value, MIN_CHARACTERS) + NAME;
        }
        if (hasMoreThanMaximumCharacters(value, MAX_CHARACTERS) != null) {
            return hasMoreThanMaximumCharacters(value, MAX_CHARACTERS) + NAME;
        }
        if (containsSpace(value) != null) {
            return containsSpace(value) + NAME;
        }
        if (containsOtherCharacters(value, ALLOWED_CHARACTERS) != null) {
            return NAME + containsOtherCharacters(value, ALLOWED_CHARACTERS);
        }
        return null;
    }

    public static String validatePassword(String value) {
        final String NAME = "password";
        final int MIN_CHARACTERS = 6;
        final int MAX_CHARACTERS = 20;
        final String ALLOWED_CHARACTERS = "[^a-zA-Z0-9\\Q!@#$%^&*()-=_+{}[]:;'?.\\E ]";

        if (isEmpty(value) != null) {
            return NAME + isEmpty(value);
        }
        if (hasFewerThanMinimumCharacters(value, MIN_CHARACTERS) != null) {
            return hasFewerThanMinimumCharacters(value, MIN_CHARACTERS) + NAME;
        }
        if (hasMoreThanMaximumCharacters(value, MAX_CHARACTERS) != null) {
            return hasMoreThanMaximumCharacters(value, MAX_CHARACTERS) + NAME;
        }
        if (containsSpace(value) != null) {
            return containsSpace(value) + NAME;
        }
        if (containsOtherCharacters(value, ALLOWED_CHARACTERS) != null) {
            return NAME + containsOtherCharacters(value, ALLOWED_CHARACTERS);
        }
        return null;
    }

    public static String isEmpty(String value) {
        return (value.equals("") || value == null) ? " is empty" : null;
    }

    public static String hasFewerThanMinimumCharacters(String value, int chars) {
        return (value.length() < chars) ? "Minimum " + chars + " characters allowed in " : null;
    }

    public static String hasMoreThanMaximumCharacters(String value, int chars) {
       return (value.length() > chars) ? "Maximum " + chars + " characters allowed in " : null;
    }

    public static String containsSpace(String value) {
        return (value.contains(" ")) ? "No spaces allowed in " : null;
    }

    public static String containsOtherCharacters(String value, String ALLOWED_CHARACTERS) {
        char[] chars = value.toCharArray();
        for (char c : chars) {
            if (String.valueOf(c).matches(ALLOWED_CHARACTERS)) {
                return " contains unacceptable characters";
            }
        }
        return null;
    }

    public static boolean fieldIsEmpty(String value) {
        if (value.equals("") || value == null) {
            return true;
        } else {
            return false;
        }
    }

}
