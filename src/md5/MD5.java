package md5;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5 {

    // md5 hashing algorithm
    private String md5Hashing(String value) throws Exception {
        MessageDigest algo = MessageDigest.getInstance("MD5");
        algo.update(value.getBytes(), 0, value.length());

        return new BigInteger(1, algo.digest()).toString(16);
    }

    // hash password using md5
    public String md5(String pass) {
        String md5 = null;

        try {
            md5 = md5Hashing(pass);
        } catch (Exception a) {
            a.printStackTrace();
        }

        return md5;
    }

}
