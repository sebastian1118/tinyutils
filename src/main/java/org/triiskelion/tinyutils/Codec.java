package org.triiskelion.tinyutils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Out-of-box codec functions
 * based on Apache commons-codec
 */
public class Codec {

	private static Logger log = LoggerFactory.getLogger(Codec.class);

	/**
	 * Calculate string's md5 digest.
	 *
	 * @param string
	 *
	 * @return
	 */
	public static String md5(String string) {

		return DigestUtils.md5Hex(string);
	}

	public static String sha1(String string) {

		return DigestUtils.sha1Hex(string);
	}

	public static String base64encode(String string) {

		return Base64.encodeBase64String(string.getBytes());
	}

	public static String base64decode(String string) {

		return new String(Base64.decodeBase64(string));
	}

	public static byte[] desEncode(byte[] array, String key) {

		javax.crypto.SecretKey generatedKey;
		KeyGenerator generator;
		try {
			generator = KeyGenerator.getInstance("DES");

			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(key.getBytes());
			generator.init(secureRandom);
			generatedKey = generator.generateKey();
			generator = null;

			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, generatedKey);
			return cipher.doFinal(array);
		} catch(NoSuchAlgorithmException e) {
			log.error("DES encryption failed. {}", e.getMessage());
		} catch(IllegalBlockSizeException | InvalidKeyException | BadPaddingException |
				NoSuchPaddingException e) {
			e.printStackTrace();
		}
		return null;

	}

	public byte[] desDecode(byte[] array, String key) {

		javax.crypto.SecretKey generatedKey;
		KeyGenerator generator;
		try {
			generator = KeyGenerator.getInstance("DES");

			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(key.getBytes());
			generator.init(secureRandom);
			generatedKey = generator.generateKey();
			generator = null;

			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, generatedKey);
			return cipher.doFinal(array);
		} catch(NoSuchAlgorithmException e) {
			log.error("DES decryption failed.", e);
		} catch(IllegalBlockSizeException | InvalidKeyException | BadPaddingException |
				NoSuchPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
