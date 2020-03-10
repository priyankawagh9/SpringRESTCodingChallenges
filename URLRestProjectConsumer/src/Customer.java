

import java.util.List;

public class Customer {
	public static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private List<String> hobbies;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	public Customer(int id, String name, List<String> hobbies) {
		super();
		this.id = id;
		this.name = name;
		this.hobbies = hobbies;
	}
	public Customer() {
		super();
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", hobbies=" + hobbies + "]";
	}
	
}
