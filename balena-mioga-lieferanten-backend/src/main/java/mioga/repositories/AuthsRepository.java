package mioga.repositories;
import mioga.entites.Auths;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

@Repository
public interface AuthsRepository extends CrudRepository<Auths,Integer>,JpaRepository<Auths,Integer>,PagingAndSortingRepository<Auths,Integer>,JpaSpecificationExecutor<Auths>{

}