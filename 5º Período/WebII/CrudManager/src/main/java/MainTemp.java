import model.Company;
import model.ModelException;
import model.Seller;
import model.dao.DAOFactory;
import model.dao.MySQLSellerDAO;
import model.dao.SellerDAO;

public class MainTemp {

	public static void main(String[] args) {
		Seller s = new Seller(3);
		s.setName("leonardo");
		s.setEmail("EMAIL@MAIL.COM.br");
		s.setFone("515");
		s.setCompany(new Company(1));

		MySQLSellerDAO dao = DAOFactory.createDAO(SellerDAO.class);

		try {
			dao.update(s);
			//System.out.println(dao.findById(2));
			//dao.delete(dao.findById(2));
		} catch (ModelException e) {
			e.printStackTrace();
		}

	}

}
