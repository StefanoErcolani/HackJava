package id.aulab;

import java.math.BigInteger;
import java.util.List;

public interface InterfaceDao<T> {
    
    public int count();
    public List<T> getData();
    public T getOne(BigInteger id);
    public boolean insert(T model);
    public boolean update(BigInteger id, T model);
    public boolean delete(BigInteger id);
}
