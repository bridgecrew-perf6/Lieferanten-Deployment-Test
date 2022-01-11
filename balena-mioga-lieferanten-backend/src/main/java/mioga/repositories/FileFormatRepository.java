package mioga.repositories;
import mioga.entites.Fileformat;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


@Repository
public interface FileFormatRepository extends CrudRepository<Fileformat,Integer>,JpaRepository<Fileformat,Integer>,PagingAndSortingRepository<Fileformat,Integer>,JpaSpecificationExecutor<Fileformat>{


    Fileformat findFileFormatEntityById(int id);
}