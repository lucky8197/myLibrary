package action;

import static service.ReaderService.LOGIN_RAD;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import action.Base.ReaderBaseAction;
import domain.Person;
import vo.BookBean;
import vo.PersonBean;

/**
 * 登录Action
 * 
 * @author lenovo
 * @version 创建时间：2019年4月10日上午9:12:24
 */
public class LoginAction extends ReaderBaseAction {

	private static final String RED_RESULT = "red";
	private static final String MGR_RESULT = "mgr";
	private static final long serialVersionUID = 1L;
	private static final int LOGIN_FAIL = 0;

	private Person person;

	// persond的getter和setter方法
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}


	/**
	 * 用户登录
	 * 
	 * @return
	 * @throws Exception
	 */
	public String processLogin() throws Exception {
		ActionContext act = ActionContext.getContext();
		int result = rs.validLogin(getPerson());
		//验证失败
		if(result == LOGIN_FAIL) {
			addActionMessage("用户名或密码不正确，请重新输入");
			return ERROR;
		}
		PersonBean person = ms.findPersonByUser(this.person.getUser());
		// 图书借阅排行
		List<BookBean> bookTop = new ArrayList<>();
		bookTop = ms.bookTopByBorrow();
		
		if (result == LOGIN_RAD) {
			act.getSession().put("person", person);
			act.getSession().put("user", person.getUser());
			if (bookTop.size() > 0) {
				act.getSession().put("bookTop", bookTop);
			}
			return RED_RESULT;
		} else{
			//为管理员
			act.getSession().put("user", person.getUser());
			String notice = "1. 借阅排行榜每10分钟更新一次。  <br/> <br/>  " + "2.如果您在使用过程中遇到问题，请联系QQ1245052165。  <br/>  <br/> "
					+ "3.推荐书籍：算法导论、编译原理、Java编程思想。 <br/> <br/> " + "4.书籍类型有JAVA、科学、计算机 <br/> <br/> "
					+ "5.书架有 A 、B 、C 、D <br/> <br/>";
			act.getApplication().put("notice", notice);
			if (bookTop.size() > 0) {
				act.getSession().put("bookTop", bookTop);
			}
			return MGR_RESULT;
		}
		
	}
	
	/**
	 * 用户名和密码的验证方法
	 */
	public void validateProcessLogin() {
		String user = person.getUser();
		String password = person.getPassword();
		if(user == "" || user == null) {
			addFieldError("user" , "用户名必填");
		}
		if(password == "" || password == null) {
			addFieldError("password" , "密码必填");
		}
	}
	
}
