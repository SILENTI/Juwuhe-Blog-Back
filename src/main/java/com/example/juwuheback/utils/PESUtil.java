package com.example.juwuheback.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.security.Key;
import java.util.Base64;

public class PESUtil {

    public static final String ALGORITHM = "PBEWITHMD5andDES";

    public static final int ITERATION_COUNT = 10;

    public static final String password = "87654321";


    /***
     * 转换密钥
     * @param password 密码
     * @return 密钥
     * @throws Exception
     */
    private static Key toKey(String password) throws Exception{
        //密钥材料
        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
        //实例化
        SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
        //生成密钥
        return factory.generateSecret(keySpec);
    }

    /***
     * 加密
     * @param data 待加密数据
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data,String salt) throws Exception{
        //转换密钥
        String sub=salt.substring(0,8);
        Key key = toKey(password);
        //实例化PBE参数材料
        PBEParameterSpec spec = new PBEParameterSpec(sub.getBytes(), ITERATION_COUNT);
        //实例化
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        //初始化
        cipher.init(Cipher.ENCRYPT_MODE, key, spec);
        return cipher.doFinal(data);
    }
    public static byte[] encrypt(byte[] data) throws Exception{
        //转换密钥
        String salt="12345678";
        Key key = toKey(password);
        //实例化PBE参数材料
        PBEParameterSpec spec = new PBEParameterSpec(salt.getBytes(), ITERATION_COUNT);
        //实例化
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        //初始化
        cipher.init(Cipher.ENCRYPT_MODE, key, spec);
        return cipher.doFinal(data);
    }

    /***
     * 解密
     * @param data 待解密数据
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data,String salt) throws Exception{
        //转换密钥
        String sub=salt.substring(0,8);
        Key key = toKey(password);
        //实例化PBE参数材料
        PBEParameterSpec spec = new PBEParameterSpec(sub.getBytes(), ITERATION_COUNT);
        //实例化
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        //初始化
        cipher.init(Cipher.DECRYPT_MODE, key, spec);
        //执行操作
        return cipher.doFinal(data);
    }

    public static byte[] decrypt(byte[] data) throws Exception{
        String salt="12345678";
        //转换密钥
        Key key = toKey(password);
        //实例化PBE参数材料
        PBEParameterSpec spec = new PBEParameterSpec(salt.getBytes(), ITERATION_COUNT);
        //实例化
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        //初始化
        cipher.init(Cipher.DECRYPT_MODE, key, spec);
        //执行操作
        return cipher.doFinal(data);
    }

    private static String showByteArray(byte[] data) {
        String s = Base64.getEncoder().encodeToString(data);
        return s;
    }



    public static String isPESPassword(String data,String salt,boolean flag) throws Exception {
        String encryptData;
        if(flag)
            encryptData = showByteArray(encrypt(data.getBytes(),salt));
        else
            encryptData = new String(decrypt(Base64.getDecoder().decode(data),salt));
        return encryptData;
    }


    public static String isPESPassword(String data,boolean flag) throws Exception {
        String encryptData;
        if(flag)
            encryptData = showByteArray(encrypt(data.getBytes()));
        else
            encryptData = new String(decrypt(Base64.getDecoder().decode(data)));
        return encryptData;
    }

     /*   public static void main(String[] args) throws Exception{
        String data = "888888";
        String salt="11223123";
        System.out.println("加密前数据：String:"+data);
        String encryptData = isPESPassword(data,salt,true);
        System.out.println("加密后数据：String[]:"+encryptData );
        String decryptData = isPESPassword(encryptData,salt,false);
        System.out.println("解密后数据: string:"+new String(decryptData));
        }*/
}