package edu.bht.ase.redlib.controller;

import edu.bht.ase.redlib.dto.AuthorDto;
import edu.bht.ase.redlib.service.interfaces.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping("/{id}")
    public AuthorDto getAuthorById(@PathVariable(name = "id") String id) {
        return authorService.findAuthorById(id);
    }

    @PostMapping()
    public AuthorDto createAuthor(@RequestBody AuthorDto authorDto) {
        return authorService.createAuthor(authorDto);
    }
}
