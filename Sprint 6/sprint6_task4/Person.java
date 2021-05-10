package sprint6_task4;

import java.util.ArrayList;
import java.util.List;

public class Person {
	String name;    

    Person(String name) {
        this.name = name;        
    }
    
    DecisionMethod goShopping = (String str, int discount) -> {
    	if (str == "product1" && discount > 10) {
    		return true;
    	} else {
    		return false;
    	}
    };
}

class Shop {
public List<DecisionMethod> clients = new ArrayList<>();    
    
    public int sale(String product, int percent) {
        
        return (int) clients.stream().filter(c -> c.decide(product, percent)).count();
    }
}

interface DecisionMethod {
	boolean decide(String str, int discount);
}