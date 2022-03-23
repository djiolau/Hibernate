package dao;

import entities.BookModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class BookDao {
    private SessionFactory sessionFactory;

    public BookDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<BookModel> getAllBooks() {
        Session session = sessionFactory.openSession();
        List<BookModel> books = session.createQuery("from BookModel").getResultList();
        session.close();
        return books;
    }

    public void addBook(BookModel book) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(book);
        transaction.commit();
        session.close();
    }

    public void editBook(int id, String newName) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        BookModel book = session.find(BookModel.class, id);
        book.setTitle(newName);
        session.saveOrUpdate(book);
        transaction.commit();
        session.close();
    }

    public void updateBook(BookModel book) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(book);
        transaction.commit();
        session.close();
    }

    public void deleteBook(BookModel book) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(book);
        transaction.commit();
        session.close();
    }

    public BookModel findById(int id) {
        Session session = sessionFactory.openSession();
        BookModel book = session.find(BookModel.class, id);
        session.close();
        return book;
    }
}
