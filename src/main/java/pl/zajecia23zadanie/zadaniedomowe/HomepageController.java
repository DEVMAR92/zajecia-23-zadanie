package pl.zajecia23zadanie.zadaniedomowe;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
