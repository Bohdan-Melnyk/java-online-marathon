package sprint4_task3;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MyUtil {
	public boolean listMapCompare(List<String> list, Map<String, String> map) {
		boolean flag = true;
		
			for(Map.Entry<String, String> m : map.entrySet()) {
				if (list.indexOf(m.getValue()) == -1) {
					flag = false;
					break;
				}

		}
		return flag;
	}

}
