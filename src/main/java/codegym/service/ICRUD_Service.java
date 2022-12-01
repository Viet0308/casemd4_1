package codegym.service;

import java.util.List;

public interface ICRUD_Service<E> {
    List<E> getAll();
    void save(E e);
    void delete(long id);
    E findById(long id);
}
