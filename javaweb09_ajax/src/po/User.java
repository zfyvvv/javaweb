package po;

import com.sun.xml.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

public class User {
	private int uid;
	private String name;
	private int price;
	private String loc;
	private String desc;
	public User() {
		super();
	}
	public User(int uid, String name, int price, String loc, String desc) {
		super();
		this.uid = uid;
		this.name = name;
		this.price = price;
		this.loc = loc;
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", price=" + price
				+ ", loc=" + loc + ", desc=" + desc + "]";
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	

}
