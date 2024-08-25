package model.dao;

import java.util.List;

import model.Manager;
import model.ModelException;

public interface ManagerDAO {

	boolean save(Manager manager) throws ModelException;

	boolean update(Manager manager) throws ModelException;

	boolean delete(Manager manager) throws ModelException;

	List<Manager> listAll() throws ModelException;

	Manager findById(int id) throws ModelException;
}
