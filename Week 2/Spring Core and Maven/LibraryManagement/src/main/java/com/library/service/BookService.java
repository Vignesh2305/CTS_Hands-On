// Exercise 2
package com.library.service;
import com.library.repository.BookRepository;
public class BookService 
{
    private BookRepository bookRepository;
    public void setBookRepository(BookRepository bookRepository) 
    {
        this.bookRepository = bookRepository;
    }
    public void manageBooks() 
    {
        System.out.println("[BookService] Delegating save operation to BookRepository...");
        bookRepository.save();
    }
}
