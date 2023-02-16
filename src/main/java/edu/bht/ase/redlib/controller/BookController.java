package edu.bht.ase.redlib.controller;

import edu.bht.ase.redlib.dto.BookDto;
import edu.bht.ase.redlib.dto.ReviewDto;
import edu.bht.ase.redlib.service.interfaces.BookService;
import edu.bht.ase.redlib.service.interfaces.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final ReviewService reviewService;

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable(name = "id") String id) {
        return bookService.findBookById(id);
    }

    @PostMapping()
    public BookDto createBook(@RequestBody BookDto bookDto) {
        return bookService.createBook(bookDto);
    }

    @GetMapping("/{id}/review")
    public List<ReviewDto> getReviews(@PathVariable(name = "id") String id) {
        return reviewService.findReviewsByBookId(id);
    }

    @PostMapping("/{id}/review")
    public ReviewDto createReview(@PathVariable(name = "id") String id, @RequestBody ReviewDto reviewDto) {
        return reviewService.createReview(id, reviewDto);
    }
}
