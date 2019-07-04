package service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.BookDao;
import dao.BorrowDao;
import dao.ManagerDao;
import domain.Book;
import domain.Borrow;
import domain.Person;
import service.ReaderService;
import tools.VOPOConvert;
import vo.BookBean;
import vo.BorrowBean;

/**
 * 实现读者相关的业务逻辑方法
 * 
 * @author lenovo
 * @version 创建时间：2019年4月10日上午9:12:24
 */
public class ReaderServiceImpl implements ReaderService {

	// 依赖的DAO组件
	private BookDao bookDao;
	private ManagerDao managerDao;
	private BorrowDao borrowDao;

	// managerDao的setter方法
	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}

	// bookDao的setter方法
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	// borrowDao的setter方法
	public void setBorrowDao(BorrowDao borrowDao) {
		this.borrowDao = borrowDao;
	}

	/**
	 * 验证登录
	 */
	@Override
	public int validLogin(Person person) {
		if (managerDao.findReaderByUserAndPassword(person).size() >= 1) {
			return LOGIN_RAD;
		} else if (managerDao.findManagerByUserAndPassword(person).size() >= 1) {
			return LOGIN_MGR;
		} else {
			return LOGIN_FAIL;
		}
	}

	/**
	 * 通过id检索书籍
	 */
	@Override
	public BookBean findBookById(int id) {
		Book book = bookDao.get(Book.class, id);
		if (book != null) {
			return VOPOConvert.bookPOToVO(book);
		}
		return null;
	}
	
	/**
	 * 通过书名检索图书
	 */
	@Override
	public List<BookBean> findBookByName(String name) {
		List<BookBean> result = new ArrayList<>();
		List<Book> books =  bookDao.findBookByName(name);
		for(Book book:books) {
			result.add(VOPOConvert.bookPOToVO(book));
		}
		return result;
	}

	/**
	 * 通过作者检索图书
	 */
	@Override
	public List<BookBean> findBookByAuthor(String author) {
		List<BookBean> result = new ArrayList<>();
		List<Book> books =  bookDao.findBookByAuthor(author);
		for(Book book:books) {
			result.add(VOPOConvert.bookPOToVO(book));
		}
		return result;
	}

	/**
	 * 通过书架检索图书
	 */
	@Override
	public List<BookBean> findBookByBookCase(String bookCase) {
		List<BookBean> result = new ArrayList<>();
		List<Book> books =  bookDao.findBookByBookCase(bookCase);
		for(Book book:books) {
			result.add(VOPOConvert.bookPOToVO(book));
		}
		return result;
	}

	/**
	 * 通过类型检索图书
	 */
	@Override
	public List<BookBean> findBookByType(String type) {
		List<BookBean> result = new ArrayList<>();
		List<Book> books =  bookDao.findBookByType(type);
		for(Book book:books) {
			result.add(VOPOConvert.bookPOToVO(book));
		}
		return result;
	}

	/**
	 * 借书
	 */
	@Override
	public Date borrow(Book book, Person person) {
		Borrow borrow = new Borrow();
		borrow.setBorrow_time((new Date()));
		borrow.setBack_time(new Date(new Date().getTime() + 1000 * 3600 * 24));
		borrow.setPerson(person);
		borrow.setBook(book);
		if (borrowDao.save(borrow) != null) {
			book.setBorrownum(book.getBorrownum() + 1);
			bookDao.update(book);
			return new Date(new Date().getTime() + 1000 * 3600 * 24);
		}
		return null;
	}

	/**
	 * 还书
	 */
	@Override
	public boolean giveBack(Book book, Person person) {
		Borrow borrow = null;
		List<Borrow> resultList = new ArrayList<>();
		resultList = borrowDao.findByBookAndPerson(book, person);
		for (int i = 0, len = resultList.size(); i < len; i++) {
			if (resultList.get(i).getBackTime() == null) {
				borrow = resultList.get(i);
			}
		}
		if (borrow == null) {
			return false;
		}
		borrow.setBackTime(new Date());
		borrowDao.save(borrow);
		return true;
	}

	/**
	 * 借阅记录
	 */
	@Override
	public List<BorrowBean> borrowRecord(Person person) {
		List<BorrowBean> result = new ArrayList<>();
		List<Borrow> borrows =  borrowDao.findByPerson(person);
		if(borrows == null) {
			return result;
		}
		for(Borrow borrow : borrows) {
			result.add(VOPOConvert.borrowPOToVO(borrow));
		}
		return result;
	}

	/**
	 * 查看某人已借阅的某书的记录（还未归还）
	 */
	@Override
	public boolean findBorrowByPersonAndBook(Person person, Book book) {
		List<Borrow> list = borrowDao.findByBookAndPerson(book, person);
		if (list == null || list.size() == 0) {
			return false;
		}
		return true;
	}

	/**
	 * 某人的未归还借阅记录
	 */
	@Override
	public List<BorrowBean> borrowNotBackRecord(Person person) {	
		List<BorrowBean> result = new ArrayList<>();
		List<Borrow> borrows =  borrowDao.findNotBackByPerson(person);
		for(Borrow borrow:borrows) {
			result.add(VOPOConvert.borrowPOToVO(borrow));
		}
		return result;

	}

	/**
	 * 某人的借阅记录(分页)
	 */
	@Override
	public Map<Integer, List<BorrowBean>> borrowRecordPaging(Person person) {
		int pageSize = 10;
		List<BorrowBean> allBorrow = borrowRecord(person);
		if (allBorrow == null) {
			return null;
		}
		int count = allBorrow.size();
		int page = 0;
		if (count <= pageSize) {
			page = 1;
		} else {
			page = count % pageSize == 0 ? (count / pageSize) : (count / pageSize + 1);
		}
		Map<Integer, List<BorrowBean>> map = new HashMap<Integer, List<BorrowBean>>();
		for (int i = 0; i < page; i++) {
			List<BorrowBean> result = new ArrayList<>();
			List<Borrow> borrows =  borrowDao.findByPersonPaging(person, i + 1, pageSize);
			if(borrows == null) {
				return map;
			}
			for(Borrow borrow:borrows) {
				result.add(VOPOConvert.borrowPOToVO(borrow));
			}
			map.put(i + 1, result);
		}
		return map;
	}
}
