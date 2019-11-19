package com.elibrary.service;

import java.util.List;
import java.util.Map;

import com.elibrary.model.Librarian;

public interface ILibrarianService {

	public Integer addLibrarian(Librarian librarian);
	
	public List<Librarian> viewLibrarians(Map<String, String> inputMap);
	
//	public void addLibrarian1(Librarian librarian);
}
