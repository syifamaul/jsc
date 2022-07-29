package com.maul.jsc.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.maul.jsc.models.Publisher;
@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long>{
//	public List<Book> findByNameContaining(String bookName);
}
