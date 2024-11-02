package com.kevinpina.repositories;

import java.util.List;

public interface CrudRepository <T> {

    List<T> list();
    T findBy(Long id);

}
