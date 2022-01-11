package mioga.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import mioga.entites.Connection;
import mioga.services.ConnectionService;

import java.util.List;

/**
 * 服务类
 * @author 刘前进 xindong888@163.com  www.xjke.com
 * @since 1.0.0
 */
@RestController
@CrossOrigin
@RequestMapping("/connections")

public class ConnectionsController {

    final
    ConnectionService connectionService;

    public ConnectionsController(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

     @GetMapping
     ResponseEntity<Object> search(Connection connection, Pageable pageable) {
             return connectionService.search(connection, pageable);
     }


    @GetMapping("/all")
    public ResponseEntity<List<Connection>> getAllActions() {
        List<Connection> contactsEntities = connectionService.findAll();
        return new ResponseEntity<>(contactsEntities, HttpStatus.OK);
    }



    @GetMapping("/find/{id}")
    public ResponseEntity<Connection> getActionById(@PathVariable("id") int id) {
        Connection connection = connectionService.findById(id);
        return new ResponseEntity<>(connection, HttpStatus.OK);
    }


    /***
     *
     * @param connection save the  new Action Object throw  actionsEntityService.save
     *
     */

    @PostMapping("/add")
    public ResponseEntity<Connection> create(@RequestBody Connection connection) {
        Connection connection1 = connectionService.save(connection);
        return new ResponseEntity<Connection>(connection1, HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Connection> update(@RequestBody Connection connection, @PathVariable("id") int id){
        Connection connection1 = connectionService.update(connection, id);
        return new ResponseEntity<>(connection1, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        connectionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
