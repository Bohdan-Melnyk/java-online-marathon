package sprint4_task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyUtils {
	
	public Map<String, List<String>> createNoteBook(Map<String, String> phones){
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		
		for (Map.Entry<String, String> entry : phones.entrySet()) {
			if (entry.getValue() != null && entry.getKey() != null) {
				if (!map.containsKey(entry.getValue())) {
					map.put(entry.getValue(), new ArrayList<String>());
				}
				map.get(entry.getValue()).add(entry.getKey());
			}
		}
		
		return map;
	}
}
