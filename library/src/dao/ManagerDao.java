package dao;

import java.util.List;

import commom.dao.BaseDao;
import domain.Person;

/**
 * 定义一些与管理员相关的dao方法
 * 
 * @author lenovo
 * @version 创建时间：2019年4月10日上午9:12:24
 *
 */
public interface ManagerDao extends BaseDao<Person> {
	/**
	 * 根据用户名查询读者
	 * @param name
	 * @return
	 */
	public Person findReaderByUser(String name);
	/**
	 * 根据用户名和密码查询读者
	 * @param Person
	 * @return
	 */
	public List<Person> findReaderByUserAndPassword(Person person);
	/**
	 * 根据电话号码查询读者
	 * @param tel
	 * @return
	 */
	public List<Person> findReaderByTel(String tel);
	/**
	 * 根据姓名查询读者
	 * @param name
	 * @return
	 */
	public List<Person> findReaderByName(String name);
	/**
	 * 通过用户名和密码查找管理员
	 * 
	 * @param manager
	 * @return
	 */
	public List<Person> findManagerByUserAndPassword(Person person);
}
