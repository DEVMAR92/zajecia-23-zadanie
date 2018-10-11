package pl.zajecia23zadanie.zadaniedomowe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.zajecia23zadanie.zadaniedomowe.BookRepository;
import pl.zajecia23zadanie.zadaniedomowe.model.Book;

@Controller
public class BookController {
    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/book_nr={id}")
    public String movieDetails(@PathVariable Long id,
                               Model model) {
        Book book = bookRepository.getByID(id);
        model.addAttribute("book", book);
        return "book";
    }

    @GetMapping("/add_book")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "add-book";
    }

    @PostMapping("/add_book")
    public String addBook(Book book) {
        bookRepository.saveNewBook(book);
        return "redirect:/";
    }

    @GetMapping("/edit_book={id}")
    public String editBookForm(@PathVariable Long id,
                               Model model) {
        Book book = bookRepository.getByID(id);
        model.addAttribute("id", id);
        model.addAttribute("book", book);

        return "edit-book";
    }

    @PostMapping("/edit_book")
    public String editBookForm(Book book) {
        bookRepository.edit(book);

        return "redirect:/";
    }

    @GetMapping("/remove_book={id}")
    public String deleteBookForm(@PathVariable Long id) {

        bookRepository.deleteBook(id);

        return "redirect:/";
    }

}
