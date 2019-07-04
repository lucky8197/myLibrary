package commom.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 基础dao接口
 * 
 * @author lenovo
 * @verson 创建时间：2019年4月10日上午9:12:24
 * @param <T>
 */
public interface BaseDao<T> {
	/**
	 * 根据id加载实体
	 * 
	 * @param entityClazz
	 * @param id
	 * @return
	 */
	T get(Class<T> entityClazz, Serializable id);

	/**
	 * 保存实体
	 * 
	 * @param entity
	 * @return
	 */
	Serializable save(T entity);

	/**
	 * 更新实体
	 * 
	 * @param entity
	 */
	void update(T entity);

	/**
	 * 删除实体
	 * 
	 * @param entity
	 */
	void delete(T entity);

	/**
	 * 根据id删除实体
	 * 
	 * @param entityClazz
	 * @param id
	 */
	void delete(Class<T> entityClazz, Serializable id);

	/**
	 * 获取所有实体
	 * 
	 * @param entityClazz
	 * @return
	 */
	List<T> findAll(Class<T> entityClazz);

	/**
	 * 获取实体总数
	 * 
	 * @param entityClazz
	 * @return
	 */
	long findCount(Class<T> entityClazz);
}
