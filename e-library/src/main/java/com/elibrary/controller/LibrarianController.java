package com.elibrary.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elibrary.model.Librarian;
import com.elibrary.service.ILibrarianService;

@RestController
@RequestMapping("/librarian")
public class LibrarianController {

	@Autowired
	ILibrarianService librarianService;
	private static final Logger LOGGER=LoggerFactory.getLogger(LibrarianController.class);
	
	@PostMapping(value="addLibrarian", produces="application/json")
	public ResponseEntity<?> addLibrarian(@RequestBody(required=true) Librarian librarian) {
		ResponseEntity<?> responseEntity = null;
		try {
			Integer id = librarianService.addLibrarian(librarian);
			if(id > 0) {
				responseEntity = new ResponseEntity<>(id, HttpStatus.OK);
			} else {
				responseEntity = new ResponseEntity<>("Librarian failed to save", HttpStatus.BAD_REQUEST);
			}
		} catch(Exception ex) {
			responseEntity = new ResponseEntity<>("Error occured while saving librarian.."+ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	@GetMapping(value="viewLibrarians", produces="application/json")
	public ResponseEntity<?> viewLibrarians(@RequestParam(name="sortType", required=false) String sortType) {
		ResponseEntity<?> responseEntity = null;
		try {
			List<Librarian> librarianList = librarianService.viewLibrarians(null);
			if(librarianList.isEmpty()) {
				responseEntity = new ResponseEntity<>("Librarian info is empty", HttpStatus.BAD_REQUEST);
			} else {
				responseEntity = new ResponseEntity<>(librarianList, HttpStatus.OK);
			}
		} catch(Exception ex) {
			responseEntity = new ResponseEntity<>("Error occured while retrieving librarian info.."+ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	@GetMapping(value="test", produces="application/json")
	public String test() {
		return "test";
	}
}
