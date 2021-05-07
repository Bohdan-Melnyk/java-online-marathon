package task2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


class NameList {
	private String[] names = { "Mike", "Emily", "Nick", "Patric", "Sara" };
	
	
	public Iterator getIterator() {
		return new Iterator();
	}

	public class Iterator {
		private int counter = 0;

		private Iterator() {
		}

		public boolean hasNext() {

			return counter < names.length;
		}

		public String next() {

			return names[counter++];
		}
	}
			
		
}
