package com.jlp.mvvm_jlp_project.utils;

import android.text.TextUtils;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ganesha on 12/8/2016.
 */

public class StringUtils {

    /**
     * Validate the password with at least one alphabet and one number
     * @param password
     * @return true or false
     */
    public static boolean isValidPassword(final String password) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();

    }

}
