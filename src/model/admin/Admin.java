package model.admin;

public class Admin {
	private Integer id;         //用户id
	private String username;//用户名
	private String password;//密码
	private Integer sex;        //性别
	private String idnumber;//身份证号
	private String tel;     //电话号码
	private String addr;    //家庭住址
	private Integer type;       //用户 类型
	public Admin(Integer id, String username, String password, Integer sex, String idnumber, String tel, String addr,
			Integer type) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.idnumber = idnumber;
		this.tel = tel;
		this.addr = addr;
		this.type = type;
	}
	public Admin() {
	
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", password=" + password + ", sex=" + sex + ", idnumber="
				+ idnumber + ", tel=" + tel + ", addr=" + addr + ", type=" + type + "]";
	}
	
}
