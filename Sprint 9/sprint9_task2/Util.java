package sprint9_task2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Util {

	public static void review(String className) throws ClassNotFoundException {
		try {
			Class<?> aClass = Class.forName(className);
			String str;
			if (aClass.isAnnotationPresent(Review.class)) {
				if (aClass.getAnnotation(Review.class).date().equals("today")) {
					str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				} else {
					str = LocalDate.parse(aClass.getAnnotation(Review.class).date()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				}
				System.out.println("Class " + className + " was reviewed " + str + " by " + aClass.getAnnotation(Review.class).reviewer() + ".");
			} else {
				System.out.println("Class " + className + " isn't marked as Reviewed");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Class " + className + " was not found");
		}
	}
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Review {
	String reviewer();

	String date() default "today";
}