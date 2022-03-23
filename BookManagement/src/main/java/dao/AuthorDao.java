package dao;


import entities.AuthorModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class AuthorDao {
    private SessionFactory sessionFactory;

    public AuthorDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<AuthorModel> getAllAuthors() {
        Session session = sessionFactory.openSession();
        List<AuthorModel> authors = session.createQuery("from AuthorModel").getResultList();
        session.close();
        return authors;
    }

    public void addAuthor(AuthorModel author) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(author);
        transaction.commit();
        session.close();
    }

    public void deleteAuthor(AuthorModel author) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(author);
        transaction.commit();
        session.close();
    }

    public AuthorModel findById(int id) {
        Session session = sessionFactory.openSession();
        AuthorModel author = session.find(AuthorModel.class, id);
        session.close();
        return author;
    }

    public AuthorModel findByName(String name) {
        Session session = sessionFactory.openSession();
        AuthorModel author = session.find(AuthorModel.class, name);
        session.close();
        return author;
    }

}
