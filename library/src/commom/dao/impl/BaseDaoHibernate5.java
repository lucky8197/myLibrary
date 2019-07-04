package commom.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import commom.dao.BaseDao;

/**
 * 基础dao的hibernate5实现
 * 
 * @author lenovo
 * @verson 创建时间：2019年4月10日上午9:12:24
 * @param <T>
 */

@SuppressWarnings("all")
public class BaseDaoHibernate5<T> implements BaseDao<T> {
	// 依赖sessionFactory组件
	private SessionFactory sessionFactory;

	// 依赖注入所需的方法
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 根据id删除实体
	 */
	@Override
	public T get(Class<T> entityClazz, Serializable id) {
		return (T) getSessionFactory().getCurrentSession().get(entityClazz, id);
	}

	/**
	 * 保存实体
	 */
	@Override
	public Serializable save(T entity) {
		return getSessionFactory().getCurrentSession().save(entity);
	}

	/**
	 * 更新实体
	 */
	@Override
	public void update(T entity) {
		getSessionFactory().getCurrentSession().saveOrUpdate(entity);
	}

	/**
	 * 删除实体
	 */
	@Override
	public void delete(T entity) {
		getSessionFactory().getCurrentSession().delete(entity);
	}

	/**
	 * 根据id删除实体
	 */
	@Override
	public void delete(Class<T> entityClazz, Serializable id) {
		getSessionFactory().getCurrentSession()
				.createQuery("delete" + "entityClazz.getSimpleName()" + "en where en.id=?0").setParameter("0", id)
				.executeUpdate();
	}

	/**
	 * 获取所有实体
	 */
	@Override
	public List<T> findAll(Class<T> entityClazz) {
		return find("select en from" + entityClazz.getSimpleName() + " en");
	}

	/**
	 * 获取实体总数
	 */
	@Override
	public long findCount(Class<T> entityClazz) {
		List<T> l = find("select count(*) from" + entityClazz.getSimpleName());
		if (l != null && l.size() == 1) {
			return (Long) l.get(0);
		}
		return 0;
	}

	/**
	 * 根据HQL语句查询实体
	 * 
	 * @param hql
	 * @return
	 */
	protected List<T> find(String hql) {
		return (List<T>) getSessionFactory().getCurrentSession().createQuery(hql).getResultList();
	}

	/**
	 * 根据带有占位符的HQL语句查询实体
	 * 
	 * @param hql
	 * @param params
	 * @return
	 */
	protected List<T> find(String hql, Object... params) {
		// 创建查询
		Query<T> query = getSessionFactory().getCurrentSession().createQuery(hql);
		// 为包含占位符的HQL语句设置参数
		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i + "", params[i]);
		}
		return (List<T>) query.getResultList();
	}

	/**
	 * 分页操作
	 * 
	 * @param hql
	 * @param pageNo   查询第 pageNo 页的记录
	 * @param pageSize 每页显示的记录数
	 * @return 当前页的所有记录
	 */
	protected List<T> findByPage(String hql, int pageNo, int pageSize) {
		return getSessionFactory().getCurrentSession().createQuery(hql).setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize).getResultList();
	}

	/**
	 * 分页操作
	 * 
	 * @param hql
	 * @param pageNo
	 * @param pageSize
	 * @param params
	 * @return 当前页的所有记录
	 */
	protected List<T> findByPage(String hql, int pageNo, int pageSize, Object... params) {
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i + "", params[i]);
		}
		return query.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).getResultList();
	}

}
