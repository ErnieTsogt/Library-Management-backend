package com.LibraryManagement.Projekt.Controller;
import com.LibraryManagement.Projekt.Model.Borrow;
import com.LibraryManagement.Projekt.Service.BorrowService;
import com.LibraryManagement.Projekt.dto.BorrowRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/borrow")
@CrossOrigin(origins = "http://localhost:3000") // Zmień URL na frontend
public class BorrowController {
    @Autowired
    private BorrowService borrowService;

    @GetMapping
    public List<Borrow> getAllBorrowRecords() {
        return borrowService.getAllBorrowRecords();
    }

    @PostMapping
    public Borrow createBorrowRecord(@RequestBody BorrowRequest borrowRequest) {
        return borrowService.createBorrowRecord(borrowRequest.getBookId(), borrowRequest.getBorrowerName());
    }


    @PutMapping("/return/{id}")
    public Borrow returnBook(@PathVariable Long id) {
        return borrowService.returnBook(id);
    }
}
