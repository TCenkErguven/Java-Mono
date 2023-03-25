package com.monolith.utility;

import java.util.List;
import java.util.Optional;

public interface Iservice<T,ID>{
    T save(T t);
    Optional<T> findById(ID id);
    List<T> findAll();

}
