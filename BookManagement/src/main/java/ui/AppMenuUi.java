package ui;

import java.util.Scanner;

public class AppMenuUi {
    private AuthorManagementUi authorManagementUi;
    private BookManagementUi bookManagementUi;
    private ReviewManagementUi reviewManagementUi;

    private Scanner scanner = new Scanner(System.in);

    public AppMenuUi(AuthorManagementUi authorManagementUi, BookManagementUi bookManagementUi, ReviewManagementUi reviewManagementUi) {
        this.authorManagementUi = authorManagementUi;
        this.bookManagementUi = bookManagementUi;
        this.reviewManagementUi = reviewManagementUi;
    }

    public void startApp() {
        System.out.println("BOOKSTORE APP");
        int option = -1;
        while (option != 0) {
            System.out.println("0. Exit");
            System.out.println("1. Author Management");
            System.out.println("2. Book Management");
            System.out.println("3. Review Management");

            option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1) {
                authorManagementUi.authorUi();
            }
            if (option == 2) {
                System.out.println("To do ... ");
            }
            if (option == 3) {
                System.out.println("To do ... ");
            }
        }
    }
}
