import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class HashHelper {

	public static String applySHA256(String str) {
		try {
			MessageDigest digest = null;
			try {
				digest = MessageDigest.getInstance("SHA-256");
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			
			
			byte[] hash = digest.digest(str.getBytes(StandardCharsets.UTF_8));
			
			
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) hexString.append('0');
					hexString.append(hex);
				}
			
		    return hexString.toString();
		} catch(Exception e) {
			throw new RuntimeException();
		}
	}
	
}
