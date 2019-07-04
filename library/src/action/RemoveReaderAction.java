package action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import action.Base.ManagerBaseAction;
import tools.VOPOConvert;
import vo.PersonBean;

/**
 * @author luoliang
 * @version 创建时间：2019年4月12日下午4:57:43
 */
public class RemoveReaderAction extends ManagerBaseAction {
	private static final long serialVersionUID = 1L;

	private InputStream inputStream;
	// 删除读者时用到的索引
	private String removeIndex;

	// removeIndex的getter和setter方法
	public String getRemoveIndex() {
		return removeIndex;
	}

	public void setRemoveIndex(String removeIndex) {
		this.removeIndex = removeIndex;
	}

	// 获取输入流的方法
	public InputStream getResult() {
		return inputStream;
	}
	
	public String execute() throws Exception {
		ActionContext act = ActionContext.getContext();
		@SuppressWarnings("unchecked")
		List<PersonBean> list = (List<PersonBean>) act.getSession().get("personManagement");
		if (list == null) {
			inputStream = new ByteArrayInputStream("长时间未操作，请重新登录！".getBytes("UTF-8"));
		}
		PersonBean person = list.get(Integer.parseInt(removeIndex));
		ms.deleteReader(VOPOConvert.personVOToPO(person));
		inputStream = new ByteArrayInputStream("删除成功".getBytes("UTF-8"));
		act.getSession().put("personManagement", null);
		return SUCCESS;
	}
}
