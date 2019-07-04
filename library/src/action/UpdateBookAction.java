package action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import action.Base.ManagerBaseAction;
import tools.VOPOConvert;
import vo.BookBean;

/**
*@author luoliang		
*@version 创建时间：2019年4月12日下午2:57:27
*/
public class UpdateBookAction extends ManagerBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String newBook_name;
	private String newBook_type;
	private String newBook_case;
	private String newAuthor;
	private String newConcern;
	private Float newPrice;
	private Integer newCount;
	private Integer newPage;

	private InputStream inputStream;

	// 获取输入流的方法
	public InputStream getResult() {
		return inputStream;
	}

	// id的getter和setter方法
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	// newBook_name的getter和setter方法
	public String getNewBook_name() {
		return newBook_name;
	}

	public void setNewBook_name(String newBook_name) {
		this.newBook_name = newBook_name;
	}

	// newBook_type的getter和setter方法
	public String getNewBook_type() {
		return newBook_type;
	}

	public void setNewBook_type(String newBook_type) {
		this.newBook_type = newBook_type;
	}

	// newBook_case的getter和setter方法
	public String getNewBook_case() {
		return newBook_case;
	}

	public void setNewBook_case(String newBook_case) {
		this.newBook_case = newBook_case;
	}

	// newAuthor的getter和setter方法
	public String getNewAuthor() {
		return newAuthor;
	}

	public void setNewAuthor(String newAuthor) {
		this.newAuthor = newAuthor;
	}

	// newConcern的getter和setter方法
	public String getNewConcern() {
		return newConcern;
	}

	public void setNewConcern(String newConcern) {
		this.newConcern = newConcern;
	}

	// newPrice的getter和setter方法
	public Float getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(Float newPrice) {
		this.newPrice = newPrice;
	}

	// newCount的getter和setter方法
	public Integer getNewCount() {
		return newCount;
	}

	public void setNewCount(Integer newCount) {
		this.newCount = newCount;
	}

	// newPage的getter和setter方法
	public Integer getNewPage() {
		return newPage;
	}

	public void setNewPage(Integer newPage) {
		this.newPage = newPage;
	}
	
	/**
	 * 验证ID
	 * 
	 * @return
	 * @throws Exception
	 */
	public String checkId() throws Exception {
		if (rs.findBookById(id) != null) {
			inputStream = new ByteArrayInputStream("该图书存在".getBytes("UTF-8"));
		} else {
			inputStream = new ByteArrayInputStream("该图书不存在".getBytes("UTF-8"));
		}
		return SUCCESS;
	}

	/**
	 * 更新图书信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateBook() throws Exception {
		BookBean book = rs.findBookById(id);
		if (newBook_name != null && newBook_name != "") {
			book.setBook_name(newBook_name);
		}
		if (newBook_type != null && newBook_name != "") {
			book.setBook_type(newBook_type);
		}
		if (newBook_case != null && newBook_case != "") {
			book.setBook_case(newBook_case);
		}
		if (newAuthor != null && newAuthor != "") {
			book.setAuthor(newAuthor);
		}
		if (newConcern != null && newConcern != "") {
			book.setBook_concern(newConcern);
		}
		if (newPrice != null) {
			book.setPrice(newPrice);
		}
		if (newCount != null) {
			book.setCount(newCount);
		}
		if (newPage != null) {
			book.setPage(newPage);
		}
		ms.updateBook(VOPOConvert.bookVOToPO(book));
		inputStream = new ByteArrayInputStream("修改成功".getBytes("UTF-8"));
		return SUCCESS;
	}

}
