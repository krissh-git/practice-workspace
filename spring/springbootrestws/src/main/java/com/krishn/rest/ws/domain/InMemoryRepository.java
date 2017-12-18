package com.krishn.rest.ws.domain;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public abstract class InMemoryRepository<T extends Identifiable> {

    @Autowired
    private IdGenerator idGenerator;

    private List<T> elements = Collections.synchronizedList(new ArrayList<>());


    protected T create(T t) {
        t.setId(idGenerator.getId());
        elements.add(t);
        return t;
    }

    protected List<T> findAll() {
        return elements;
    }

    protected Optional<T> findById(Long id) {
        return elements.stream().filter(t -> t.getId().equals(id)).findFirst();
    }


    protected boolean delete(Long id) {
        return elements.removeIf(t -> t.getId().equals(id));
    }

    protected boolean update(Long id, T t) {
        if (t == null) {
            return false;
        }

        final Optional<T> t1 = findById(id);
        t1.ifPresent(t2 -> updateIfExists(t2, t));
        return t1.isPresent();
    }

    protected abstract void updateIfExists(T original, T updated);


}
