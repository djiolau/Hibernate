package services;

import dao.AuthorDao;
import dao.BookDao;

public class AuthorService {
    private AuthorDao authorDao;
    private BookDao bookDao;

    public AuthorService(AuthorDao authorDao,BookDao bookDao){
        this.authorDao = authorDao;
        this.bookDao = bookDao;
    }
}
