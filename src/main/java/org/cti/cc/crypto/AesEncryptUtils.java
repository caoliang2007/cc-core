package org.cti.cc.crypto;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by caoliang on 2020/11/2
 * <p>
 * 工作模式[CBC，CFB，ECB，OFB，PCBC]
 * <p>
 * 填充方式[NoPadding/zero，PKCS5Padding , PKCS7Padding ，ISO10126Padding]
 */
public class AesEncryptUtils {


    //参数分别代表 算法名称/加密模式/数据填充方式
    private static final String ALGORITHMSTR = "AES/ECB/PKCS5Padding";

    /**
     * 加密
     *
     * @param data
     * @param password 推荐使用16位
     * @return
     */
    public static String encryptAES(String data, String password) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        if (StringUtils.isBlank(data)) {
            return null;
        }
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
        SecretKeySpec secretKeySpec = new SecretKeySpec(password.getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] encrypted = cipher.doFinal(data.getBytes());
        return Base64.encodeBase64String(encrypted);
    }

    /**
     * 解密
     *
     * @param decryptCode
     * @param password
     * @return
     */
    public static String decryptAES(String decryptCode, String password) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        if (StringUtils.isBlank(decryptCode)) {
            return null;
        }
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
        SecretKeySpec secretKeySpec = new SecretKeySpec(password.getBytes(), "AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] encryptByte = Base64.decodeBase64(decryptCode);
        byte[] original = cipher.doFinal(encryptByte);
        return new String(original);
    }
}
