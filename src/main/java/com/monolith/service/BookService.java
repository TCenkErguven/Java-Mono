package com.monolith.service;

import com.monolith.dto.request.BookUpdateRequestDto;
import com.monolith.dto.response.FindAllByBookResponseDto;
import com.monolith.repository.IBookRepository;
import com.monolith.repository.entity.Book;
import com.monolith.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService extends ServiceManager<Book,Long> {
    private IBookRepository repository;

    public BookService(IBookRepository repository){
        super(repository);
        this.repository = repository;
    }
    public Book save(Book book){
        return repository.save(book);
    }
    public Optional<Book> findById(Long id){
        Optional<Book> result = repository.findById(id);
        if(result.isEmpty()){
            System.out.println("Search Error");
        }
        return result;
    }
    public List<Book> findAll(){
        return repository.findAll();
    }
    public List<FindAllByBookResponseDto> findAllBookByName(String name){
        List<FindAllByBookResponseDto> result = repository.findAllBookByName(name);
        return result;
    }
    public void update(BookUpdateRequestDto dto){
        Optional<Book> result = repository.findById(dto.getId());
        if(result.isPresent()){
            result.get().setPublisher(dto.getPublisher());
            result.get().setPrice(dto.getPrice());
            result.get().setPageNumber(dto.getPageNumber());
            result.get().setBookStock(dto.getBookStock());
            repository.save(result.get());
        }
    }

}
