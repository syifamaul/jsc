package com.maul.jsc.dao;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maul.jsc.models.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
//	public List<Book> findByNameContaining(String bookName);
}
