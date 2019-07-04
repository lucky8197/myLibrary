package action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;

import com.opensymphony.xwork2.ActionContext;

import action.Base.ReaderBaseAction;
import tools.VOPOConvert;
import vo.PersonBean;

/**
 * 更新个人信息Action
 * 
 * @author lenovo
 * @version 创建时间：2019年4月10日上午9:12:24
 */
public class UpdateInforAction extends ReaderBaseAction {

	private static final long serialVersionUID = 1L;
	private InputStream inputStream;

	private String newPass;
	private Date newBirthday;
	private String newVocation;
	private String newEmail;
	private String newTel;

	// newPass的getter和setter方法
	public String getNewPass() {
		return newPass;
	}

	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}

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

	// 获取输入流的方法
	public InputStream getResult() {
		return inputStream;
	}

	@Override
	/**
	 * 页面跳转
	 */
	public String execute() throws Exception {
		return SUCCESS;
	}

	/**
	 * 获取旧信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getOldInfor() throws Exception {
		ActionContext act = ActionContext.getContext();
		String user = (String) act.getSession().get("user");
		PersonBean person = ms.findPersonByUser(user);
		if (person == null) {
			inputStream = new ByteArrayInputStream("长时间未操作，请重新登录！".getBytes("UTF-8"));
			return SUCCESS;
		}
		act.getSession().put("person", person);
		inputStream = new ByteArrayInputStream("显示旧信息！".getBytes("UTF-8"));
		return SUCCESS;

	}

	/**
	 * 更新信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updatePerson() throws Exception {
		boolean ifReLogin = false;
		ActionContext act = ActionContext.getContext();
		String user = (String) act.getSession().get("user");
		PersonBean person = ms.findPersonByUser(user);
		if (newPass != null && newPass != "") {
			person.setPassword(newPass);
			ifReLogin = true;
		}

		if (newBirthday != person.getBirthday()) {
			person.setBirthday(newBirthday);
		}
		person.setVocation(newVocation);
		person.setEmail(newEmail);
		person.setTel(newTel);
		ms.updateReader(VOPOConvert.personVOToPO(person));
		if (ifReLogin) {
			inputStream = new ByteArrayInputStream("修改成功，密码改变，请重新登录".getBytes("UTF-8"));
			return SUCCESS;
		}
		inputStream = new ByteArrayInputStream("修改成功".getBytes("UTF-8"));
		return SUCCESS;
	}

}
