package action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;

import action.Base.ManagerBaseAction;
import domain.Person;
import tools.VOPOConvert;
import vo.PersonBean;

/**
 * @author luoliang
 * @version 创建时间：2019年4月12日下午4:40:36
 */
public class UpdateReaderAction extends ManagerBaseAction {

	private static final long serialVersionUID = 1L;

	private InputStream inputStream;
	private Person person;
	private Date newBirthday;
	private String newVocation;
	private String newEmail;
	private String newTel;
	private String newNote;

	// newBirthday的getter和setter方法
	public Date getNewBirthday() {
		return newBirthday;
	}

	public void setNewBirthday(Date newBirthday) {
		this.newBirthday = newBirthday;
	}

	// newVocation的getter和setter方法
	public String getNewVocation() {
		return newVocation;
	}

	public void setNewVocation(String newVocation) {
		this.newVocation = newVocation;
	}

	// newEmail的getter和setter方法
	public String getNewEmail() {
		return newEmail;
	}

	public void setNewEmail(String newEmail) {
		this.newEmail = newEmail;
	}

	// newTel的getter和setter方法
	public String getNewTel() {
		return newTel;
	}

	public void setNewTel(String newTel) {
		this.newTel = newTel;
	}

	// newNote的getter和setter方法
	public String getNewNote() {
		return newNote;
	}

	public void setNewNote(String newNote) {
		this.newNote = newNote;
	}

	// 获取输入流的方法
	public InputStream getResult() {
		return inputStream;
	}

	// person的getter和setter方法
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * 更新读者信息
	 */
	public String execute() throws Exception {
		PersonBean person = ms.findPersonByUser(this.person.getUser());
		if (newBirthday != null) {
			person.setBirthday(newBirthday);
		}
		if (newVocation != null && newVocation != "") {
			person.setVocation(newVocation);
		}
		if (newEmail != null && newEmail != "") {
			person.setEmail(newEmail);
		}
		if (newTel != null && newTel != "") {
			person.setTel(newTel);
		}
		if (newNote != null && newNote != "") {
			person.setNote(newNote);
		}
		ms.updateReader(VOPOConvert.personVOToPO(person));
		inputStream = new ByteArrayInputStream("修改成功".getBytes("UTF-8"));
		return SUCCESS;
	}

}
