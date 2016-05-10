package com.gorbich.proco.application;

import junit.framework.TestCase;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Tests Validator methods.
 */
public class ValidatorTest extends TestCase {
    public final Logger log = Logger.getLogger(this.getClass());

    @Test
    public void testValidate() throws Exception {
        String value = "testValue";
        String name = "testName";
        int min_chars = 2;
        int max_chars = 9;
        String allowed_chars = "[^a-zA-Z0-9 ]";
        String result = Validator.validate(value, name, min_chars, max_chars, allowed_chars);
        assertTrue(result == null);
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertTrue(Validator.isEmpty("").equals(" is empty"));
    }

    @Test
    public void testHasFewerThanMinimumCharacters() throws Exception {
        assertTrue(Validator.hasFewerThanMinimumCharacters("a", 2)
                .equals("minimum 2 characters allowed in "));
    }

    @Test
    public void testHasMoreThanMaximumCharacters() throws Exception {
        assertTrue(Validator.hasMoreThanMaximumCharacters("abc", 2)
                .equals("maximum 2 characters allowed in "));
    }

    @Test
    public void testContainsSpace() throws Exception {
        assertTrue(Validator.containsSpace("a c")
                .equals("no spaces allowed in "));
    }

    @Test
    public void testContainsOtherCharacters() throws Exception {
        assertTrue(Validator.containsOtherCharacters("%", "[^a-zA-Z0-9 ]")
                .equals(" contains unacceptable characters"));
    }

    @Test
    public void testFieldIsEmpty() throws Exception {
        assertTrue(Validator.fieldIsEmpty(""));
    }

    @Test
    public void testFieldHasAlphabeticChars() throws Exception {
        assertTrue(Validator.fieldHasAlphabeticChars("a"));
    }

}