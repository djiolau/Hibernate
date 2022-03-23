package services;

import dao.AuthorDao;
import dao.BookDao;
import entities.BookModel;

import java.util.List;

public class BookService {
    private AuthorDao authorDao;
    private BookDao bookDao;

    public BookService(AuthorDao authorDao,BookDao bookDao){
        this.authorDao = authorDao;
        this.bookDao = bookDao;
    }

    public void addBook(BookModel newBook){
        List<BookModel> books = bookDao.getAllBooks();
        bookDao.addBook(newBook);
    }
    public List<BookModel> viewBooks(){
        List<BookModel> books = bookDao.getAllBooks();
        return books;
    }

    public void deleteBook(int id){
        BookModel book = bookDao.findById(id);
        bookDao.deleteBook(book);
    }

}
