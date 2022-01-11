package mioga.services;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired ; 
import mioga.repositories.FileFormatRepository;
import mioga.utility.SFWhere;
import mioga.entites.Fileformat;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 服务类
 * @author 刘前进 xindong888@163.com  www.xjke.com
 * @since 1.0.0
 */
@Service
public class FileFormatService {

    private static final Logger LOGGER = Logger.getLogger(FileFormatService.class.getName()) ;

    @Autowired
    FileFormatRepository fileFormatRepository;



    public ResponseEntity<Object> search(Fileformat fileformat, Pageable pageable) {
        Page<Fileformat> all = fileFormatRepository.findAll(SFWhere.and(fileformat)
                //.equal(user.getId() > 0, "id", user.getId())
                //.in(true, "userName", longs)
                //.equal(!字段值的判断.equals("") && 字段值的判断 != null, "字段名称", 字段值)
                //.like(字段值的判断 != null, "字段名称", "%" + 字段值 + "%")
                //....
                .build(), pageable);
        return new ResponseEntity<>(all, HttpStatus.OK);
    }



    public List<Fileformat> findAll() {
        return fileFormatRepository.findAll();
    }


    public Fileformat save(Fileformat fileformat){

        List<Fileformat> entityList =  fileFormatRepository.findAll();

        if (fileformat.getFileType()==null) {
            LOGGER.log(Level.SEVERE,
                    "File is null. Are you sure you have connected your form to the application?");
        }
        else if  (!entityList.contains(fileformat)) {


            return   fileFormatRepository.save(fileformat);
        }


        return null;
    }


    public void deleteById(int id) {
        fileFormatRepository.deleteById( id);
    }


    public Fileformat findById(int id){

        return fileFormatRepository.findFileFormatEntityById(id);
    }



    public Fileformat update(Fileformat newfileformat, int id){

        return fileFormatRepository.findById( id).map(fileformat -> {
            fileformat.setFileType(newfileformat.getFileType());
            fileformat.setFkZulieferId(newfileformat.getFkZulieferId());

                    return fileFormatRepository.save(newfileformat);
                })

                .orElseGet(() -> {
                    newfileformat.setId(id);
                    return fileFormatRepository.save(newfileformat);
                });

    }



















}
