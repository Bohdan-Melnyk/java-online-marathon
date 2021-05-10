package sprint7_task4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FromBytes {
	public static String readFile(String filename) {
		
		String res = "";
		try (FileReader fr = new FileReader(filename)) {
			String str = "";
			
			int i = 0;
			while ((i = fr.read()) != -1) {
				str += (char) i;
				if (str.length() == 7) {
					int numb = Integer.parseInt(str, 2);
	                res += (char) numb;
					str = "";
				}
			}
			
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		return res;
		
//		String res = "";
//		try (FileReader fr = new FileReader(filename)) {
//			String str = "";
//			
//			int i = 0;
//			while ((i = fr.read()) != -1) {
//				str += (char) i;
//				char[] c = str.toCharArray();
//				byte[] bit = new byte[c.length];
//				for (int j = 0; j < c.length; j++) {
//					bit[i] =Byte.parseByte(c[i], 2);
//					res += bit;
//				}
//			}
//			
//			
//		}catch (IOException e) {
//			e.printStackTrace();
//		}
//		return res;
	}
}
