package action;

import java.sql.Date;

import action.Base.ReaderBaseAction;
import domain.Person;

/**
 * 注册Action
 * @author lenovo
 * @version 创建时间：2019年4月10日上午9:12:24
 */
public class RegistAction extends ReaderBaseAction {

	private static final long serialVersionUID = 1L;

	private Person person;
	private String repassword;
	//person的getter和setter方法
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	//repassword的getter和setter方法
	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	/**
	 * 保存用户
	 * 
	 * @return
	 * @throws Exception
	 */
	public String savePerson() throws Exception {
		person.setCreate_date(new Date(new java.util.Date().getTime()));
		person.setIfManager("否");
		person.setNote("无");
		if(ms.findPersonByUser(person.getUser()) != null) {
			addActionMessage("用户名已存在，建议你允许浏览器使用JavaScript"); 
			return ERROR;
		}
		if(!repassword.equals(person.getPassword())) {
			addActionMessage("两次密码不一样，建议你允许浏览器使用JavaScript"); 
			return ERROR;
		}
		if (ms.saveReader(person)) {
			return SUCCESS;	
		}
		addActionMessage("注册失败");
		return ERROR;
	}

}
