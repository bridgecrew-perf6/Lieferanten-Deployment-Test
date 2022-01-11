package mioga.controllers;


import mioga.entites.Contacts;
import mioga.repositories.ZuliefererRepository;
import mioga.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/contacts")

public class ContactsController {

    final
    ContactService contactService;

    @Autowired
    ZuliefererRepository repository;

    Date date;

    public ContactsController(ContactService contactService) {
        this.contactService = contactService;
        this.date= new Date();
    }

    @GetMapping("/search")
    ResponseEntity<Object> search(Contacts contact, Pageable pageable) {
        return contactService.search(contact, pageable);
    }
    @PostMapping("/add")
    public ResponseEntity<Contacts> create(@RequestBody Contacts contact) {
        Date date = new Date();




        contact.setSuccessAt(date.toString());

        Contacts contact1 = contactService.save(contact);
        return new ResponseEntity<>(contact1, HttpStatus.OK);

    }



    @PutMapping("/update")
    public ResponseEntity<Contacts> update(@RequestBody Contacts contact){
        Date date = new Date();
        contact.setUpdatedAt(date.toString());

        Contacts contact1 = contactService.save(contact);
        return new ResponseEntity<>(contact1, HttpStatus.OK);
    }




    @GetMapping("/find/{id}")
    public ResponseEntity<String> getContactById(@PathVariable("id") int id) {
        String contactsEntity1 = contactService.findById(id);
        return new ResponseEntity<>(contactsEntity1, HttpStatus.OK);
    }



    @GetMapping("/all")
    public ResponseEntity<List<Contacts>> getAllContacts() {
        List<Contacts> contactsEntities = contactService.findAll();
        return new ResponseEntity<>(contactsEntities, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        contactService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
