package mioga.controllers;

import mioga.entites.Actions;
import mioga.services.ActionsService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController


@RequestMapping("/actions")

public class ActionsController {


    final
    ActionsService actionsService;


    ActionsController(ActionsService actionsService) {

        this.actionsService = actionsService;
    }

    @GetMapping
    ResponseEntity<Object> search(Actions actions, Pageable pageable) {
        return actionsService.search(actions, pageable);
    }


    @GetMapping("/all")
    public ResponseEntity<List<Actions>> getAllActions() {
        List<Actions> contactsEntities = actionsService.findAll();
        return new ResponseEntity<>(contactsEntities, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Actions> getActionById(@PathVariable("id") int id) {
        Actions actions1 = actionsService.findById(id);
        return new ResponseEntity<>(actions1, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Actions> create(@RequestBody Actions actions) {
        UUID uuid = UUID.randomUUID();

        actions.setUuid(String.valueOf(uuid));

        Actions actions1 = actionsService.save(actions);
        return new ResponseEntity<Actions>(actions1, HttpStatus.OK);

    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Actions> update(@RequestBody Actions actions, @PathVariable("id") int id) {
        Actions actions1 = actionsService.update(actions, id);
        return new ResponseEntity<>(actions1, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        actionsService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
