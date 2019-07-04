package service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import domain.Book;
import domain.Person;
import vo.BookBean;
import vo.BorrowBean;

/**
 * 定义读者相关的业务逻辑方法
 * @author lenovo
 * @version 创建时间：2019年4月10日上午9:12:24
 */
public interface ReaderService {

	// 登录失败
	public static final int LOGIN_FAIL = 0;
	// 以读者登录
	public static final int LOGIN_RAD = 1;
	// 以管理员登录
	public static final int LOGIN_MGR = 2;

	/**
	 * 验证身份
	 * 
	 * @param person
	 * @return
	 */
	int validLogin(Person person);

	/**
	 * 通过id检索图书
	 * 
	 * @param id
	 * @return
	 */
	BookBean findBookById(int id);
	
	/**
	 * 通过书名检索图书
	 * 
	 * @param name
	 * @return
	 */
	List<BookBean> findBookByName(String name);

	/**
	 * 通过作者检索图书
	 * 
	 * @param author
	 * @return
	 */
	List<BookBean> findBookByAuthor(String author);

	/**
	 * 通过书架检索图书
	 * 
	 * @param Case
	 * @return
	 */
	List<BookBean> findBookByBookCase(String Case);

	/**
	 * 通过类型检索图书
	 * 
	 * @param type
	 * @return
	 */
	List<BookBean> findBookByType(String type);

	/**
	 * 借书
	 * 
	 * @param reader
	 * @return
	 */
	Date borrow(Book book, Person reader);

	/**
	 * 还书
	 * 
	 * @param book
	 * @param reader
	 * @return
	 */
	boolean giveBack(Book book, Person reader);

	/**
	 * 某人的借阅记录
	 * 
	 * @param person
	 * @return
	 */
	List<BorrowBean> borrowRecord(Person person);

	/**
	 * 某人的借阅记录(分页)
	 * 
	 * @param person
	 * @return
	 */
	Map<Integer, List<BorrowBean>> borrowRecordPaging(Person person);

	/**
	 * 查看某人已借阅的某书的记录（还未归还）
	 * 
	 * @param person
	 * @param book
	 * @return
	 */
	boolean findBorrowByPersonAndBook(Person person, Book book);

	/**
	 * 某人的未归还借阅记录
	 * 
	 * @param person
	 * @return
	 */
	List<BorrowBean> borrowNotBackRecord(Person person);
}
