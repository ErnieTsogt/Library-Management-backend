package com.LibraryManagement.Projekt.Service;
import com.LibraryManagement.Projekt.Model.Book;
import com.LibraryManagement.Projekt.Model.Borrow;
import com.LibraryManagement.Projekt.Repository.BorrowRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BorrowService {
    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private BookService bookService;

    public List<Borrow> getAllBorrowRecords() {
        return borrowRepository.findAll();
    }

    public Borrow createBorrowRecord(Long bookId, String borrowerName) {
        Book book = bookService.getBookById(bookId);
        if (!book.isAvailable()) {
            throw new RuntimeException("Book is not available for borrowing");
        }

        book.setAvailable(false);
        bookService.updateBook(bookId, book);

        Borrow record = new Borrow();
        record.setBook(book);
        record.setBorrowerName(borrowerName);
        return borrowRepository.save(record);
    }

    public Borrow returnBook(Long recordId) {
        Borrow record = borrowRepository.findById(recordId)
                .orElseThrow(() -> new RuntimeException("Borrow record not found"));

        record.setReturnDate(LocalDateTime.now());
        record.getBook().setAvailable(true);
        bookService.updateBook(record.getBook().getId(), record.getBook());

        return borrowRepository.save(record);
    }
}
