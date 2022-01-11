package mioga.controllers;

import mioga.entites.Anrede;
import mioga.services.AnredeService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/anrede")
public class AnredeController {

    final
    AnredeService anredeService;

    public AnredeController(AnredeService anredeService) {
        this.anredeService = anredeService;
    }


     @GetMapping
     ResponseEntity<Object> search(Anrede anrede, Pageable pageable) {
             return anredeService.search(anrede, pageable);
     }



    @GetMapping("/all")
    public ResponseEntity<List<Anrede>> getAllActions() {
        List<Anrede> anredeEntities = anredeService.findAll();
        return new ResponseEntity<>(anredeEntities, HttpStatus.OK);
    }



    @PostMapping("/add")
    public ResponseEntity<Anrede> create(@RequestBody Anrede anrede) {
        Anrede anrede1 = anredeService.save(anrede);
        return new ResponseEntity<Anrede>( anrede1 , HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Anrede> update(@RequestBody Anrede anrede , @PathVariable("id") int id){
        Anrede anrede1 = anredeService.update(anrede , id);
        return new ResponseEntity<>(anrede1, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        anredeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
