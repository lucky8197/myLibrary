package action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import action.Base.ReaderBaseAction;
import tools.VOPOConvert;
import vo.BorrowBean;
import vo.PersonBean;

/**
 * 读者借阅记录的Action类
 * 
 * @author lenovo
 * @version 创建时间：2019年4月10日上午9:12:24
 */
public class BorrowRecordAction extends ReaderBaseAction {

	private static final long serialVersionUID = 1L;
	// ajax使用的输入流
	private InputStream inputStream;
	// 换页标识
	private String flag;
	// 目前页数
	private String nowPage;

	// nowpage的getter和setter方法
	public String getNowPage() {
		return nowPage;
	}

	public void setNowPage(String nowPage) {
		this.nowPage = nowPage;
	}

	// flag的getter和setter方法
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	// 获取输入流的方法
	public InputStream getResult() {
		return inputStream;
	}

	/**
	 * 查找所有的借阅记录
	 * 
	 * @return
	 * @throws Exception
	 */

	public String findBorrowRecord() throws Exception {
		ActionContext act = ActionContext.getContext();
		boolean refresh = false;
		String user = (String) act.getSession().get("user");
		PersonBean person = ms.findPersonByUser(user);
		if (person == null) {
			inputStream = new ByteArrayInputStream("长时间未操作，请重新登录！".getBytes("UTF-8"));
		} else {
			Map<Integer, List<BorrowBean>> allBorrowList = new HashMap<Integer, List<BorrowBean>>();
			allBorrowList = rs.borrowRecordPaging(VOPOConvert.personVOToPO(person));
			if (rs.borrowRecord(VOPOConvert.personVOToPO(person)).size() == 0) {
				inputStream = new ByteArrayInputStream("你当前没有借阅记录".getBytes("UTF-8"));
				act.getSession().put("refresh", refresh);
				return SUCCESS;
			}
			// 有数据
			act.getSession().put("allBorrowList", allBorrowList);
			inputStream = new ByteArrayInputStream("已检索到你所有的借阅记录".getBytes("UTF-8"));
			refresh = true;
			act.getSession().put("refresh", refresh);
		}
		return SUCCESS;
	}

	
	/**
	 * 换页
	 * 
	 * @return
	 * @throws Exception
	 */
	public String ChangePage() throws Exception {
		ActionContext act = ActionContext.getContext();
		int nowPage = Integer.parseInt(getNowPage());
		if (act.getSession().get("allBorrowList") == null) {
			inputStream = new ByteArrayInputStream("无数据，不换页".getBytes("UTF-8"));
			return SUCCESS;
		}
		@SuppressWarnings("unchecked")
		int page = ((Map<Integer, List<BorrowBean>>) act.getSession().get("allBorrowList")).size();
		switch (flag) {
		case "上一页":
			if (nowPage > 1) {
				nowPage--;
			}
			act.getSession().put("nowPage", nowPage);
			inputStream = new ByteArrayInputStream("上一页".getBytes("UTF-8"));
			break;
		case "下一页":
			if (nowPage < page) {
				nowPage++;
			}
			act.getSession().put("nowPage", nowPage);
			inputStream = new ByteArrayInputStream("下一页".getBytes("UTF-8"));
			break;
		case "首页":
			nowPage = 1;
			act.getSession().put("nowPage", nowPage);
			inputStream = new ByteArrayInputStream("首页".getBytes("UTF-8"));
			break;
		case "末页":
			nowPage = page;
			act.getSession().put("nowPage", nowPage);
			inputStream = new ByteArrayInputStream("末页".getBytes("UTF-8"));
		}
		return SUCCESS;
	}

}
