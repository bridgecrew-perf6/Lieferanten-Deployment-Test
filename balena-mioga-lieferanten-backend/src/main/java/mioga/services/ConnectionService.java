package mioga.services;

import mioga.entites.Connection;
import mioga.repositories.ConnectionRepository;
import mioga.utility.SFWhere;
import org.springframework.stereotype.Service;
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
@Service
public class ConnectionService {

    private static final Logger LOGGER = Logger.getLogger(ConnectionService.class.getName()) ;

    @Autowired
    ConnectionRepository connectionRepository;

    public ResponseEntity<Object> search(Connection connection, Pageable pageable) {
        Page<Connection> all = connectionRepository.findAll(SFWhere.and(connection)
                //.equal(user.getId() > 0, "id", user.getId())
                //.in(true, "userName", longs)
                //.equal(!字段值的判断.equals("") && 字段值的判断 != null, "字段名称", 字段值)
                //.like(字段值的判断 != null, "字段名称", "%" + 字段值 + "%")
                //....
                .build(), pageable);
        return new ResponseEntity<>(all, HttpStatus.OK);
    }



    public List<Connection> findAll() {
        return connectionRepository.findAll();
    }


    public Connection save(Connection connection){

        List<Connection> entityList =  connectionRepository.findAll();

        if (connection.getTitle()==null) {
            LOGGER.log(Level.SEVERE,
                    "Connection is null. Are you sure you have connected your form to the application?");
        }
        else if  (!entityList.contains(connection)) {


            return   connectionRepository.save(connection);
        }


        return null;
    }






    public void deleteById(int id) {
        connectionRepository.deleteById(id);
    }


    public Connection findById(int id){

        return connectionRepository.findConnectionsEntitiesById(id);
    }


    public Connection update(Connection newConnections, int id){

        return connectionRepository.findById( id).map(connections -> {
            connections.setDescription(newConnections.getDescription());
            connections.setFkProtocolId(newConnections.getFkProtocolId());
            connections.setFkZulieferId(newConnections.getFkZulieferId());
            connections.setTitle(newConnections.getTitle());
            connections.setUrl(newConnections.getUrl());


                    return connectionRepository.save(connections);
                })

                .orElseGet(() -> {
                    newConnections.setId(id);
                    return connectionRepository.save(newConnections);
                });

    }




















}
