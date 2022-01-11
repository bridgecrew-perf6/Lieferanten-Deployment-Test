package mioga.services;

import mioga.entites.Protocol;
import mioga.repositories.ProtocolRepository;
import mioga.utility.SFWhere;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired ;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 服务类
 * @author 刘前进 xindong888@163.com  www.xjke.com
 * @since 1.0.0
 */
@Component

public class ProtocolService {

    private static final Logger LOGGER = Logger.getLogger(ProtocolService.class.getName()) ;

    @Autowired
    ProtocolRepository protocolRepository;


    public ResponseEntity<Object> search(Protocol protocol, Pageable pageable) {
        Page<Protocol> all = protocolRepository.findAll(SFWhere.and(protocol)
                //.equal(user.getId() > 0, "id", user.getId())
                //.in(true, "userName", longs)
                //.equal(!字段值的判断.equals("") && 字段值的判断 != null, "字段名称", 字段值)
                //.like(字段值的判断 != null, "字段名称", "%" + 字段值 + "%")
                //....
                .build(), pageable);
        return new ResponseEntity<>(all, HttpStatus.OK);
    }




    public Protocol save(Protocol protocol){

        List<Protocol> entityList =  protocolRepository.findAll();

        if (protocol.getWebsite()==null) {
            LOGGER.log(Level.SEVERE,
                    "Protocol is null. Are you sure you have connected your form to the application?");
        }
        else if  (!entityList.contains(protocol)) {


            return   protocolRepository.save(protocol);
        }


        return null;
    }




    public void deleteById(int id) {
        protocolRepository.deleteById(id);
    }


    public List<Protocol> findAll() {
        return protocolRepository.findAll();
    }

    public Protocol findById(int id){

        return protocolRepository.findProtocolEntityById(id);
    }



    public Protocol update(Protocol newProtocol, int id){

        return protocolRepository.findById( id).map(protocol -> {
                    protocol.setFtp(newProtocol.getFtp());
                    protocol.setHttp(newProtocol.getHttp());
                    protocol.setHttps(newProtocol.getHttps());
                    protocol.setRestapi(newProtocol.getRestapi());
                    protocol.setScp(newProtocol.getScp());
                    protocol.setSftp(newProtocol.getSftp());
                    protocol.setWebsite(newProtocol.getWebsite());
                    return protocolRepository.save(protocol);
                })

                .orElseGet(() -> {
                    newProtocol.setId(id);
                    return protocolRepository.save(newProtocol);
                });

    }









}
