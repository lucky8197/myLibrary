package action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;

import action.Base.ManagerBaseAction;
import domain.Book;

/**
 * 添加图书action
*@author luoliang		
*@version 创建时间：2019年4月12日下午2:30:12
*/
public class AddBookAction extends ManagerBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Book book;
	
	private InputStream inputStream;

	//book的geeter和setter方法
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	// 获取输入流的方法
	public InputStream getResult() {
		return inputStream;
	}
	
	/**
	 * 添加图书
	 */
	public String execute() throws Exception {
		book.setInTime(new Date());
		book.setBorrownum(0);
		if (ms.saveBook(book)) {
			inputStream = new ByteArrayInputStream("添加成功！".getBytes("UTF-8"));
		} else {
			inputStream = new ByteArrayInputStream("添加失败，服务器错误，联系QQ1245052165".getBytes("UTF-8"));
		}
		return SUCCESS;
	}

}
