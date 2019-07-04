package dao.impl;

import java.util.ArrayList;
import java.util.List;

import commom.dao.impl.BaseDaoHibernate5;
import dao.ManagerDao;
import domain.Person;

/**
 * 实现一些与管理员相关的dao方法
 * 
 * @author lenovo
 * @version 创建时间：2019年4月10日上午9:12:24
 */
public class ManagerDaoHibernate5 extends BaseDaoHibernate5<Person> implements ManagerDao {

	
	/**
	 * 根据用户名和密码查询管理员
	 */
	@Override
	public List<Person> findManagerByUserAndPassword(Person person) {
		return find("select p from Person as p where p.user = ?0 and p.password = ?1 " + "and ifManager='是'",
				person.getUser(), person.getPassword());
	}

	/**
	 * 根据用户名查询读者
	 */
	@Override
	public Person findReaderByUser(String user) {
		List<Person> list = new ArrayList<>();
		list = find("select p from Person as p where p.user=?0", user);
		if (list != null && list.size() == 1) {
			Person reader = new Person();
			reader = list.get(0);
			return reader;
		}
		return null;
	}

	/**
	 * 根据电话号码查询读者
	 */
	@Override
	public List<Person> findReaderByTel(String tel) {
		List<Person> list = new ArrayList<>();
		list = find("select p from Person as p where p.tel=?0", tel);
		if (list != null && list.size() >= 1) {
			return list;
		}
		return null;
	}

	/**
	 * 根据姓名来查询读者
	 */
	@Override
	public List<Person> findReaderByName(String name) {
		List<Person> list = new ArrayList<>();
		list = find("select p from Person as p where p.name=?0", name);
		if (list != null && list.size() >= 1) {
			return list;
		}
		return null;
	}

	/**
	 * 依据用户名和密码查询读者
	 */
	@Override
	public List<Person> findReaderByUserAndPassword(Person person) {
		
		//如果没有后面的p.ifManager = '否' 那么此处存在SQL注入点
		return find("select p from Person as p where p.user = ?0 and p.password = ?1 " + "and p.ifManager='否' ",
				person.getUser(), person.getPassword());
	}
}
