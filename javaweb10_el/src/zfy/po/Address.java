package zfy.po;

public class Address {
	private String pro;
	private String city;
	private String country;
	public Address() {
	}
	public Address(String pro, String city, String country) {
		super();
		this.pro = pro;
		this.city = city;
		this.country = country;
	}
	public String getPro() {
		return pro;
	}
	public void setPro(String pro) {
		this.pro = pro;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	

}
