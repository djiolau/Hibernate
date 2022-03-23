package services;

import dao.AuthorDao;
import dao.BookDao;
import entities.AuthorModel;

import java.util.List;

public class AuthorService {
    private AuthorDao authorDao;
    private BookDao bookDao;

    public AuthorService(AuthorDao authorDao,BookDao bookDao){
        this.authorDao = authorDao;
        this.bookDao = bookDao;
    }

    public void addAuthor(AuthorModel newAuthor){
        List<AuthorModel> authors = authorDao.getAllAuthors();
        authorDao.addAuthor(newAuthor);
    }

    public List<AuthorModel> viewAuthors(){
        List<AuthorModel> authors = authorDao.getAllAuthors();
        return authors;
    }

    public void deleteAuthor(int id){
        AuthorModel author = authorDao.findById(id);
        authorDao.deleteAuthor(author);
    }
}
