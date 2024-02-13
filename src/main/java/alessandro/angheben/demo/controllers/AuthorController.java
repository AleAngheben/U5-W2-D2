package alessandro.angheben.demo.controllers;

import alessandro.angheben.demo.entities.Author;
import alessandro.angheben.demo.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
@Autowired
AuthorService authorService;

@GetMapping
    public List<Author> getAuthors(){
    return authorService.getAuthors();
}

@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author save(@RequestBody Author body){
    return authorService.save(body);
}

@GetMapping("/{id}")
public Author getById(long id){
    return authorService.findById(id);
}


@PutMapping("/{id}")
public Author getByIdAndUpdate(@PathVariable long id, @RequestBody Author author){

    return authorService.findByIdAndUpdate(id,author);
}

@DeleteMapping("/{id}")
    public void getByIdAndDelete(@PathVariable long id){
    authorService.findByIdAndDelete(id);
}


}
