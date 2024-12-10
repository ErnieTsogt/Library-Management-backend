package com.LibraryManagement.Projekt.Model;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "borrow")
@Data
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    private String borrowerName;
    private LocalDateTime borrowDate = LocalDateTime.now();
    private LocalDateTime returnDate;
}
