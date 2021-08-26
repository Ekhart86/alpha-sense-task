package util;

import org.apache.commons.lang3.StringUtils;

public class RandomUtil {

    public static int getIntValue(int length) {
       return Integer.parseInt(StringUtils.right(String.valueOf(System.currentTimeMillis()), length));
    }

}
