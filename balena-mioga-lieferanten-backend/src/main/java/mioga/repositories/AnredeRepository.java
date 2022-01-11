package mioga.repositories;
import mioga.entites.Anrede;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


@Repository
public interface AnredeRepository extends CrudRepository<Anrede,Long>,JpaRepository<Anrede,Long>,PagingAndSortingRepository<Anrede,Long>,JpaSpecificationExecutor<Anrede>{

}