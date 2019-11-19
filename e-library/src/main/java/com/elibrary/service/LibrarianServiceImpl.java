package com.elibrary.service;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elibrary.model.Librarian;
import com.elibrary.repository.ILibrarianRepository;

@Service
public class LibrarianServiceImpl implements ILibrarianService {

	@Autowired
	private ILibrarianRepository librarianRepository;
	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	@Override
	public Integer addLibrarian(Librarian librarian) {
		return librarianRepository.addLibrarian(librarian);
	}

	@Override
	public List<Librarian> viewLibrarians(Map<String, String> inputMap) {
		return librarianRepository.viewLibrarians(inputMap);
	}

//	public void addLibrarian1(Librarian librarian) {
//		Librarian librarian1 = new Librarian();
//		librarian1.setEmail(librarian.getEmail());
//		librarian1.setMobile(librarian.getMobile());
//		librarian1.setName(librarian.getName());
//		librarian1.setPassword(librarian.getPassword());
//		if(librarian1.getName().equals("Avinash3")) {
//			throw new RuntimeException("Test transaction");
//		}
//		librarian.setName(librarian.getName()+"test");
	// TODO Auto-generated method stub
//		librarianRepository.addLibrarian(librarian);
//	}

}
