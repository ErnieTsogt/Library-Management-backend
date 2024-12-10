package com.LibraryManagement.Projekt.dto;

import lombok.Data;

@Data
public class BorrowRequest {
    private Long bookId;
    private String borrowerName;
}

