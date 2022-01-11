package mioga.services;

import mioga.entites.Anrede;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired ; 
import mioga.repositories.AnredeRepository;
import mioga.utility.SFWhere;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 服务类
 * @author 刘前进 xindong888@163.com  www.xjke.com
 * @since 1.0.0
 */
@Service
public class AnredeService {
    private static final java.util.logging.Logger LOGGER = Logger.getLogger(AnredeService.class.getName());

    @Autowired
    AnredeRepository anredeRepository;

    public ResponseEntity<Object> search(Anrede anrede, Pageable pageable) {
        Page<Anrede> all = anredeRepository.findAll(SFWhere.and(anrede)
                //.equal(anrede.getId() > 0, "id", anrede.getId())
                //.in(true, "userName", longs)
                //.equal(!字段值的判断.equals("") && 字段值的判断 != null, "字段名称", 字段值)
                //.like(字段值的判断 != null, "字段名称", "%" + 字段值 + "%")
                //....
                .build(), pageable);
        return new ResponseEntity<>(all, HttpStatus.OK);
    }



    public Anrede save(Anrede anrede){

        List<Anrede> entityList =  anredeRepository.findAll();

        if (anrede.getAnrede()==null) {
            LOGGER.log(Level.SEVERE,
                    "Anrede is null. Are you sure you have connected your form to the application?");
        }
        else if  (!entityList.contains(anrede)) {

            return   anredeRepository.save(anrede);
        }

        return null;
    }



    public Anrede update(Anrede newAnrede, int id){

        return anredeRepository.findById((long) id).map(anrede -> {
            anrede.setAnrede(newAnrede.getAnrede());

            return anredeRepository.save(anrede);
        })
                .orElseGet(() -> {
                    newAnrede.setId(id);
                    return anredeRepository.save(newAnrede);
                });

    }


    public void deleteById(int id) {
        anredeRepository.deleteById((long) id);
    }



    public List<Anrede> findAll() {
        return anredeRepository.findAll();
    }



    public Optional<Anrede> findById(int id){

        return anredeRepository.findById((long) id);
    }










}
