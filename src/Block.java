import java.util.Date;


public class Block {

	public String previousHash = null;
	public String hash = null;
	private String data = null;
	private long timeStamp;
	
	public Block(String data, String previousHash) {
		this.previousHash = previousHash;
		this.hash = calculateHash();
		this.data = data;
		this.timeStamp = new Date().getTime();
	}
	
	private String calculateHash() {
		String hash = HashHelper.applySHA256(this.previousHash + this.timeStamp + this.data);
		
		return hash;
	}
	
	// Getters (and setters?)
	public String getHash() {
		return hash;
	}
	
	public String getData() {
		return data;
	}
	
}
