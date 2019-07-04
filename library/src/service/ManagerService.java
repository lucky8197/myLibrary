package service;

import java.util.List;

import domain.Book;
import domain.Person;
import vo.BookBean;
import vo.PersonBean;

/**
 * 定义管理员的业务逻辑方法
 * 
 * @author lenovo
 * @version 创建时间：2019年4月10日上午9:12:24
 */
public interface ManagerService {
	
	/**
	 * 通过姓名检索人
	 * 
	 * @param name
	 * @return
	 */
	List<PersonBean> findPersonByName(String name);

	/**
	 * 通过用户名检索人
	 * 
	 * @param name
	 * @return
	 */
	PersonBean findPersonByUser(String user);

	/**
	 * 通过电话号码检索人
	 * 
	 * @param name
	 * @return
	 */
	List<PersonBean> findPersonByTel(String tel);

	/**
	 * 增加读者
	 * 
	 * @param name
	 * @return
	 */
	boolean saveReader(Person reader);

	/**
	 * 删除读者
	 * 
	 * @param reader
	 * @return
	 */
	void deleteReader(Person reader);

	/**
	 * 更新读者
	 * 
	 * @param reader
	 * @return
	 */
	void updateReader(Person reader);

	/**
	 * 增加图书
	 * 
	 * @param book
	 * @return
	 */
	boolean saveBook(Book book);

	/**
	 * 删除图书
	 * 
	 * @param book
	 * @return
	 */
	void deleteBook(Book book);

	/**
	 * 修改图书信息
	 * 
	 * @param book
	 * @return
	 */
	void updateBook(Book book);

	/**
	 * 验证公告信息
	 * 
	 * @return
	 */
	char validNotice(String notice);

	/**
	 * 图书排行
	 * 
	 * @return
	 */
	List<BookBean> bookTopByBorrow();

}
