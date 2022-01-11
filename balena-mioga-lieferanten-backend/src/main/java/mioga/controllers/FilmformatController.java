package mioga.controllers;

import mioga.services.FileFormatService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import mioga.entites.Fileformat;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/fileformat")

public class FilmformatController {

    final
    FileFormatService fileFormatService;

    public FilmformatController(FileFormatService fileFormatService) {
        this.fileFormatService = fileFormatService;
    }


     @GetMapping
     ResponseEntity<Object> search(Fileformat fileformat, Pageable pageable) {
             return fileFormatService.search(fileformat, pageable);
     }


    @PostMapping("/add")
    public ResponseEntity<Fileformat> create(@RequestBody Fileformat fileformat) {
        Fileformat fileformat1 = fileFormatService.save(fileformat);
        return new ResponseEntity<Fileformat>( fileformat1 , HttpStatus.OK);

    }



    @PutMapping("/update/{id}")
    public ResponseEntity<Fileformat> update(@RequestBody Fileformat fileformat, @PathVariable("id") int id){
        Fileformat fileformat1 = fileFormatService.update(fileformat, id);
        return new ResponseEntity<>(fileformat1, HttpStatus.OK);
    }



    @GetMapping("/find/{id}")
    public ResponseEntity<Fileformat> getFileFormatById(@PathVariable("id") int id) {
        Fileformat fileformat = fileFormatService.findById(id);
        return new ResponseEntity<>(fileformat, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Fileformat>> getAllFileFormats() {
        List<Fileformat> fileformatEntities = fileFormatService.findAll();
        return new ResponseEntity<>(fileformatEntities, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        fileFormatService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
