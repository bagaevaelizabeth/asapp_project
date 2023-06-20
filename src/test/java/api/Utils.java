package api;

import org.apache.commons.lang3.RandomStringUtils;

public class Utils {

    public static String getRandomString() {
        return RandomStringUtils.randomAlphanumeric(5);
    }
}
