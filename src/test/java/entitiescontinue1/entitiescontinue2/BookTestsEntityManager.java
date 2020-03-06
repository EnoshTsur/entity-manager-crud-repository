package entitiescontinue1.entitiescontinue2;

import entitiescontinue1.entitiescontinue2.beans.Book;
import entitiescontinue1.entitiescontinue2.repository.BookRepositoryEntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest
@ActiveProfiles(profiles = "dev")
class BookTestsEntityManager {

    @Autowired
    private BookRepositoryEntityManager repository;

    @Test
    void contextLoads() { }

    @Test
    void createBook(){
//        Book book = repository.save(new Book("to delete"));
//        System.out.println(book);
    }

    @Test
    void update(){
//         repository.save(new Book(2L, "Matrix"));
    }

    @Test
    void findById(){
        Book book = repository.findById(2L);
        System.out.println(book);
    }

    @Test
    void findByName(){
        Book book = repository.findByName("harry potter");
        System.out.println(book);
    }

    @Test
    void findAllTypedQuery(){
        List<Book> books = repository.findAll();
        books.forEach(System.out::println);
    }

    @Test
    void findByNameNative(){
        System.out.println(repository.findByNameNative("Matrix"));
    }

    @Test
    void finAllNamedQuery(){
        System.out.println(repository.findAllNamed());
    }

    @Test
    void findHarry(){
        System.out.println(repository.findHarry());
    }

    @Test
    void delete(){
//        Book book = repository.delete(2L);
//        System.out.println(book);
    }

    @Test
    void playground(){
//        repository.createAndUpdate("Keif ba Luna Park");
    }

    @Test
    void gokuDetach(){
//        repository.createDetach();
    }

    @Test
    void clearDetach(){
//        repository.createClear();
    }

    @Test
    void refresh(){
        repository.createRefresh();
    }

}
