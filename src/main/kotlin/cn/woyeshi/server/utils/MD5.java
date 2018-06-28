package cn.woyeshi.server.utils;

import java.security.MessageDigest;

public class MD5 {
    private static final String TAG = "MD5";

    private MD5() {
    }

    public static String getMD5(byte[] buffer) {
        Logger.INSTANCE.i(MD5.class, "md5 start time" + System.currentTimeMillis());
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(buffer);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            Logger.INSTANCE.i(MD5.class, "md5 end time" + System.currentTimeMillis());
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }
}
