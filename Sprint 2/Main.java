import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		MyUtils3 my = new MyUtils3();
		List<Person> pers = new ArrayList<>();
		Person s1 = new Student("gg", "vdfbd", 2);
		Person s2 = new Student("ggg", "vdfSbfxbd", 10);
		Person w1 = new Worker("miku", "jobless", 12);
		Person w2 = new Worker("mikus", "job", 13);
		pers.add(s1);
		pers.add(s2);
		pers.add(w1);
		pers.add(w2);
		my.maxDuration(pers);

	}

}
