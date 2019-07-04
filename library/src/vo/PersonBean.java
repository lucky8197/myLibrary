package vo;

import java.util.Date;
/**
 * personVO
*@author luoliang		
*@version 创建时间：2019年4月10日上午9:12:24
*/
public class PersonBean {
	private Integer id;
	private String user;
	private String password;
	private String name;
	private Date birthday;
	private String sex;
	private String vocation;
	private String email;
	private String tel;
	private Date create_date;
	//无残构造器
	public PersonBean() {
		
	}	
	public PersonBean(Integer id, String user, String password, String name, Date birthday, String sex, String vocation,
			String email, String tel, Date create_date, String note) {
		super();
		this.id = id;
		this.user = user;
		this.password = password;
		this.name = name;
		this.birthday = birthday;
		this.sex = sex;
		this.vocation = vocation;
		this.email = email;
		this.tel = tel;
		this.create_date = create_date;
		this.note = note;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getVocation() {
		return vocation;
	}
	public void setVocation(String vocation) {
		this.vocation = vocation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	private String note;
	
	
	
	
}
