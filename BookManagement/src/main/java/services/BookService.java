package services;

import dao.AuthorDao;
import dao.BookDao;
import entities.BookModel;
import exceptions.DuplicateException;
import exceptions.EntityNotFoundException;

import java.util.List;

public class BookService {
    private AuthorDao authorDao;
    private BookDao bookDao;

    public BookService(AuthorDao authorDao,BookDao bookDao){
        this.authorDao = authorDao;
        this.bookDao = bookDao;
    }

    public void addBook(BookModel newBook) throws DuplicateException {
        List<BookModel> books = bookDao.getAllBooks();
        for (BookModel book : books){
            if ((book.getTitle()).equals((newBook.getTitle()))){
                throw new DuplicateException();
            }
        }
        bookDao.addBook(newBook);
    }
    public List<BookModel> viewBooks(){
        List<BookModel> books = bookDao.getAllBooks();
        return books;
    }

    public void deleteBook(int id) throws EntityNotFoundException {
        BookModel book = bookDao.findById(id);
        if (book == null){
            throw new EntityNotFoundException();
        }
        bookDao.deleteBook(book);
    }

}
