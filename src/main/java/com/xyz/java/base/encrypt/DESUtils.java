package com.xyz.java.base.encrypt;

import cn.jiangzeyin.des.SystemKey;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;

/**
 * 类: DESUtils <br>
 * 描述:
 * 对称加密算法工具类
 * DES加密介绍
 * DES是一种对称加密算法，所谓对称加密算法即：加密和解密使用相同密钥的算法。DES加密算法出自IBM的研究，
 * 后来被美国政府正式采用，之后开始广泛流传，但是近些年使用越来越少，因为DES使用56位密钥，以现代计算能力，
 * 24小时内即可被破解。虽然如此，在某些简单应用中，我们还是可以使用DES加密算法，本文简单讲解DES的JAVA实现
 * 注意：DES加密和解密过程中，密钥长度都必须是8的倍数
 * <br>
 * 作者:  gaoxugang<br>
 * 时间: 2018年10月30日 10:13
 */
public class DESUtils {

    private static final String TRANSFORM_ATION = "DES/ECB/PKCS5Padding";

    private static final String ALGORITHM = "DES";


    private DESUtils() {}

    /**
     * 加密方法
     * @param text 待加密内容
     * @param secret 加密秘钥
     * @return
     */
    public static String encrypt(String text,String secret) throws Exception {
        KeySpec keySpec = new DESKeySpec(secret.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        SecretKey secretKey = keyFactory.generateSecret(keySpec);
        Cipher cipher = Cipher.getInstance(TRANSFORM_ATION);
        cipher.init(Cipher.ENCRYPT_MODE,secretKey,new SecureRandom());
        byte[] bytes = cipher.doFinal(text.getBytes("UTF-8"));
        BASE64Encoder base64Encoder = new BASE64Encoder();
        // 对数据进行BASE64处理
        return new String(base64Encoder.encode(bytes));
    }

    /**
     * 解密方法
     * @param text  贷解密的内容
     * @param secret  解密秘钥
     * @return
     */
    public static String decrypt(String text,String secret) throws Exception{
        BASE64Decoder base64Decoder = new BASE64Decoder();
        byte[] decodeBuffer = base64Decoder.decodeBuffer(text); // 先BASE64解密
        DESKeySpec desKey = new DESKeySpec(secret.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        SecretKey securekey = keyFactory.generateSecret(desKey);
        // 将DESKeySpec对象转换成SecretKey对象
        Cipher cipher = Cipher.getInstance(TRANSFORM_ATION);
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, new SecureRandom());
        byte[] data = cipher.doFinal(decodeBuffer);
        return new String(data);
    }

    public static void main(String[] args) throws Exception{
//        String encryptKey = "abc12345";
//
//        String text = "高旭刚";
//        System.out.println("加密密结果：" + DESUtils.decrypt(text, encryptKey));


        SystemKey systemKey = new SystemKey("abc12345");
        String result = systemKey.encrypt("高旭刚");
        System.out.println(result);

        System.out.println(systemKey.decrypt(result));

    }
}
