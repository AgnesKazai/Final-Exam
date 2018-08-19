package com.greenfoxcompany.connectionwithmysql.repositories;

import com.greenfoxcompany.connectionwithmysql.models.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {

    List<Todo> findByDoneFalse();

    List<Todo> findByDoneTrue();
}
