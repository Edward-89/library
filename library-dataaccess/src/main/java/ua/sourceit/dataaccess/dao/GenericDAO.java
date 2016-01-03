package ua.sourceit.dataaccess.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<K extends Serializable, T> 
{
    public T findById(K id);
    public List<T> findAll();
    public K save(T value);
    public K update(T value);
    public K delete(T value);
}