package com.backward.chapter1;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TestChapter1 {


    //设备salt值可以在locksettings.db 数据库获取，也可以通过反射获取
//    private static final String SALT = Long.toHexString(1212);


    //获取加密的后的字符字节数组
    public static byte[] passwordToHash(String password) {

        Long salt = Long.parseLong("294964033842195975");
        String SALT = Long.toHexString(salt);

        if (password == null)
            return null;
        byte[] hashed = null;
        try {
            byte[] saltedPassword = (password + SALT).getBytes();
            byte[] sha1 = MessageDigest.getInstance("SHA-1").digest(saltedPassword);
            byte[] md5 = MessageDigest.getInstance("MD5").digest(saltedPassword);
            hashed = (toHex(sha1) + toHex(md5)).getBytes();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashed;
    }


    // 将字节数组转换成16进制字符串
    private static String toHex(byte[] array) {
        final String hex = "0123456789ABCDEF";
        String result = "";
        for (int i = 0; i < array.length; i++) {
            result += hex.charAt((array[i] >> 4) & 0xf);
            result += hex.charAt(array[i] & 0xf);

        }
        return result;
    }

    public static void main(String[] args) {
        String passwordKey = new String(passwordToHash("1234"));
        if ("2603CA366690C7FA167BA5F7F50BD60D55D474F8D868E4553A9D920DCE61CAF122E2672C".equals(passwordKey)) {
            System.out.println("密码正确");
        } else {
            System.out.println("密码错误");
        }
    }

}
