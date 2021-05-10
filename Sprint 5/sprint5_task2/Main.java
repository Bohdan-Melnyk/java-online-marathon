package sprint5_task2;

import sprint5_task3.ColorException;
import sprint5_task4.*;

public class Main {

	public static void main(String[] args) throws TypeException, IllegalArgumentException, ColorException {
//		Plant p1 = new Plant("Us", "WHITE", "RARE");
//		System.out.println(p1.toString());
		
		Person personSet = new Person();
		Person personBuild = new Person();
//		Person personStatic = new Person();
		
		personBuild.buildPerson("John", "Pupkin", "1234678690");
		
//		personStatic = personBuild("Ya", "Me", "1234566789");
		
		personSet.setFirstName("Pavlo");
		personSet.setLastName("Baton");
		personSet.setIdCode("1234567890");
//		
		System.out.println("PersonBuild: " + personBuild);
		System.out.println("PersonSet: " + personSet);
//		System.out.println(personStatic);
		
	
	
	}
}

