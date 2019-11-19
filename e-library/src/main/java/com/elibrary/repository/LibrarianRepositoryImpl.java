package com.elibrary.repository;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.elibrary.model.Librarian;

@Repository
public class LibrarianRepositoryImpl implements ILibrarianRepository {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Integer addLibrarian(Librarian librarian) {
		Integer id = (Integer) entityManager.unwrap(Session.class).save(librarian);
		return id;

	}

	@Override
	public List<Librarian> viewLibrarians(Map<String, String> inputMap) {
		Session session = entityManager.unwrap(Session.class);
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Librarian> cq = cb.createQuery(Librarian.class);
		Root<Librarian> root = cq.from(Librarian.class);
		cq.select(root);
		Query<Librarian> query = session.createQuery(cq);
		List<Librarian> librarianList = query.getResultList();
		return librarianList;
	}

}
