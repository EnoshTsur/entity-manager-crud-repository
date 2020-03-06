package entitiescontinue1.entitiescontinue2.repository;

import entitiescontinue1.entitiescontinue2.beans.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface BookRepository extends CrudRepository<Book, Long> {

    Optional<Book> findByName(String name);

    @Modifying
    @Query("update BookOld b set b.name = :name where b.id = :id")
    void update(@Param("name") String name, @Param("id") Long id);
}
