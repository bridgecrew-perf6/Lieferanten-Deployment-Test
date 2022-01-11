package mioga.repositories;
import mioga.entites.BelongsTo;
import mioga.entites.Zulieferer;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


@Repository
public interface ZuliefererRepository extends CrudRepository<Zulieferer,Integer>,JpaRepository<Zulieferer,Integer>,PagingAndSortingRepository<Zulieferer,Integer>,JpaSpecificationExecutor<Zulieferer>{


    Zulieferer findZuliefererEntityById(int id );

    List<Zulieferer> findAllByBelongsTo(BelongsTo belongsTo);
}