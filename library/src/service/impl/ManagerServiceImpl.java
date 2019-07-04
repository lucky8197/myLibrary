package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.BookDao;
import dao.ManagerDao;
import dao.ReaderDao;
import domain.Book;
import domain.Person;
import service.ManagerService;
import tools.CheckSensititiveWords;
import tools.VOPOConvert;
import vo.BookBean;
import vo.PersonBean;

/**
 * 实现管理员的业务逻辑方法
 * 
 * @author lenovo
 * @version 创建时间：2019年4月10日上午9:12:24
 *
 */
public class ManagerServiceImpl implements ManagerService {

	private BookDao bookDao;
	private ReaderDao readerDao;
	private ManagerDao managerDao;

	// managerDao的setter方法
	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}

	// bookDao的setter方法
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	// readerDao的setter方法
	public void setReaderDao(ReaderDao readerDao) {
		this.readerDao = readerDao;
	}

	/**
	 * 通过姓名检索人
	 */
	@Override
	public List<PersonBean> findPersonByName(String name) {
		List<Person> persons = new ArrayList<>();
		persons = managerDao.findReaderByName(name);
		if(persons == null){
			return null;
		}
		List<PersonBean> result = new ArrayList<>();
		for (Person person : persons) {
			result.add(VOPOConvert.personPOToVO(person));
		}
		return result;

	}

	/**
	 * 通过用户名检索人
	 */
	@Override
	public PersonBean findPersonByUser(String user) {
		Person person = managerDao.findReaderByUser(user);
		return VOPOConvert.personPOToVO(person);
	}

	/**
	 * 通过电话号码检索人
	 */
	@Override
	public List<PersonBean> findPersonByTel(String tel) {
		List<Person> persons = new ArrayList<>();
		persons = managerDao.findReaderByTel(tel);
		if(persons == null){
			return null;
		}
		List<PersonBean> result = new ArrayList<>();
		for (Person person : persons) {
			result.add(VOPOConvert.personPOToVO(person));
		}
		return result;
	}

	/**
	 * 保存读者
	 */
	@Override
	public boolean saveReader(Person reader) {
		if (readerDao.save(reader) != null) {
			return true;
		}
		return false;
	}

	/**
	 * 删除读者
	 */
	@Override
	public void deleteReader(Person reader) {
		readerDao.delete(reader);
	}

	/**
	 * 更新读者
	 */
	@Override
	public void updateReader(Person reader) {
		readerDao.update(reader);
	}

	/**
	 * 保存书籍
	 */
	@Override
	public boolean saveBook(Book book) {
		if (bookDao.save(book) != null) {
			return true;
		}
		return false;
	}

	/**
	 * 删除书籍
	 */
	@Override
	public void deleteBook(Book book) {
		bookDao.delete(book);
	}

	/**
	 * 更新书籍
	 */
	@Override
	public void updateBook(Book book) {
		bookDao.update(book);
	}

	/**
	 * 验证公告
	 */
	@Override
	public char validNotice(String notice) {
		for (int i = 0; i < notice.length(); i++) {
			char result = CheckSensititiveWords.checkWords(notice.charAt(i));
			if (result != 'Y') {
				return result;
			}
		}
		return 'Y';
	}

	/**
	 * 图书排行
	 */
	@Override
	public List<BookBean> bookTopByBorrow() {
		List<Book> books = bookDao.findBookSortByBorrow();
		List<BookBean> result = new ArrayList<>();
		for (Book book : books) {
			result.add(VOPOConvert.bookPOToVO(book));
		}
		return result;

	}
}
