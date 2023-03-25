package com.monolith.repository;

import com.monolith.dto.response.FindAllByBookResponseDto;
import com.monolith.repository.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {
    @Query("select new com.monolith.dto.response.FindAllByBookResponseDto(b.name,b.author,b.category,b.publisher,b.releaseDate,b.price,b.pageNumber)" +
            " from Book b where b.name like ?1%")
    List<FindAllByBookResponseDto> findAllBookByName(String name);
}
