package Model;

import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDAO <T> {
 
	public abstract int doSave(T entity) throws SQLException;

	public abstract T doRetrieveByKey(String key) throws SQLException;
	
	public abstract List<T> doRetrieveAll() throws SQLException;

	public abstract boolean doUpdate(T entity) throws SQLException;

	public abstract boolean doDelete(T key) throws SQLException;
}
