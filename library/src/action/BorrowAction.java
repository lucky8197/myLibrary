package action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import action.Base.ReaderBaseAction;
import tools.VOPOConvert;
import tools.WebConstant;
import vo.BookBean;
import vo.PersonBean;

/**
 * 读者借阅的Action类
 * 
 * @author lenovo
 * @version 创建时间：2019年4月10日上午9:12:24
 */
public class BorrowAction extends ReaderBaseAction {

	private static final long serialVersionUID = 1L;

	// 借书时所选的书籍索引
	private String bookIndex;
	// 检索框的输入内容
	private String bookInfo;
	// 检索书籍的方式
	private String way;
	// ajax使用的输入流
	private InputStream inputStream;

	private List<BookBean> bookResult;


	public List<BookBean> getBookResult() {
		return bookResult;
	}

	public void setBookResult(List<BookBean> bookResult) {
		this.bookResult = bookResult;
	}

	// bookIndex的getter和setter方法
	public String getBookIndex() {
		return bookIndex;
	}

	public void setBookIndex(String bookIndex) {
		this.bookIndex = bookIndex;
	}

	// bookInfo的getter和setter方法
	public String getBookInfo() {
		return bookInfo;
	}

	public void setBookInfo(String bookInfo) {
		this.bookInfo = bookInfo;
	}

	// way的getter和setter方法
	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}

	// 获取输入流的方法
	public InputStream getResult() {
		return inputStream;
	}

	/**
	 * 检索书籍
	 * 
	 * @return
	 */
	public String findBook() throws Exception {
		ActionContext act = ActionContext.getContext();
		List<BookBean> bookList = new ArrayList<>();
		// 管理员删除书籍时。也需要用到findBook。当删除后，需要更新上一次的的搜索结果。
		// 所以需要保存上一次的 way和bookInfo的值。
		if (bookInfo == "" || bookInfo == null) {
			bookInfo = (String) act.getSession().get("bookInfo");
		}
		if (way == "" || way == null) {
			way = (String) act.getSession().get("way");
		}
		switch (way) {
			case "bookName":
				bookList = rs.findBookByName(bookInfo);
				if (bookList != null && bookList.size() > 0) {
					setBookResult(bookList);	
					act.getSession().put("bookResult" , bookList);
					return SUCCESS;
				}
				addActionMessage("未检索到相关书籍！");
				break;
			case "author":
				bookList = rs.findBookByAuthor(bookInfo);
				if (bookList != null && bookList.size() > 0) {
					setBookResult(bookList);	
					act.getSession().put("bookResult" , bookList);
					return SUCCESS;
				}
				addActionMessage("未检索到相关书籍！");
				break;
			case "type":
				bookList = rs.findBookByType(bookInfo);
				if (bookList != null && bookList.size() > 0) {
					setBookResult(bookList);	
					act.getSession().put("bookResult" , bookList);
					return SUCCESS;
				}
				addActionMessage("未检索到相关书籍！");
				break;
			case "bookCase":
				if (bookList != null && bookList.size() > 0) {
					setBookResult(bookList);	
					act.getSession().put("bookResult" , bookList);
					return SUCCESS;
				}
				addActionMessage("未检索到相关书籍！");
		}
		return ERROR;
	}

	/**
	 * 借书
	 * 
	 * @return
	 * @throws Exception
	 */
	public String borrowBook() throws Exception {
		ActionContext act = ActionContext.getContext();
		String user = (String) act.getSession().get(WebConstant.USER);
		// 获取当前用户
		PersonBean person = ms.findPersonByUser(user);
		if (person == null) {
			inputStream = new ByteArrayInputStream("长时间未操作，请重新登录！".getBytes("UTF-8"));
			return SUCCESS;
		}
		@SuppressWarnings("unchecked")
		List<BookBean> bookList = (List<BookBean>) act.getSession().get("bookResult");
		BookBean book = bookList.get(Integer.parseInt(bookIndex));
		// 需要进行VOPO转换
		if (rs.findBorrowByPersonAndBook(VOPOConvert.personVOToPO(person), VOPOConvert.bookVOToPO(book))) {
			inputStream = new ByteArrayInputStream("该书你已借阅，还未归还！".getBytes("UTF-8"));
			return SUCCESS;
		}
		Date date = new Date();
		// 需要进行VOPO转换
		if ((date = rs.borrow(VOPOConvert.bookVOToPO(book), VOPOConvert.personVOToPO(person))) != null) {
			// 标识刷新
			act.getSession().put("refresh", true);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String giveTime = format.format(date);
			inputStream = new ByteArrayInputStream(("借阅成功！归还时间为" + giveTime).getBytes("UTF-8"));
		} else {
			inputStream = new ByteArrayInputStream("借阅失败，发生服务器错误，请联系QQ1245052165".getBytes("UTF-8"));
		}
		return SUCCESS;
	}

}
