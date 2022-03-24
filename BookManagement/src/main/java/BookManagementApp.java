import dao.AuthorDao;
import dao.BookDao;
import dao.ReviewDao;
import org.hibernate.SessionFactory;
import services.AuthorService;
import services.BookService;
import services.ReviewService;
import ui.AppMenuUi;
import ui.AuthorManagementUi;
import ui.BookManagementUi;
import ui.ReviewManagementUi;

public class BookManagementApp {
    public static void main(String[] args) {
        SessionSettings sessionSettings = new SessionSettings();
        SessionFactory sessionFactory = sessionSettings.getSessionFactory();

        AuthorDao authorDao = new AuthorDao(sessionFactory);
        BookDao bookDao = new BookDao(sessionFactory);
        ReviewDao reviewDao = new ReviewDao(sessionFactory);

        AuthorService authorService = new AuthorService(authorDao,bookDao);
        BookService bookService = new BookService(authorDao,bookDao);
        ReviewService reviewService = new ReviewService(reviewDao,bookDao);

        AuthorManagementUi authorManagementUi = new AuthorManagementUi(authorService,bookService);
        BookManagementUi bookManagementUi = new BookManagementUi();
        ReviewManagementUi reviewManagementUi = new ReviewManagementUi();

        AppMenuUi appMenuUi = new AppMenuUi(authorManagementUi,bookManagementUi,reviewManagementUi);
        appMenuUi.startApp();
    }
}

