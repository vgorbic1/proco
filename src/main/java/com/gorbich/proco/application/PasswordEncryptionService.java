package com.gorbich.proco.application;

import org.apache.log4j.Logger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
/**
 * Utility class to encrypt user password
 * and generate salt hash
 * @author Vlad Gorbich.
 */
public class PasswordEncryptionService {

    private final Logger log = Logger.getLogger(this.getClass());

    public boolean authenticate(String attemptedPassword, byte[] encryptedPassword, byte[] salt) {
        byte[] encryptedAttemptedPassword = getEncryptedPassword(attemptedPassword, salt);
        return Arrays.equals(encryptedPassword, encryptedAttemptedPassword);
    }

    public byte[] getEncryptedPassword(String password, byte[] salt) {
        byte[] encryptedPass = null;
        String algorithm = "PBKDF2WithHmacSHA1";
        int derivedKeyLength = 160;
        int iterations = 20000;
        SecretKeyFactory f;
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, derivedKeyLength);
        try {
            f = SecretKeyFactory.getInstance(algorithm);
            encryptedPass = f.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException e) {
            log.error(e);
        } catch (InvalidKeySpecException e) {
            log.error(e);
        }
        return encryptedPass;
    }

    public byte[] generateSalt() {
        byte[] salt = null;
        try {
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            salt = new byte[8];
            random.nextBytes(salt);
        } catch (NoSuchAlgorithmException e) {
            log.error(e);
        }
        return salt;
    }
}
