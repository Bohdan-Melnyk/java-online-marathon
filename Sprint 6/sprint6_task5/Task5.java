package sprint6_task5;

import java.util.function.Predicate;
import java.util.Set;

public class Task5 {
	static Predicate<Integer> getPredicateFromSet(Set<Predicate<Integer>> set) {
		
		Predicate<Integer> res = x -> true;
		for (Predicate<Integer> p : set) {
			res = res.and(p);
		}
		return res;
	}
}
