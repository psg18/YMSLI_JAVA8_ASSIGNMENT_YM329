package authorBook;

class Author {
	
	private String name;
	private String lastname;
	private String country;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	public Author(String name, String lastname, String country) {
		this.name = name;
		this.lastname = lastname;
		this.country = country;
	}
	
	
	public Author() {}
	
	
	@Override
	public String toString() {
		return "Author [name=" + name + ", lastname=" + lastname + ", country="
				+ country + "]";
	}
	
	
	
}
