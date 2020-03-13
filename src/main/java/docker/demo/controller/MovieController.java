package docker.demo.controller;

import docker.demo.model.Movie;
import docker.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieRepository movieRepository;

    @GetMapping
    public List<Movie> getAll(){
        return movieRepository.findAll();
    }

    @PostMapping
    public Movie insert(@RequestBody Movie insertedMovie){
//        Movie a = new Movie("The Shawshank Redemption","1994","Crime");
        Movie movie = new Movie(insertedMovie.getTitle(),insertedMovie.getYear(),insertedMovie.getGenre());
        return movieRepository.save(movie);
    }

    @PutMapping("/{id}")
    public Movie update(@PathVariable long id, @RequestBody Movie updateMovie){
        Optional<Movie> optionalMovie = movieRepository.findById(id);

        if(optionalMovie.isPresent()){
            Movie movie = optionalMovie.get();
            movie.setTitle(updateMovie.getTitle());
            movie.setYear(updateMovie.getYear());
            movie.setGenre(updateMovie.getGenre());

            return movieRepository.save(movie);
        } else {
            return movieRepository.getOne(id);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        movieRepository.deleteById(id);
    }

}
