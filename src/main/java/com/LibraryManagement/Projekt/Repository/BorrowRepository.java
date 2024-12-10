package com.LibraryManagement.Projekt.Repository;

import com.LibraryManagement.Projekt.Model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepository extends JpaRepository<Borrow, Long> {
}


