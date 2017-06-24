package symm;

public class Verfahren {
	static final int NUM = 95;
	static final int OFFSET = 8;

	public int[] encrypt(String msg) {
		int[] intClearArray = convertToInt(msg);
		int skey0 = SessionKeyGenerator.getSessionKey();
		int skey1 = SessionKeyGenerator.getSessionKey();
		while (skey1 == skey0) {
			skey1 = SessionKeyGenerator.getSessionKey();
		}
		int[] intKryptArray = new int[intClearArray.length + 8];
		intKryptArray[0] = skey0;
		intKryptArray[1] = skey1;
		for (int i = 0; i < intClearArray.length; i++) {
			if (i % 2 == 0) {
				intKryptArray[i + OFFSET] = (intClearArray[i] + skey1) % NUM;
			} else {
				intKryptArray[i + OFFSET] = (intClearArray[i] + skey0) % NUM;
			}

		}
		return intKryptArray;

	}

	public String decrypt(int[] intKryptArray) {
		int msgLen = intKryptArray.length - OFFSET;
		int[] intClearArray = new int[msgLen];
		int skey0 = intKryptArray[0];
		int skey1 = intKryptArray[1];

		for (int i = 0; i < msgLen; i++) {
			if (i % 2 == 0) {
				intClearArray[i] = (intKryptArray[i + OFFSET] + (NUM - skey0)) % NUM;
			} else {
				intClearArray[i] = (intKryptArray[i + OFFSET] + (NUM - skey1)) % NUM;
			}
		}
		return convertToString(intClearArray);
	}

	public static final int INT2CHAR = 32;

	public int[] convertToInt(String str) {
		int[] temp = new int[str.length()];
		int i = 0;
		for (char c : str.toCharArray()) {
			temp[i] = (int) (c - INT2CHAR);
			i++;
		}
		return temp;
	}

	public String convertToString(int[] intClearArray) {
		char[] charClearArray = new char[intClearArray.length];
		for (int i = 0; i < intClearArray.length; i++) {
			charClearArray[i] = (char) (intClearArray[i] + INT2CHAR);
		}
		return String.valueOf(charClearArray);
	}
}
