package action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import action.Base.ReaderBaseAction;
import domain.Book;
import tools.VOPOConvert;
import vo.BorrowBean;
import vo.PersonBean;

/**
 * 还书Action
 * @author lenovo
 * @version 创建时间：2019年4月10日上午9:12:24
 */
public class GiveBackAction extends ReaderBaseAction {


	private static final long serialVersionUID = 1L;

	//ajax所需的输入流
	private InputStream inputStream;
	//所借书的索引
	private String borrowIndex;
	//获取输入流的方法
	public InputStream getResult() {
		return inputStream;
	}
	//borrowIndex的getter和setter方法
	public String getBorrowIndex() {
		return borrowIndex;
	}

	public void setBorrowIndex(String borrowIndex) {
		this.borrowIndex = borrowIndex;
	}

	/**
	 * 搜索所有未还的的借阅记录
	 * 
	 * @return
	 */
	public String notGiveBackBorrows() throws Exception {
		ActionContext act = ActionContext.getContext();
		String user = (String) act.getSession().get("user");
		PersonBean person = ms.findPersonByUser(user);
		if (person == null) {
			inputStream = new ByteArrayInputStream("服务器错误！，联系QQ1245052165".getBytes("UTF-8"));
		} else {
			List<BorrowBean> borrowList = new ArrayList<>();
			borrowList = rs.borrowNotBackRecord(VOPOConvert.personVOToPO(person));
			act.getSession().put("borrowList", borrowList);
			if (borrowList.size() > 0) {
				inputStream = new ByteArrayInputStream("已检索到你所有未归还的借阅记录".getBytes("UTF-8"));
			} else {
				inputStream = new ByteArrayInputStream("你当前没有未归还的借阅记录".getBytes("UTF-8"));
			}
		}
		return SUCCESS;
	}

	/**
	 * 还书
	 * 
	 * @return
	 * @throws Exception
	 */
	public String giveBack() throws Exception {
		ActionContext act = ActionContext.getContext();
		String user = (String) act.getSession().get("user");
		PersonBean person = ms.findPersonByUser(user);
		if (person == null) {
			inputStream = new ByteArrayInputStream("长时间未操作，请重新登录！".getBytes("UTF-8"));
			return SUCCESS;
		}
		@SuppressWarnings("unchecked")
		List<BorrowBean> borrowList = (List<BorrowBean>) act.getSession().get("borrowList");
		Book book = borrowList.get(Integer.parseInt(borrowIndex)).getBook();
		if (rs.giveBack(book, VOPOConvert.personVOToPO(person))) {
			act.getSession().put("refresh", true);
			inputStream = new ByteArrayInputStream("还书成功！".getBytes("UTF-8"));
		} else {
			inputStream = new ByteArrayInputStream("还书失败！，联系QQ1245052165".getBytes("UTF-8"));
		}
		return SUCCESS;
	}

}
