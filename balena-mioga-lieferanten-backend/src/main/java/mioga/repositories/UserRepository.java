package mioga.repositories;
import mioga.entites.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


@Repository       // mechanism to access data in the database
public interface UserRepository extends CrudRepository<User,Integer>,JpaRepository<User,Integer>,PagingAndSortingRepository<User,Integer>,JpaSpecificationExecutor<User>{

    User findUserEntityById(int id);
}