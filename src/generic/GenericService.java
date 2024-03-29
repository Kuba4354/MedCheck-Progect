package generic;

import model.Department;

public interface GenericService<T> {
    T add(Long hospitalId, T t);

    void removeById(Long id);

    String upDateById(Long id, T t);
}
