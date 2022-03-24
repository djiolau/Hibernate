package services;

import dao.AuthorDao;
import dao.BookDao;
import entities.AuthorModel;
import exceptions.DuplicateException;
import exceptions.EntityNotFoundException;

import java.util.List;

public class AuthorService {
    private AuthorDao authorDao;
    private BookDao bookDao;

    public AuthorService(AuthorDao authorDao,BookDao bookDao){
        this.authorDao = authorDao;
        this.bookDao = bookDao;
    }

    public void addAuthor(AuthorModel newAuthor) throws DuplicateException {
        List<AuthorModel> authors = authorDao.getAllAuthors();
        for (AuthorModel author : authors){
            if ((author.getFirstName() + author.getLastName()).equals((newAuthor.getFirstName() + newAuthor.getLastName()))){
                throw  new DuplicateException();
            }
        }
        authorDao.addAuthor(newAuthor);
    }

    public List<AuthorModel> viewAuthors(){
        List<AuthorModel> authors = authorDao.getAllAuthors();
        return authors;
    }

    public void deleteAuthor(int id) throws EntityNotFoundException {
        AuthorModel author = authorDao.findById(id);
        if (author == null){
            throw new EntityNotFoundException();
        }
        authorDao.deleteAuthor(author);
    }
}
