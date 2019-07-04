package action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import action.Base.ManagerBaseAction;
import tools.VOPOConvert;
import vo.BookBean;

/**
*@author luoliang		
*@version 创建时间：2019年4月12日下午2:42:41
*/
public class RemoveBookAction extends ManagerBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private String bookIndex;


	private InputStream inputStream;

	// 获取输入流的方法
	public InputStream getResult() {
		return inputStream;
	}

	// bookIndex的getter和setter方法
	public String getBookIndex() {
		return bookIndex;
	}

	public void setBookIndex(String bookIndex) {
		this.bookIndex = bookIndex;
	}
	
	/** 删除图书
	 * @throws Exception 
	 * 
	 */
	public String execute() throws Exception {
		ActionContext act = ActionContext.getContext();
		@SuppressWarnings("unchecked")
		List<BookBean> list = (List<BookBean>) act.getSession().get("bookResult");
		BookBean book = list.get(Integer.parseInt(bookIndex));
		if (book != null) {
			ms.deleteBook(VOPOConvert.bookVOToPO(book));
			inputStream = new ByteArrayInputStream("删除成功".getBytes("UTF-8"));
		} else {
			inputStream = new ByteArrayInputStream("删除失败，重新登录试试".getBytes("UTF-8"));
		}
		return SUCCESS;
	}

}
