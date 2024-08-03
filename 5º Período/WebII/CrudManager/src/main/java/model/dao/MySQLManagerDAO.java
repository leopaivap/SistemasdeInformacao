package model.dao;

import java.util.ArrayList;
import java.util.List;

import model.Company;
import model.Manager;
import model.ModelException;
import model.Seller;

public class MySQLManagerDAO implements ManagerDAO {

	@Override
	public boolean save(Manager manager) throws ModelException {

		DBHandler db = new DBHandler();

		String sqlInsert = "INSERT INTO managers VALUES (DEFAULT, ?, ? ,? ,?, ?)";

		db.prepareStatement(sqlInsert);

		db.setString(1, manager.getName());
		db.setString(2, manager.getEmail());
		db.setString(3, manager.getFone());
		db.setString(4, manager.getGender());
		db.setInt(5, manager.getCompany().getId());

		return db.executeUpdate() > 0;
	}

	@Override
	public boolean update(Manager manager) throws ModelException {

		DBHandler db = new DBHandler();

		String sqlUpdate = "UPDATE managers SET name = ?, email = ?, fone = ?, sexo = ?,company_id = ? where id = ?";

		db.prepareStatement(sqlUpdate);

		db.setString(1, manager.getName());
		db.setString(2, manager.getEmail());
		db.setString(3, manager.getFone());
		db.setString(4, manager.getGender());
		db.setInt(5, manager.getCompany().getId());
		db.setInt(6, manager.getId());

		return db.executeUpdate() > 0;
	}

	@Override
	public boolean delete(Manager manager) throws ModelException {
		DBHandler db = new DBHandler();

		String sqlDelete = " DELETE FROM managers WHERE id = ?";

		db.prepareStatement(sqlDelete);
		db.setInt(1, manager.getId());

		return db.executeUpdate() > 0;
	}

	@Override
	public List<Manager> listAll() throws ModelException {

		DBHandler db = new DBHandler();

		List<Manager> managers = new ArrayList<Manager>();

		// Declara uma instrução SQL
		String sqlQuery = "SELECT m.id as id, m.name as Nome, m.email as Email, m.fone as Fone, m.sexo as Sexo, c.id as company_id from managers m inner join companies c on m.company_id = c.id;";

		db.createStatement();

		db.executeQuery(sqlQuery);

		while (db.next()) {
			Manager m = createSeller(db);

			managers.add(m);
		}

		return managers;
	}

	@Override
	public Manager findById(int id) throws ModelException {

		DBHandler db = new DBHandler();

		String sql = "SELECT * FROM managers WHERE id = ?";

		db.prepareStatement(sql);

		db.setInt(1, id);
		db.executeQuery();

		Manager m = null;

		while (db.next()) {
			m = createSeller(db);
			break;
		}

		return m;
	}

	private Manager createSeller(DBHandler db) throws ModelException {
		Manager m = new Manager(db.getInt("id"));
		m.setName(db.getString("nome"));
		m.setEmail(db.getString("email"));
		m.setFone(db.getString("fone"));
		m.setGender(db.getString("sexo"));

		CompanyDAO companyDAO = DAOFactory.createDAO(CompanyDAO.class);

		Company company = companyDAO.findById(db.getInt("company_id"));

		m.setCompany(company);

		return m;
	}

}
