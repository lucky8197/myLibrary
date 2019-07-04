package dao;

import java.util.List;

import commom.dao.BaseDao;
import domain.Book;
import domain.Borrow;
import domain.Person;

/**
 * 定义一些与借阅相关的dao方法
 * 
 * @author lenovo
 * @version 创建时间：2019年4月10日上午9:12:24
 */
public interface BorrowDao extends BaseDao<Borrow> {
	/**
	 * 查询某人的所有借阅记录
	 * 
	 * @param person
	 * @return
	 */
	public List<Borrow> findByPerson(Person person);

	/**
	 * 查询某人的所有借阅记录(分页)
	 * 
	 * @param person
	 * @return
	 */
	public List<Borrow> findByPersonPaging(Person person, int pageNo, int pageSize);

	/**
	 * 查询某书的借阅记录
	 * 
	 * @param book
	 * @return
	 */
	public List<Borrow> findByBook(Book book);

	/**
	 * 通过书和人来查询借阅记录
	 * 
	 * @param book
	 * @param person
	 * @return
	 */
	public List<Borrow> findByBookAndPerson(Book book, Person person);

	/**
	 * 查询某人的未归还借阅记录
	 * 
	 * @param person
	 * @return
	 */
	public List<Borrow> findNotBackByPerson(Person person);
}
