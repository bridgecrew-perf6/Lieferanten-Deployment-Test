package mioga.repositories;
import mioga.entites.Connection;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


@Repository
public interface ConnectionRepository extends CrudRepository<Connection,Integer>,JpaRepository<Connection,Integer>,PagingAndSortingRepository<Connection,Integer>,JpaSpecificationExecutor<Connection>{

    Connection findConnectionsEntitiesById(int id);
}