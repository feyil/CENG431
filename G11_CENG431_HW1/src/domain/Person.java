package domain;

public abstract class Person implements IResource {
	private String name;
	private String surname;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {	
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
}
