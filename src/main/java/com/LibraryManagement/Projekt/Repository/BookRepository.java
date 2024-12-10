package com.LibraryManagement.Projekt.Repository;

import com.LibraryManagement.Projekt.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

