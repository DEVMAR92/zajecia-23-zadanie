package pl.zajecia23zadanie.zadaniedomowe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.zajecia23zadanie.zadaniedomowe.BookRepository;
import pl.zajecia23zadanie.zadaniedomowe.model.Book;

import java.util.List;

@Controller
public class HomepageController {

    private BookRepository bookRepository;

    public HomepageController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/")
    public String start(Model model){
        List<Book> books = bookRepository.getAll();

        model.addAttribute("books", books);

        return "homepage";
    }

    @GetMapping("/sort=title")
    public String sortByTitle(Model model){

        List<Book> books = bookRepository.getAllByTitle();


        model.addAttribute("books", books);

        return "homepage";
    }
    @GetMapping("/sort=isbn")
    public String sortByIsbn(Model model){

        List<Book> books = bookRepository.getAllByIsbn();


        model.addAttribute("books", books);

        return "homepage";
    }
    @GetMapping("/sort=date")
    public String sortByReleaseDate(Model model){

        List<Book> books = bookRepository.getAllByDate();


        model.addAttribute("books", books);

        return "homepage";
    }
}
