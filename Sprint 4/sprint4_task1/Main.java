package sprint4_task1;


import sprint4_task4.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sprint4_task3.*;

public class Main {
	static class App<T>{
		
	}
	
	public static void main(String[] args) {
//		int[] numbers = new int[3];
//		numbers[0] = 44;
//		numbers[1] = 55;
//		numbers[2] = 66;
//		for (int i = 0;i < numbers.length; i++) {
//			System.out.println(numbers);
//		}
//		int numb = ArrayUtil.setAndReturn(numbers, 52, 1);
//		for (int i = 0;i < numbers.length; i++) {
//			System.out.println(numbers);
//		}
		
//		String[] str = new String[3];
//		String smth = ArrayUtil.setAndReturn(str, "hello", 1);
//		System.out.println(smth);
		List<String> l1 = new ArrayList<>();
		
		
		l1.add("aa");
		l1.add("bb");
		l1.add("aa");
		l1.add("cc");
		Map<String, String> m1 = new HashMap<>();
		m1.put("1", "cc");
		m1.put("2", "bb");
		m1.put("3", "cc");
		m1.put("4", "aa");
		m1.put("5", "cc");
		MyUtil my = new MyUtil();
		System.out.println(my.listMapCompare(l1, m1));
	}

}
