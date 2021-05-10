package sprint6_task6;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.BiFunction;

public class MyUtils {
public static int findMaxByCondition(List<Integer> numbers, Predicate<Integer> pr) {
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
        	if (pr.test(numbers.get(i))) {
        		if (numbers.get(i) > max) {
        			max = numbers.get(i);
        		}
        	}
        }
	    return max;
    
    }
}

class User {
    public final List<Integer> values = new ArrayList<Integer>();   
    
    int getFilterdValue(BiFunction <List<Integer>, Predicate<Integer>, Integer> biFunc, Predicate<Integer> predicate) {
        
        return biFunc.apply(values, predicate);
        
    }
    
    int getMaxValueByCondition(Predicate<Integer> predicate) {
        
        return getFilterdValue(MyUtils::findMaxByCondition, predicate);
        
    }
}