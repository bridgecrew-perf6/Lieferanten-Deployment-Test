package mioga.repositories;
import mioga.entites.Protocol;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


@Repository
public interface ProtocolRepository extends CrudRepository<Protocol,Integer>,JpaRepository<Protocol,Integer>,PagingAndSortingRepository<Protocol,Integer>,JpaSpecificationExecutor<Protocol>{

    @Override
    List<Protocol> findAll();

    Protocol findProtocolEntityById(int id);


}