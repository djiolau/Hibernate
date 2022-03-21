package dao;


import entities.AuthorModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class AuthorDao {
   private SessionFactory sessionFactory;

   public AuthorDao(SessionFactory sessionFactory) {
       this.sessionFactory = sessionFactory;
   }
   public List<AuthorModel> getAllAuthors(){
       Session session = sessionFactory.openSession();
       List<AuthorModel> authors = session.createQuery("from AuthorModel").getResultList();
       session.close();
       return authors;
   }
}
