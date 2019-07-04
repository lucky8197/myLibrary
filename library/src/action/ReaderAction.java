package action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import action.Base.ReaderBaseAction;
import vo.BookBean;

/**
 * 读者主页ACtion
 * 
 * @author lenovo
 * @version 创建时间：2019年4月10日上午9:12:24
 */
public class ReaderAction extends ReaderBaseAction {

	private static final long serialVersionUID = 1L;

	private InputStream inputStream;

	// 获取输入流方法
	public InputStream getResult() {
		return inputStream;
	}

	/**
	 * 显示图书借阅排行
	 * 
	 * @return
	 * @throws Exception
	 */
	public String showBookTop() throws Exception {
		ActionContext act = ActionContext.getContext();
		List<BookBean> list = new ArrayList<>();
		list = ms.bookTopByBorrow();
		if (list.size() > 0) {
			act.getSession().put("bookTop", list);
			inputStream = new ByteArrayInputStream("更新成功".getBytes("UTF-8"));
		}
		return SUCCESS;
	}

}
