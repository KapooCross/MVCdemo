package by.itstep.MVCdemo.controller;

import by.itstep.MVCdemo.model.Book;
import by.itstep.MVCdemo.repository.BookRepository;
import by.itstep.MVCdemo.repository.BookRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

//@Controller
@RestController
public class BookController {

//    @Autowired
//    private BookRepository bookRepository;

    @Autowired
    private BookRepository2 bookRepository;

//    @GetMapping("books2")
//    public String findAll(Model model){
////        model.addAttribute("bookList", bookRepository.findAll());
//        return BookRepository2.;
//    }

    @GetMapping("books")
    public Iterable<Book> findAll(){
        return bookRepository.findAll();
    }

    @GetMapping("create")
    public Book createBook(){
        List<String> firstPartName = Arrays.asList("Война", "Персик", "Зряшный", "Отлучиться", "Точило");
        List<String> secondPartName = Arrays.asList("Зазнайка", "Спецкор", "Подземелье", "Тюрьма", "Беспощадный");

        Random gen = new Random();
        int indexN = gen.nextInt(4);
        int indexS = gen.nextInt(4);

        String fullName = firstPartName.get(indexN) + " " +  secondPartName.get(indexS);
        int price = gen.nextInt(30, 250);

        Book book = new Book();
        book.setTitle(fullName);
        book.setPrice(price);
        return bookRepository.save(book);
    }

    @GetMapping("books/{id}")
    public Optional<Book> findById(@PathVariable Integer id){
        return bookRepository.findById(id);
    }

}
