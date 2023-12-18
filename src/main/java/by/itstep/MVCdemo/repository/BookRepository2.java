package by.itstep.MVCdemo.repository;

import by.itstep.MVCdemo.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository2 extends CrudRepository<Book, Integer> {

}
