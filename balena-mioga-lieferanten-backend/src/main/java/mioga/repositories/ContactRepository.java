
package mioga.repositories;
import mioga.entites.Contacts;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;



@Repository
public interface ContactRepository extends CrudRepository<Contacts,Integer>,JpaRepository<Contacts, Integer>,PagingAndSortingRepository<Contacts,Integer>,JpaSpecificationExecutor<Contacts>{

     Contacts findById(int id);



}