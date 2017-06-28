package daoImplementation;

import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.GenericDAO;
import util.HibernateUtil;

public class GenericDAOimp<T, ID extends Serializable> implements GenericDAO<T, ID> {

	private Class<T> klass;

	public GenericDAOimp() {
	}

	public GenericDAOimp(Class<T> klass) {

		this.klass = klass;
	}

	public T findById(ID id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		T object = (T) session.get(klass, id);
		session.close();
		return object;
	}

	public void save(T object) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.saveOrUpdate((T) object);
		t.commit();
		session.close();
	}

	public void update(T object) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update((T) object);
		t.commit();
	}

	public void delete(T object) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete((T) object);
		t.commit();
		session.close();
	}

	public List<T> listAll() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(klass);

		Root<T> klassRoot = query.from(klass);

		query.select(klassRoot).where(builder.isNull(klassRoot.get("dataRemocao")));

		List<T> result = session.createQuery(query).getResultList();

		session.close();
		return result;

	}
}