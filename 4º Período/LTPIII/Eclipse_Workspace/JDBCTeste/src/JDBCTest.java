import model.ModelException;
import model.User;
import model.dao.MySQLUserDAO;
import model.dao.UserDAO;

public class JDBCTest {

	public static void main(String[] args) throws ModelException {
		User leo = new User();
		leo.setName("leo lindo");
		leo.setGender("M");
		leo.setEmail("leo@email.com");

		// utilizar do lado esquerdo classes abstratas
		UserDAO userDAO = new MySQLUserDAO();
		userDAO.save(leo);
	}
}
