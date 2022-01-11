package mioga.services;

import mioga.entites.BelongsTo;
import mioga.entites.Contacts;
import mioga.entites.Zulieferer;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired ; 
import mioga.repositories.ZuliefererRepository;
import mioga.utility.SFWhere;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@Service
public class ZuliefererService {
    private static final Logger LOGGER = Logger.getLogger(ContactService.class.getName()) ;
    @Autowired
    ZuliefererRepository zuliefererRepository;

    @Autowired
    ContactService contactService;

    public ResponseEntity<Object> search(Zulieferer zulieferer, Pageable pageable) {
        Page<Zulieferer> all = zuliefererRepository.findAll(SFWhere.and(zulieferer)
                .build(), pageable);
        return new ResponseEntity<>(all, HttpStatus.OK);
    }


    public Zulieferer save(Zulieferer zulieferer) {

        List<Zulieferer> entityList = zuliefererRepository.findAll();

        if (zulieferer.getTitle() == null) {
            LOGGER.log(Level.SEVERE,
                    "Contacts is null. Are you sure you have connected your form to the application?");
        } else if (!entityList.contains(zulieferer)) {

            return zuliefererRepository.save(zulieferer);
        }
        return null;
    }

    public List<Zulieferer> findAll() {
        return zuliefererRepository.findAll();
    }

    public void deleteById(int id) {
        zuliefererRepository.deleteById(id);
    }


    public void deleteAll()
    {
        zuliefererRepository.deleteAll();
    }


    public Zulieferer findById(int id){

        return zuliefererRepository.findZuliefererEntityById(id);
    }


    public List<Zulieferer> belongsToZulieferer(BelongsTo belongsTo ){

       return zuliefererRepository.findAllByBelongsTo(belongsTo);

    }


    public Zulieferer update(Zulieferer newZulieferer)
    {
        List<Contacts> contacts;
        if( zuliefererRepository.findById(newZulieferer.getId()).isPresent())
        {
            contacts = zuliefererRepository.findById(newZulieferer.getId()).get().getContacts();
            newZulieferer.setContacts(contacts);

            return zuliefererRepository.save(newZulieferer);
        }


        throw new NullPointerException("there is no zulieferer with this id");
    }


    public List<Contacts> findZuliefererContacts(int ZuliefererId )
    {
        if( zuliefererRepository.findById(ZuliefererId).isPresent())
        {
            return zuliefererRepository.findById(ZuliefererId).get().getContacts();
        }
       else throw new NullPointerException("Zulieferer with : " + ZuliefererId + " Is not exist");
    }


    public  List<Zulieferer>  getMiogaZulieferer() {

        return  zuliefererRepository.findAllByBelongsTo(BelongsTo.MIOGA);
    }

    public  List<Zulieferer>  getEMKZulieferer() {

        return  zuliefererRepository.findAllByBelongsTo(BelongsTo.EMK);
    }


}
