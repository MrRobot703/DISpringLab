package com.lab.data.repository.api;

public interface CrudRepository<E> {

    boolean create(E e);

    E read(long id);

    boolean update(E e);

    boolean delete(E e);
}
