package action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;

import action.Base.ManagerBaseAction;
import domain.Person;

/**
*@author luoliang		
*@version 创建时间：2019年4月12日下午3:57:15
*/
public class AddReaderAction extends ManagerBaseAction {

	private static final long serialVersionUID = 1L;
	
	private Person person;
	private InputStream inputStream;
	
	// 获取输入流的方法
	public InputStream getResult() {
		return inputStream;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public String execute() throws Exception {
		person.setCreate_date(new Date());
		person.setIfManager("否");
		person.setNote("无");
		if (ms.saveReader(person)) {
			inputStream = new ByteArrayInputStream("添加成功！".getBytes("UTF-8"));
		} else {
			inputStream = new ByteArrayInputStream("添加失败，服务器错误，联系QQ1245052165".getBytes("UTF-8"));
		}
		return SUCCESS;
	}

}
