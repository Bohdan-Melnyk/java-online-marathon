package task6;

import java.util.Iterator;

public class AdressBook implements Iterable {
	private NameAdressPair[] adressBook;
	private int counter = 0;
	
	public AdressBook(int capacity) {
		adressBook = new NameAdressPair[capacity];
	}
		
	public boolean create(String firstName, String lastName, String adress) {
		
		
		return false;
	}
	public String read(String firstName, String lastName) {
		return "read";
	}
	public boolean updte(String firstName, String lastName, String adress) {
		return false;
	}
	public boolean delete(String firstName, String lastName) {
		return false;
	}
	public int size() {
		return 0;
	}
	public void sortedBy(SortOrder order) {
		System.out.println("Sorted");
	}
	@Override
	public Iterator iterator() {
		
		return null;
	}
	
	
	
	
	private static class NameAdressPair {
		Person person;
		String adress;
		
		
		private NameAdressPair(Person person, String adress) {
			this.person = person;
			this.adress = adress;
		}
		
		


		@Override
		public String toString() {
			return  person + " Adress=" + adress;
		}




		private static class Person {
			private String firstName, lastName;

			public Person(String firstName, String lastName) {
				this.firstName = firstName;
				this.lastName = lastName;
			}

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
				result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
				return result;
			}

			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Person other = (Person) obj;
				if (firstName == null) {
					if (other.firstName != null)
						return false;
				} else if (!firstName.equals(other.firstName))
					return false;
				if (lastName == null) {
					if (other.lastName != null)
						return false;
				} else if (!lastName.equals(other.lastName))
					return false;
				return true;
			}

			@Override
			public String toString() {
				return "FirstName=" + firstName + ", LastName=" + lastName;
			}
			
			

			
		}
	}
	private class AdressBookIterator implements Iterator {
		private int counter = 0;
		
		public boolean hasNext() {
			return counter < adressBook.length;
		}
		public String next() {
			return adressBook[counter++].toString();
		}
	}
	
}
