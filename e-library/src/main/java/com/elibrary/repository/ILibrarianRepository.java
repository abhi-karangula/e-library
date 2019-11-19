package com.elibrary.repository;

import java.util.List;
import java.util.Map;

import com.elibrary.model.Librarian;

public interface ILibrarianRepository {

	public Integer addLibrarian(Librarian librarian);
	
	public List<Librarian> viewLibrarians(Map<String, String> inputMap);
}
