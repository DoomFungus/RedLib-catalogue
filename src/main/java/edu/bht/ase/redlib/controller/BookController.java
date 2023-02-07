package edu.bht.ase.redlib.controller;

import edu.bht.ase.redlib.dto.BookDto;
import edu.bht.ase.redlib.service.interfaces.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable(name = "id") Integer id){
        return bookService.findBookById(id);
    }

    @PostMapping()
    public BookDto createBook(BookDto bookDto){
        return bookService.createBook(bookDto);
    }
}
