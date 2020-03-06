package entitiescontinue1.entitiescontinue2;

import entitiescontinue1.entitiescontinue2.beans.Book;
import entitiescontinue1.entitiescontinue2.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles(profiles = "dev")
class BookTestsCrudRepository {

    @Autowired
    private BookRepository repository;

    @Test
    void contextLoads() { }

    @Test
    void create(){
        Book book = new Book("The beauty of yarkoni");
        repository.save(book);
    }

    @Test
    void update(){
//        Book book = new Book(14L, "King of the jungle");
//        repository.save(book);
    }

    @Test
    void delete(){
//        repository.deleteById(14L);
    }

    @Test
    void findById(){
//        Optional<Book> maybe = repository.findById(1546543L);
//        if (maybe.isPresent()) {
//            System.out.println(maybe.get().getName());
//        }
    }

    @Test
    void deleteByObject(){
//        Optional<Book> t = repository.findById(13L);
//        if (t.isPresent()) {
//            repository.delete(t.get());
//        }
//        repository
//                .findById(15L)
//                .ifPresent(repository::delete);
    }


    @Test
    void findByName(){
//        repository.findByName("The beauty of yarkoni")
//                .ifPresent(System.out::println);
    }

    @Test
    void specialUpdate(){
        repository.update("The beauty of jaffa", 16L);
    }

}
