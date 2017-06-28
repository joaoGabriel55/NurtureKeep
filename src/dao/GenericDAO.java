package dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {

	void save(T object);

	void delete(T object);

	T findById(ID id);

	List<T> listAll();
}
