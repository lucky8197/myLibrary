package vo;

import java.util.Date;

/**
 * bookVO
 * 
 * @author luoliang
 * @version 创建时间：2019年4月10日上午9:12:24
 */
public class BookBean {

	private Integer id;
	private String book_name;
	private String book_type;
	private String book_case;
	private String author;
	private String book_concern;
	private Float price;
	private Integer count;
	private Integer page;
	private Date inTime;
	private Integer borrownum;

	// 无参构造器
	public BookBean() {

	}

	// 初始化全部成员变量的构造方法
	public BookBean(Integer id, String book_name, String book_type, String book_case, String author,
			String book_concern, Float price, Integer count, Integer page, Date inTime, Integer borrownum) {
		super();
		this.id = id;
		this.book_name = book_name;
		this.book_type = book_type;
		this.book_case = book_case;
		this.author = author;
		this.book_concern = book_concern;
		this.price = price;
		this.count = count;
		this.page = page;
		this.inTime = inTime;
		this.borrownum = borrownum;
	}

	// id的setter和getter方法
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	// book_name的setter和getter方法
	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	// book_type的setter和getter方法
	public String getBook_type() {
		return book_type;
	}

	public void setBook_type(String book_type) {
		this.book_type = book_type;
	}

	// book_case的setter和getter方法
	public String getBook_case() {
		return book_case;
	}

	public void setBook_case(String book_case) {
		this.book_case = book_case;
	}

	// author的setter和getter方法
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	// book_concern的setter和getter方法
	public String getBook_concern() {
		return book_concern;
	}

	public void setBook_concern(String book_concern) {
		this.book_concern = book_concern;
	}

	// price的setter和getter方法
	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	// count的setter和getter方法
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	// page的setter和getter方法
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	// inTime的setter和getter方法
	public Date getInTime() {
		return inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	// borrownum的setter和getter方法
	public Integer getBorrownum() {
		return borrownum;
	}

	public void setBorrownum(Integer borrownum) {
		this.borrownum = borrownum;
	}

}
