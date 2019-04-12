/*	SimpleBlockChain
 * 
 * 	Written by Jared Caruso
 * 	11/13/2018
 * 
 * 	This program demonstrates a very primitive and basic blockchain
 */

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import javax.swing.*;

import org.apache.commons.io.FileUtils;

import com.google.gson.*;

public class SimpleBlockChain {

	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	
	public static void main(String[] args) {
		
		blockchain.add(new Block("Hello Blockchain", ""));
		blockchain.add(new Block("I am the second block", blockchain.get(blockchain.size()-1).getHash()));
		blockchain.add(new Block("L, did you know gods of death like apples?", blockchain.get(blockchain.size()-1).getHash()));

		for (int i = 0; i < blockchain.size(); i++) {
			System.out.println(blockchain.get(i).getHash() + " : " + blockchain.get(i).getData());
		}
		
		createJson();
	}


	
	public static void createJson() {
		
		try {
			String outputFileName = JOptionPane.showInputDialog("Enter the name of the output file (.json is added automatically)");
			if (outputFileName != null) {
				outputFileName = outputFileName + ".json";
				
				String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
				
				FileUtils.writeStringToFile(new File(outputFileName), blockchainJson, StandardCharsets.UTF_8);
				
				System.out.println(blockchainJson);
			} else {
				System.out.println("The Json could not be created");
			}
		} catch (Exception e) {
			System.out.println("The Json could not be created");
			e.printStackTrace();
		}
		
	}
	
}
