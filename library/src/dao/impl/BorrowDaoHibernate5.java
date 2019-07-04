package dao.impl;

import java.util.ArrayList;
import java.util.List;

import commom.dao.impl.BaseDaoHibernate5;
import dao.BorrowDao;
import domain.Book;
import domain.Borrow;
import domain.Person;

/**
 * 定义一些与借阅相关的dao方法
 * @author lenovo
 * @version 创建时间：2019年4月10日上午9:12:24
 *
 */
public class BorrowDaoHibernate5 extends BaseDaoHibernate5<Borrow> implements BorrowDao {

	/**
	 * 查询某人的所有借阅记录
	 */
	@Override
	public List<Borrow> findByPerson(Person person) {
		List<Borrow> result_borrow = new ArrayList<>();
		result_borrow = find("select b from Borrow as b where b.person=?0", person);
		if (result_borrow.size() > 0) {
			return result_borrow;
		}
		return null;
	}

	/**
	 * 查询某人的所有的借阅记录(分页)
	 */
	@Override
	public List<Borrow> findByPersonPaging(Person person, int pageNo, int pageSize) {
		List<Borrow> result_borrow = new ArrayList<>();
		result_borrow = findByPage("select b from Borrow as b where b.person=?0", pageNo, pageSize, person);
		if (result_borrow.size() > 0) {
			return result_borrow;
		}
		return null;
	}

	/**
	 * 查询某书的所有的借阅记录
	 */
	@Override
	public List<Borrow> findByBook(Book book) {
		return find("select b from Borrow as b where b.book=?0", book);
	}

	/**
	 * 通过书和人来查询未归还的借阅记录
	 */
	@Override
	public List<Borrow> findByBookAndPerson(Book book, Person person) {
		return find("select b from Borrow as b where b.book=?0 and b.person=?1 and BackTime = null", book, person);
	}

	/**
	 * 查询某人的未归还的借阅记录
	 */
	@Override
	public List<Borrow> findNotBackByPerson(Person person) {
		return find("select b from Borrow as b where b.person = ?0 and BackTime = null", person);
	}

}
