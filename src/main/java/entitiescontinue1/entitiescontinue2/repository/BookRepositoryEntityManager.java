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
public class BookRepositoryEntityManager {

    private final EntityManager entityManager;


    @Autowired
    public BookRepositoryEntityManager(EntityManager entityManager){
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

    public Book delete(Long id) {
        Book book = findById(id);
        if (book != null) {
            entityManager.remove(book);
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
    /**
     * Entity manager keep tracking of entities
     * @param name
     */
    public void createAndUpdate(String name) {
        Book book = new Book(name);
        entityManager.persist(book);
        book.setName("Jazz Harmony");
    }

    /**
     * Entity manager detach object
     */
    public void createDetach() {
        Book book1 = new Book("Goku Food Recipes");
        entityManager.persist(book1);
        entityManager.flush();
        entityManager.detach(book1);
//        entityManager.clear(); all entities manager keep tracking
        book1.setName("Still Goku");

    }

    /**
     * Clear all entities from manager
     */
    public void createClear() {
        Book book1 = new Book("book1");
        Book book2 = new Book("book2");
        entityManager.persist(book1);
        entityManager.persist(book2);

        entityManager.flush();

        book1.setName("bk1");
        entityManager.flush();

        book2.setName("bk2");
        entityManager.clear();

    }

    /**
     * Refresh data from data base
     */
    public void createRefresh() {
        Book book1 = new Book("bookA");
        Book book2 = new Book("bookB");
        entityManager.persist(book1);
        entityManager.persist(book2);

        entityManager.flush();

        book1.setName("bkA");
        book2.setName("bkB");
        book1.setName("yossi");
        entityManager.refresh(book1);


    }
}

