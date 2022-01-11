package mioga.controllers;

import mioga.entites.BelongsTo;
import mioga.entites.Contacts;
import mioga.entites.Zulieferer;
import mioga.services.ZuliefererService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@RestController
@CrossOrigin // Very Important to allow Frontend To Access and Modify
@RequestMapping("/zulieferer")
public class ZuliefererController {


    final
    ZuliefererService zuliefererService;


    public ZuliefererController(ZuliefererService zuliefererService) {
        this.zuliefererService = zuliefererService;

    }

    @GetMapping("/all")
    public ResponseEntity<List<Zulieferer>> getAllContacts() {
        List<Zulieferer> zuliefererEntities = zuliefererService.findAll();
        return new ResponseEntity<>(zuliefererEntities, HttpStatus.OK);
    }



    @PostMapping("/add")
    public ResponseEntity<Zulieferer> create(@RequestBody Zulieferer zulieferer) {

        UUID uuid = UUID.randomUUID();
        Date date = new Date();
        zulieferer.setSuccessAt(date.toString());

        zulieferer.setUuid(String.valueOf(uuid));


        Zulieferer zulieferer1 = zuliefererService.save(zulieferer);
        return new ResponseEntity<Zulieferer>(zulieferer1, HttpStatus.OK);

    }


    @PutMapping("/update")
    public ResponseEntity<Zulieferer> update(@RequestBody Zulieferer zulieferer) {
        Date date = new Date();
        zulieferer.setUpdatedAt(date.toString());
        Zulieferer zulieferer1 = zuliefererService.update(zulieferer);
        return new ResponseEntity<>(zulieferer1, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Zulieferer> getContactById(@PathVariable("id") int id) {
        Zulieferer zulieferer1 = zuliefererService.findById(id);
        return new ResponseEntity<>(zulieferer1, HttpStatus.OK);
    }

    @GetMapping("belongs/{id}")
    public ResponseEntity<List<Zulieferer>> getZuliefererBelongTo(@PathVariable("id") int belongsID ){

        List<Zulieferer> zuliefererList = null;
        if (belongsID == 0) {

            zuliefererList=zuliefererService.belongsToZulieferer(BelongsTo.MIOGA);
        }
        else if (belongsID == 1) {
           zuliefererList= zuliefererService.belongsToZulieferer(BelongsTo.EMK);
        }
        return new ResponseEntity<>(zuliefererList, HttpStatus.OK);
    }



    @GetMapping("belongs/mioga")
    public ResponseEntity<List<Zulieferer>> getZuliefererBelongToMioga(){


        List<Zulieferer> zuliefererList =  zuliefererService.getMiogaZulieferer();

        return new ResponseEntity<>(zuliefererList, HttpStatus.OK);
    }





    @GetMapping("belongs/emk")
    public ResponseEntity<List<Zulieferer>> getZuliefererBelongToEMK(){


        List<Zulieferer> zuliefererList =  zuliefererService.getEMKZulieferer();

        return new ResponseEntity<>(zuliefererList, HttpStatus.OK);
    }





    @GetMapping("/contacts/{id}" )
    public List<Contacts> getAllContactForZulieferer(@PathVariable("id") int zuliefererId)
    {
        return zuliefererService.findZuliefererContacts(zuliefererId);
    }





    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        zuliefererService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAll() {
        zuliefererService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }









}
