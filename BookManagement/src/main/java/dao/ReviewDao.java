package dao;

import entities.ReviewModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ReviewDao {
    private SessionFactory sessionFactory;

    public ReviewDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<ReviewModel> getAllReviews(){
        Session session = sessionFactory.openSession();
        List<ReviewModel> reviews = session.createQuery("from ReviewModel").getResultList();
        session.close();
        return reviews;
    }

    public void addReview(ReviewModel review){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(review);
        transaction.commit();
        session.close();
    }

    public void updateReview(ReviewModel review){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(review);
        transaction.commit();
        session.close();
    }


}
