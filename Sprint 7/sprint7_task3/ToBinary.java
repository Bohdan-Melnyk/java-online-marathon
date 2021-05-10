package sprint7_task3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ToBinary {
	public static void writeFile(String filename, String text) {
		byte[] binary = text.getBytes();
		String res = "";
//		for (int i = 0; i < binary.length; i++) {
//			String str = "";
//			str += Integer.toBinaryString(binary[i]);
//			if (str.length() < 7) {
//				str += "0";
//			}
//			res += str;
//			}
		for (int i = 0; i < binary.length; i++) {
			res += String.format("%7s", Integer.toBinaryString(binary[i])).replace(' ', '0'); 
		}
		
 		try (FileWriter fr = new FileWriter(filename)){
			fr.write(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
 		
	}
}
