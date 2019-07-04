package dao;

import java.util.List;

import commom.dao.BaseDao;
import domain.Book;

/**
 * 定义一些与图书相关的dao方法。
 * 
 * @author lenovo
 * @version 创建时间：2019年4月10日上午9:12:24
 */
public interface BookDao extends BaseDao<Book> {
	/**
	 * 根据书名查询图书（可能存在同名图书，但它们的信息不一样）
	 * 
	 * @param bookName
	 * @return
	 */
	public List<Book> findBookByName(String bookName);

	/**
	 * 根据书的类型查询图书
	 * 
	 * @param bookCase
	 * @return
	 */
	public List<Book> findBookByType(String bookType);

	/**
	 * 根据书架查询图书
	 * 
	 * @param bookCase
	 * @return
	 */
	public List<Book> findBookByBookCase(String bookCase);

	/**
	 * 根据作者查询图书
	 * 
	 * @param anthor
	 * @return
	 */
	public List<Book> findBookByAuthor(String anthor);

	/**
	 * 根据图书价格范围查询图书
	 * 
	 * @param lowest
	 * @param highest
	 * @return
	 */
	public List<Book> findBookByPriceRange(double lowest, double highest);

	/**
	 * 查询图书的借阅排行
	 * 
	 * @return
	 */
	public List<Book> findBookSortByBorrow();
}
