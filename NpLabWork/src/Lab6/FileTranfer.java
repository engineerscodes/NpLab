/**
 * 
 */
package Lab6;

import java.util.*;
import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FileTranfer implements Serializable {

	public String name;
	public int length;
	public byte content[];
	
	
	public FileTranfer(String name, int length, byte[] content) {
		super();
		this.name = name;
		this.length = length;
		this.content = content;
	}


	public String toString() {
		return name;
	}
       
        

	
	
}

