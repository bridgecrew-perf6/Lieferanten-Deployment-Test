package mioga.repositories;
import mioga.entites.Actions;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


@Repository       // mechanism to access data in the database
public interface ActionsRepository extends CrudRepository<Actions,Long>,JpaRepository<Actions,Long>,PagingAndSortingRepository<Actions,Long>,JpaSpecificationExecutor<Actions>{

    Actions findActionsEntityById(int id);
}