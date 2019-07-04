package domain;

import java.util.Date;

import javax.persistence.*;

/**
 * borrowPO
 * 
 * @author luoliang
 * @version 创建时间：2019年4月10日上午9:16:38
 */

@Entity
@Table(name = "tb_borrow")
public class Borrow {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date borrow_time;
	// 应还时间
	private Date back_time;
	// 还书时间
	private Date BackTime;
	@ManyToOne(targetEntity = Person.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id") // 外键列
	private Person person;
	@ManyToOne(targetEntity = Book.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "book_id")
	private Book book;

	// 无参构造器
	public Borrow() {

	}

	// 初始化全部成员变量的构造方法
	public Borrow(Integer id, Date borrow_time, Date back_time, Date backTime, Person person, Book book) {
		super();
		this.id = id;
		this.borrow_time = borrow_time;
		this.back_time = back_time;
		BackTime = backTime;
		this.person = person;
		this.book = book;
	}

	// id的getter和setter方法
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	// borrow_time的getter和setter方法
	public Date getBorrow_time() {
		return borrow_time;
	}

	public void setBorrow_time(Date borrow_time) {
		this.borrow_time = borrow_time;
	}

	// back_time的getter和setter方法
	public Date getBack_time() {
		return back_time;
	}

	public void setBack_time(Date back_time) {
		this.back_time = back_time;
	}

	// BackTime的getter和setter方法
	public Date getBackTime() {
		return BackTime;
	}

	public void setBackTime(Date backTime) {
		BackTime = backTime;
	}

	// person的getter和setter方法
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	// book的getter和setter方法
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
