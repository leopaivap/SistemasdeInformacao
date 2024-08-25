package model.dao;

import java.util.List;

import model.ModelException;
import model.Company;

public interface CompanyDAO {
	boolean save(Company company) throws ModelException;
	boolean update(Company company) throws ModelException;
	boolean delete(Company company) throws ModelException;
	List<Company> listAll() throws ModelException;
	Company findById(int id) throws ModelException;
}
