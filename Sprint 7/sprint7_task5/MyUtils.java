package sprint7_task5;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

public class MyUtils {
	public Stream<String> nameList(Map<String, Stream<String>> map) {
		if (map == null) {
			throw new NullPointerException();
		}

		return map.values().stream().flatMap(x -> x).filter(x -> x != null).map(m -> m.replace(" ", ""))
				.filter(m -> !m.isEmpty()).map(m -> m.toLowerCase()).distinct()
				.map(m -> m.substring(0, 1).toUpperCase() + m.substring(1)).sorted();
	}
}
