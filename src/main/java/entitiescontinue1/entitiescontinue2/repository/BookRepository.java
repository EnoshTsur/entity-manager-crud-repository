package entitiescontinue1.entitiescontinue2.repository;

import entitiescontinue1.entitiescontinue2.beans.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookRepository {


    private EntityManager entityManager;

    @Autowired
    public BookRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public Book save(Book book) {
        if (book.getId() == null) {
            entityManager.persist(book);
        } else {
            entityManager.merge(book);
        }
        return book;
    }

    public Book findById(Long id) {
        return entityManager.find(Book.class, id);
    }

    public Book findByName(String name) {
        TypedQuery<Book> byName = entityManager
                .createQuery("select b from Book b where b.name = :name", Book.class);
        return byName.setParameter("name", name).getSingleResult();
    }


    public List<Book> findAll() {
        TypedQuery<Book> all = entityManager.
                createQuery("select b from Book b", Book.class);
        return all.getResultList();
    }


    public Book findByNameNative(String name) {
        Query byName =  entityManager
                .createNativeQuery("select * from Book where name = :name", Book.class)
                .setParameter("name", name);
        return (Book) byName.getSingleResult();
    }


    public List<Book> findAllNamed() {
        return entityManager.createNamedQuery("find_all", Book.class)
                .getResultList();
    }

    public Book findHarry(){
        return entityManager.createNamedQuery("find_harry_potter", Book.class)
                .getSingleResult();
    }
}

