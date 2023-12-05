package model.dao;

import java.util.List;

import model.ModelException;
import model.User;

public interface UserDAO {
	boolean save(User post) throws ModelException ;
	boolean update(User post) throws ModelException;
	boolean delete(User post) throws ModelException;
	List<User> listAll() throws ModelException;
	User findById(int id) throws ModelException;
}
