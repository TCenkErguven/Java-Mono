package com.monolith.utility;

import com.monolith.repository.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class ServiceManager<T,ID> implements Iservice<T,ID> {
    private final JpaRepository<T,ID> repository;
    public ServiceManager(JpaRepository<T,ID> repository){
        this.repository = repository;
    }

    @Override
    public T save(T t) {
        return repository.save(t);
    }

    @Override
    public Optional<T> findById(ID id) {
        Optional<T> result = repository.findById(id);
        if(result.isEmpty()){
            System.out.println("Search Error");
        }
        return result;
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }
}
