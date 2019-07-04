package action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import action.Base.ManagerBaseAction;
import vo.PersonBean;

/**
*@author luoliang		
*@version 创建时间：2019年4月12日下午4:54:45
*/
public class SearchReaderAction extends ManagerBaseAction {
	private static final long serialVersionUID = 1L;
	private InputStream inputStream;
	// 检索框中输入的读者信息
	private String readerInfo;
	// 检索读者的方式
	private String way;
	
	public InputStream getResult() {
		return inputStream;
	}
	public String getReaderInfo() {
		return readerInfo;
	}
	public void setReaderInfo(String readerInfo) {
		this.readerInfo = readerInfo;
	}
	public String getWay() {
		return way;
	}
	public void setWay(String way) {
		this.way = way;
	}
	
	/**
	 * 查询读者
	 */
	public String execute() throws Exception {
		List<PersonBean> person = new ArrayList<>();
		switch (way) {
		case "user":
			PersonBean tempPerson = new PersonBean();
			tempPerson = ms.findPersonByUser(readerInfo);
			if(tempPerson == null) {
				inputStream = new ByteArrayInputStream("未检索到相关读者！".getBytes("UTF-8"));
				break;
			} else {
				person.add(tempPerson);
				ActionContext act = ActionContext.getContext();
				act.getSession().put("personManagement", person);
				inputStream = new ByteArrayInputStream("已检索到相关读者！".getBytes("UTF-8"));
			}
			break;
		case "name":
			person = ms.findPersonByName(readerInfo);
			if (person == null || person.size() == 0) {
				inputStream = new ByteArrayInputStream("未检索到相关读者！".getBytes("UTF-8"));
			} else {
				ActionContext act = ActionContext.getContext();
				act.getSession().put("personManagement", person);
				inputStream = new ByteArrayInputStream("已检索到相关读者！".getBytes("UTF-8"));
			}
			break;
		case "tel":
			person = ms.findPersonByTel(readerInfo);
			if (person == null || person.size() == 0) {
				inputStream = new ByteArrayInputStream("未检索到相关读者！".getBytes("UTF-8"));
			} else {
				ActionContext act = ActionContext.getContext();
				act.getSession().put("personManagement", person);
				inputStream = new ByteArrayInputStream("已检索到相关读者！".getBytes("UTF-8"));
			}
			break;
		default:
			inputStream = new ByteArrayInputStream("检索方式发生服务器错误，联系QQ1245052165".getBytes("UTF-8"));
		}
		return SUCCESS;
	}
	

}
