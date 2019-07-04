package action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import action.Base.ReaderBaseAction;
import domain.Person;

/**验证用户名是否合法。以及是否存在
*@author luoliang		
*@version 创建时间：2019年4月11日上午8:38:35
*/
public class CheckUserAction extends ReaderBaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private InputStream inputStream;
	private Person person;

	//获取输入流的方法
	public InputStream getResult() {
		return inputStream;
	}
	
	//person的getter和setter方法
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * 验证用户名
	 * 
	 * @return
	 * @throws Exception
	 */
	public String checkUser() throws Exception {
		if (ms.findPersonByUser(person.getUser()) != null) {
			inputStream = new ByteArrayInputStream("用户名已存在，请重新输入".getBytes("UTF-8"));
			return SUCCESS;
		}
		inputStream = new ByteArrayInputStream("用户名符合要求".getBytes("UTF-8"));
		return SUCCESS;
	}
	
	/**
	 * 用户名验证方法
	 */
	public void validateCheckUSer() {
		String user = person.getUser();
		if(user == "" || user == null) {
			addFieldError("user" , "用户名必填");
		}
		for(int i = 0; i < user.length(); i++) {
			boolean exp = (user.codePointAt(i) >= 47 && user.codePointAt(i) <= 58) ||
					(user.codePointAt(i) >= 65 && user.codePointAt(i) <= 90) ||
					(user.codePointAt(i) >= 97 && user.codePointAt(i) <= 122);
			if(!exp) {
				addFieldError("user" , "您输入的用户名只能是字母和数字。");
			}
		}
		if(user.length() < 4 || user.length() > 20) {
			addFieldError("user" , "长度必须在4到20之间。");
		}
		
	}
}
