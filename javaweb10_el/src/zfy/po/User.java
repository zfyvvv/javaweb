package zfy.po;

import org.slf4j.agent.AgentOptions;

public class User {
	private String name;
	private int age;
	private Address add;
	public User() {
	}
	public User(String name, int age, Address add) {
		super();
		this.name = name;
		this.age = age;
		this.add = add;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Address getAdd() {
		return add;
	}
	public void setAdd(Address add) {
		this.add = add;
	}
	
	

}
