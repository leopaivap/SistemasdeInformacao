package model.dao;

import java.util.List;

import model.ModelException;
import model.Seller;

public interface SellerDAO {

	boolean save(Seller seller) throws ModelException;

	boolean update(Seller seller) throws ModelException;

	boolean delete(Seller seller) throws ModelException;

	List<Seller> listAll() throws ModelException;

	Seller findById(int id) throws ModelException;

}
