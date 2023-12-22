package java.data.dao;

public interface BaseDao<T> {

    boolean create(T item);

    boolean update(T item);

    boolean delete(T item);
}