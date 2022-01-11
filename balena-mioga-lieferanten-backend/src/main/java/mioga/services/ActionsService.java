package mioga.services;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired ; 
import mioga.repositories.ActionsRepository;
import mioga.utility.SFWhere;
import mioga.entites.Actions;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@Service
public class ActionsService {
    private static final Logger LOGGER = Logger.getLogger(ActionsService.class.getName()) ;



    @Autowired
    ActionsRepository actionsRepository;


    public ResponseEntity<Object> search(Actions actions, Pageable pageable) {
        Page<Actions> all = actionsRepository.findAll(SFWhere.and(actions)
                //.equal(user.getId() > 0, "id", user.getId())
                //.in(true, "userName", longs)
                //.equal(!字段值的判断.equals("") && 字段值的判断 != null, "字段名称", 字段值)
                //.like(字段值的判断 != null, "字段名称", "%" + 字段值 + "%")
                //....
                .build(), pageable);
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    public List<Actions> findAll() {
        return actionsRepository.findAll();
    }


    public Actions save(Actions actions){

        List<Actions> entityList =  actionsRepository.findAll();

        if (actions.getTitle()==null) {
            LOGGER.log(Level.SEVERE,
                    "Action is null. Are you sure you have connected your form to the application?");
        }
        else if  (!entityList.contains(actions)) {


            return   actionsRepository.save(actions);
        }


        return null;
    }


    public void deleteById(int id) {
        actionsRepository.deleteById((long) id);
    }


    public Actions findById(int id){

      return actionsRepository.findActionsEntityById( id);
    }



    public Actions update(Actions newActions, int id){

        return actionsRepository.findById((long) id).map(action -> {
            action.setTitle(newActions.getTitle());
            action.setDescription(newActions.getDescription());
            action.setCommandline(newActions.getCommandline());
            action.setUuid(newActions.getUuid());
            action.setFK_(newActions.getFK_());              // method updateAt should also updated?
            return actionsRepository.save(action);
        })

                .orElseGet(() -> {
                    newActions.setId(id);
                    return actionsRepository.save(newActions);
                });

    }



}

