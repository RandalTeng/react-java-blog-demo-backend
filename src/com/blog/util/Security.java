package com.blog.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * com.blog.util
 *
 * @author Created by randal on 18-6-27.
 */
public class Security {
    /**
     * 生成字符串MD5值
     */
    public static String string2Md5(String str) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("md5");
        byte[] btStr = digest.digest(str.getBytes());
        StringBuilder builder = new StringBuilder();

        for (byte b : btStr) {
            int i = b & 0xff;
            String is = Integer.toHexString(i);
            if (is.length() == 1) {
                builder.append("0");
            }
            builder.append(is);
        }

        return builder.toString();
    }
}
