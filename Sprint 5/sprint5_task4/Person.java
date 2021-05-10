package sprint5_task4;

public class Person {
	private String firstName, lastName, idCode;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) throws IllegalArgumentException, NameException {
		if (firstName.matches("^([A-Z]{1}[a-z]{1,30})$")) {
			this.firstName = firstName;
		} else
			throw new NameException("\"Incorrect value " + firstName
					+ " for  (should start from upper case and contains only alphabetic characters and -, _)\"");
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) throws IllegalArgumentException, NameException {
		if (lastName.matches("^([A-Z]{1}[a-z]{1,30})$")) {
			this.lastName = lastName;
		} else
			throw new NameException("Incorrect value " + firstName
					+ " for firstName (should start from upper case and contains only alphabetic characters and symbols -, _)");
	}

	public String getIdCode() {

		return idCode;
	}

	public void setIdCode(String idCode) throws IllegalArgumentException, CodeException {
		if (idCode.matches("^[0-9]{10}$")) {
			this.idCode = idCode;
		} else {
			throw new CodeException("Incorrect value " + idCode + " for code (should contains exactly 10 digits)");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((idCode == null) ? 0 : idCode.hashCode());
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
		if (idCode == null) {
			if (other.idCode != null)
				return false;
		} else if (!idCode.equals(other.idCode))
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
		return firstName + " " + lastName + ": " + idCode;
	}

	public static Person buildPerson(String firstName, String lastName, String idCode) throws IllegalArgumentException {
		Person person = new Person();
        String log = "";
        try {
            try {
                person.setIdCode(idCode);
            } catch (RuntimeException e) {
                log += e.getMessage();
            }
            person.setFirstName(firstName);
            person.setLastName(lastName);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException(e.getMessage() + "; " + log);
        }

        return  person;

	}
}
