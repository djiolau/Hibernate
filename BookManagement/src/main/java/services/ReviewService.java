package services;

import dao.BookDao;
import dao.ReviewDao;
import entities.BookModel;
import entities.ReviewModel;

import java.util.List;

public class ReviewService {
    private ReviewDao reviewDao;
    private BookDao bookDao;

    public ReviewService(ReviewDao reviewDao, BookDao bookDao) {
        this.reviewDao = reviewDao;
        this.bookDao = bookDao;
    }

    public void addReview(int id, ReviewModel review, double score) {
        reviewDao.addReview(review);
        BookModel book = bookDao.findById(id);
        review.setBook(book);
        review.setScore(score);
        reviewDao.updateReview(review);
    }

    public List<ReviewModel> getAllReviews() {
        List<ReviewModel> reviews = reviewDao.getAllReviews();
        return reviews;
    }
}
