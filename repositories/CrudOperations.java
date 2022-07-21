package courseworke3.repositories;

import java.util.List;

public interface CrudOperations <E>{
    E add (E e);
    void remove(Integer id);
    E findById (Integer id);
    List <E> findAll ();

}
