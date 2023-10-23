package com.dhockley2001.atm.atm.utils;

import org.mindrot.jbcrypt.BCrypt;

public class PINManager {

    private PINManager() {
        // Empty Constructor
    }

    public static class PINInfo  {
        private String PIN;
        private String salt;

        public PINInfo(final String PIN) {
            this.salt = BCrypt.gensalt();
            this.PIN = BCrypt.hashpw(PIN, this.salt);
        }

        public String getPIN() {
            return this.PIN;
        }

        public String getSalt() {
            return this.salt;
        }
    }

    public static PINInfo hashPIN(String pin) {
        return new PINInfo(pin);
    }

    public static boolean verifyPIN(String enteredPIN, String storedPIN) {
        return BCrypt.checkpw(enteredPIN, storedPIN);
    }
}

