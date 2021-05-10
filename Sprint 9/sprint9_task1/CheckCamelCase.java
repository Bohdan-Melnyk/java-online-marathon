package sprint9_task1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface CamelCase{
	
}

public class CheckCamelCase {
	
	public static final String CAMELCASE_PATTERN = "([a-z][a-z0-9]+[A-Z]?)+";
	 
	public static boolean checkAndPrint(Class clazz) {
		boolean flag = true;
		Method[] methods = clazz.getMethods();
		for (Method m : methods) {
			if (m.isAnnotationPresent(CamelCase.class) && !m.getName().matches(CAMELCASE_PATTERN)) {
				flag = false;
				System.out.println("method " + clazz.getName() + "." + m.getName() +
                        " doesn't satisfy camelCase naming convention");
			}
		}
		
		return flag;
	}
}

class ClassForAnnot {
	@CamelCase
	public static void example() {
	}

	@CamelCase
	public void Example() {
	}

	public static void _main(String args[]) {
	}
}

class Class1 {
	@CamelCase
	public void correct() {
	}

	@CamelCase
	public void InCorrect() {
	}

	@CamelCase
	public void JustMethod() {
	}
}

class Class2 {
	@CamelCase
	public void correct() {
	}

	@CamelCase
	public void oneMoreCorrect() {
	}
}