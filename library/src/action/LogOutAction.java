package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import action.Base.ReaderBaseAction;

/**
 * 退出系统Action
 * @author lenovo
 * @version 创建时间：2019年4月10日上午9:12:24 
 *
 */
public class LogOutAction extends ReaderBaseAction implements ServletRequestAware {

	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request= request;
	}
	

	/**
	 * 提出系统方法
	 */
	public String execute() {
		HttpSession session = request.getSession();
		//使session失效
		session.invalidate();
		return SUCCESS;
	}
}
