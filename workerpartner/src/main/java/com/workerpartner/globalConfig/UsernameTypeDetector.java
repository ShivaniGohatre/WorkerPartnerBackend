package com.workerpartner.globalConfig;

import java.util.regex.Pattern;

public class UsernameTypeDetector {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

    private static final Pattern PHONE_PATTERN =
            Pattern.compile("^[0-9]{10}$");

    public  boolean isEmail(String username) {
        return EMAIL_PATTERN.matcher(username).matches();
    }

    public  boolean isPhone(String username) {
        return PHONE_PATTERN.matcher(username).matches();
    }
}
