package mioga.controllers;


import mioga.entites.Protocol;
import mioga.repositories.ProtocolRepository;
import mioga.services.ProtocolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/protocol")

public class ProtocolController {


    @Autowired
    ProtocolRepository protocolRepo;

    final
    ProtocolService protocolService;

    public ProtocolController(ProtocolService protocolService) {
        this.protocolService = protocolService;
    }

    @GetMapping
    ResponseEntity<Object> search(Protocol protocol, Pageable pageable) {
        return protocolService.search(protocol, pageable);
    }

    @PostMapping("/add")
    public ResponseEntity<Protocol> create(@RequestBody Protocol protocol) {
        Protocol protocol1 = protocolService.save(protocol);
        return new ResponseEntity<Protocol>(protocol1, HttpStatus.OK);

    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Protocol> update(@RequestBody Protocol protocol, @PathVariable("id") int id) {
        Protocol protocol1 = protocolService.update(protocol, id);
        return new ResponseEntity<>(protocol1, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Protocol> getProtocolById(@PathVariable("id") int id) {
        Protocol protocol = protocolService.findById(id);
        return new ResponseEntity<>(protocol, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Protocol>> getAllContacts() {
        List<Protocol> protocolEntities = protocolService.findAll();
        return new ResponseEntity<>(protocolEntities, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        protocolService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
