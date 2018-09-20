package pl.zajecia23zadanie.zadaniedomowe;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {
    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/book_nr={id}")
    public String movieDetails(@PathVariable Long id, Model model) {
        Book book = bookRepository.getByID(id);

        model.addAttribute("book", book);

        return "book";

    }

    @GetMapping("/dodaj")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "add-book";
    }

    @PostMapping("/dodaj")
    public String addBook(Book book) {
        bookRepository.saveNewBook(book);
        return "redirect:/";
    }

}
