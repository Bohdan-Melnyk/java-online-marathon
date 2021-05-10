package task6;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class AdressBook implements Iterable {
	private NameAddressPair[] addressBook;
    private int counter = 0;

    public boolean create(String firstName, String lastName, String address){
        if(addressBook.length  == counter){
            addressBook = Arrays.copyOf(addressBook, 2 * counter);
        }
        NameAddressPair.Person person = new NameAddressPair.Person(firstName, lastName);
        for (int i = 0; i < counter; i++) {
        	if (addressBook[i].person.equals(person)) {
        		return false;
        	}
        }
        addressBook[counter++] = new NameAddressPair(person, address);
        return true;
    }

    public String read(String firstName, String lastName){
        NameAddressPair.Person person = new NameAddressPair.Person(firstName, lastName);
        for (int i = 0; i < counter; i++) {
        	if (addressBook[i].person.equals(person)) {
        		return addressBook[i].address;
        	}
        }
        return null;
    }

    public boolean update(String firstName, String lastName, String address){
    	NameAddressPair.Person person = new NameAddressPair.Person(firstName, lastName);
        for (int i = 0; i < counter; i++) {
        	if (addressBook[i].person.equals(person)) {
        		addressBook[i].address = address;
        		return true;
        	}
        }
        return false;
    }

    public boolean delete(String firstName, String lastName){
    	NameAddressPair.Person person = new NameAddressPair.Person(firstName, lastName);
    	for (int i = 0; i < counter; i++) {
    		if (addressBook[i].person.equals(person)) {
    			NameAddressPair[] newAddressBook = new NameAddressPair[addressBook.length];
    			System.arraycopy(addressBook, 0, newAddressBook, 0, i);
    			System.arraycopy(addressBook, i + 1, newAddressBook, i, addressBook.length - i - 1);
    			addressBook = newAddressBook;
    			counter--;
    			return true;
    		}
    	}
        return false;
    }

    public int size(){
        return counter;
    }

    public void sortedBy(SortOrder order){
        Arrays.sort(addressBook, new Comparator<NameAddressPair>(){
            @Override
            public int compare(NameAddressPair o1, NameAddressPair o2) {
                int compareFirstName = o1.person.firstName.compareTo(o2.person.firstName);
                if(compareFirstName == 0){
                    return o1.person.lastName.compareTo(o2.person.lastName);
                }
                else{
                    return compareFirstName;
                }
            }
        });
        if(order == SortOrder.DESC){
            Collections.reverse(Arrays.asList(addressBook));
        }
    }

    public Iterator iterator(){
        return new AddressBookIterator();
    }

    private static class NameAddressPair{
        private final Person person;
        private String address;

        private NameAddressPair(Person person, String address){
            this.person = person;
            this.address = address;
        }

        private static class Person{
            private String firstName;
            private String lastName;

            private Person(String firstName, String lastName){
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

            
        }
    }

    private class AddressBookIterator implements Iterator {
        private int counter = 0;
        private AddressBookIterator(){}

        public boolean hasNext(){
            if(counter < size()){
                return true;
            }
            return false;
        }

        public String next(){
            NameAddressPair curr = addressBook[counter];
            counter++;
            return "First name: " + curr.person.firstName + ", Last name: " + curr.person.lastName + ", Address: " + curr.address;
        }
    }
	
}
