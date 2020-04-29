package com.example.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * token生成类, 生成简易token用于验证
 * 
 * @ClassName: TokenProcessor
 * @author jytech
 * @date 2018年3月1日 下午8:44:45 
 * @version V1.0
 */
public class TokenProcessor {

	private static TokenProcessor _instance = new TokenProcessor();

	private long _previous;

	protected TokenProcessor() {}

	/**
	 * @return _instance
	 */
	public static TokenProcessor getInstance() {
		return _instance;
	}

	/**
	 * 
	 * @param msg msg
	 * @param timeChange boolean
	 * @return ""
	 */
	public final synchronized String generateToken(String msg, boolean timeChange) {
		try {
			long current = System.currentTimeMillis();
			if (current == _previous)
				current = current + 1;
			_previous = current;
			final MessageDigest sha = MessageDigest.getInstance("SHA-1");
			sha.update(msg.getBytes());
			if (timeChange) {
				// byte now[] = (current+"").toString().getBytes();
				final byte[] now = (new Long(current)).toString().getBytes();
				sha.update(now);
			}
			return toHex(sha.digest());
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

	/**
	 * @param buffer buffer
	 * @return
	 */
	private String toHex(byte[] buffer) {
		final StringBuffer sb = new StringBuffer(buffer.length * 2);
		for (int i = 0; i < buffer.length; i = i + 1) {
			final int twoFourZero = 240;
			final int four = 4;
			final int sixteen = 16;
			final int fifteen = 15;
			sb.append(Character.forDigit((buffer[i] & twoFourZero) >> four, sixteen));
			sb.append(Character.forDigit(buffer[i] & fifteen, sixteen));
		}
		return sb.toString();
	}
	
}
