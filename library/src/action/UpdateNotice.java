package action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.opensymphony.xwork2.ActionContext;

import action.Base.ManagerBaseAction;

/**
 * 更新公告
 * 
 * @author luoliang
 * @version 创建时间：2019年4月12日下午2:22:39
 */
public class UpdateNotice extends ManagerBaseAction {

	private static final long serialVersionUID = 1L;
	private String newNotice;

	private InputStream inputStream;

	// 获取输入流的方法
	public InputStream getResult() {
		return inputStream;
	}

	public String getNewNotice() {
		return newNotice;
	}

	public void setNewNotice(String newNotice) {
		this.newNotice = newNotice;
	}

	/**
	 * 更新公告
	 */
	public String execute() throws Exception {
		ActionContext act = ActionContext.getContext();
		if (newNotice != null && newNotice != "") {
			char result = ms.validNotice(newNotice);
			if(result != 'Y') {
				inputStream = new ByteArrayInputStream(("输入内容涉及敏感词汇：" + result).getBytes("UTF-8"));
				return SUCCESS;
			}
			act.getApplication().put("notice", newNotice);
			inputStream = new ByteArrayInputStream("修改成功".getBytes("UTF-8"));
			return SUCCESS;
		} else {
			inputStream = new ByteArrayInputStream("内容为空".getBytes("UTF-8"));
			return SUCCESS;
		}
	}
}
