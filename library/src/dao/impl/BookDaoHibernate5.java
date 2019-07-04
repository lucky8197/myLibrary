package dao.impl;

import java.util.List;

import commom.dao.impl.BaseDaoHibernate5;
import dao.BookDao;
import domain.Book;

/**
 * 实现一些与图书相关的dao方法。
 * 
 * @author lenovo
 * @version 创建时间：2019年4月10日上午9:12:24
 */
public class BookDaoHibernate5 extends BaseDaoHibernate5<Book> implements BookDao {

	/**
	 * 根据图书名查询图书
	 * 
	 * @param bookName
	 * @return
	 */
	@Override
	public List<Book> findBookByName(String bookName) {
		return find("select b from Book as b where b.book_name=?0", bookName);
	}

	/**
	 * 根据图书类型查询图书
	 * 
	 * @param bookType
	 * @return
	 */
	@Override
	public List<Book> findBookByType(String bookType) {
		return find("select b from Book as b where b.book_type=?0", bookType);
	}

	/**
	 * 查询指定书架的所有图书
	 * 
	 * @param bookCase
	 * @return
	 */
	@Override
	public List<Book> findBookByBookCase(String bookCase) {
		return find("select b from Book as b where b.book_case=?0", bookCase);
	}

	/**
	 * 查询指定作者的所有图书
	 * 
	 * @param bookCase
	 * @return
	 */
	@Override
	public List<Book> findBookByAuthor(String author) {
		return find("select b from Book as b where b.author=?0", author);
	}

	/**
	 * 查询指定价格范围的图书
	 * 
	 * @param lowest, highest
	 * @return
	 */
	@Override
	public List<Book> findBookByPriceRange(double lowest, double highest) {
		return find("select b from Book as b where b.price between ?0 and ?1", lowest, highest);
	}

	/**
	 * 查询图书的借阅排行
	 */
	@Override
	public List<Book> findBookSortByBorrow() {
		return findByPage("select b from Book as b order by b.borrownum desc", 1, 10);
	}

}
