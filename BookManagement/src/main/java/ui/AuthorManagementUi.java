package ui;

import entities.AuthorModel;
import exceptions.DuplicateException;
import exceptions.EntityNotFoundException;
import services.AuthorService;
import services.BookService;

import java.util.List;
import java.util.Scanner;

public class AuthorManagementUi {
    private AuthorService authorService;
    private BookService bookService;
    private Scanner scanner = new Scanner(System.in);

    public AuthorManagementUi(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    public void authorUi() {
        System.out.println("Author Management");
        int option = -1;
        while (option != 0) {
            System.out.println("0. Exit");
            System.out.println("1. Add author");
            System.out.println("2. View authors");
            System.out.println("3. Delete author");
            option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1) {
                addAuthor();
            }
            if (option == 2) {
                viewAuthors();
            }
            if (option == 3) {
                deleteAuthor();
            }
        }
    }

    private void deleteAuthor() {
        viewAuthors();
        System.out.println("Enter author's id : ");
        int authorId = scanner.nextInt();
        scanner.nextLine();
        try {
            authorService.deleteAuthor(authorId);
        } catch (EntityNotFoundException e) {
            System.out.println("Author with id " + authorId + " was not found");
        }
    }

    private void viewAuthors() {
        List<AuthorModel> authors = authorService.viewAuthors();
        for (AuthorModel author : authors) {
            System.out.println(author.getId() + " . " + author.getFirstName() + " " + author.getLastName());
        }
    }

    private void addAuthor() {
        AuthorModel author = new AuthorModel();
        System.out.println("Enter author first name : ");
        String firstName = scanner.nextLine();
        author.setFirstName(firstName);
        System.out.println("Enter author last name : ");
        String lastName = scanner.nextLine();
        author.setLastName(lastName);
        try {
            authorService.addAuthor(author);
        } catch (DuplicateException e) {
            System.out.println("Author already exists");
        }
    }
}
