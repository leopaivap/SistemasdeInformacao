package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ModelException;
import model.User;
import model.dao.DAOFactory;
import model.dao.UserDAO;

import java.sql.SQLIntegrityConstraintViolationException;

@WebServlet(urlPatterns = {"/users", "/user/form", "/user/delete", "/user/insert", "/user/update"})
public class UsersController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getRequestURI();
		
		switch (action) {
		case "/crud-manager/user/form": {
			listUsers(req);
			req.setAttribute("action", "insert");
			ControllerUtil.forward(req, resp, "/form-user.jsp");
			break;
		}
		case "/crud-manager/user/update": {
			listUsers(req);
			User user = loadUser(req);
			req.setAttribute("user", user);
			req.setAttribute("action", "update");
			ControllerUtil.forward(req, resp, "/form-user.jsp");
			break;
		}
		default:
			listUsers(req);
			
			ControllerUtil.transferSessionMessagesToRequest(req);
		
			ControllerUtil.forward(req, resp, "/users.jsp");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getRequestURI();
		
		if (action == null || action.equals("") ) {
			ControllerUtil.forward(req, resp, "/index.jsp");
			return;
		}
		
		switch (action) {
		case "/crud-manager/user/delete":
			deleteUser(req, resp);
			break;	
		case "/crud-manager/user/insert": {
			insertUser(req, resp);
			break;
		}
		case "/crud-manager/user/update": {
			updateUser(req, resp);
			break;
		}
		default:
			System.out.println("URL inválida " + action);
			break;
		}
			
		ControllerUtil.redirect(resp, req.getContextPath() + "/users");
	}

	private User loadUser(HttpServletRequest req) {
		String userIdParameter = req.getParameter("userId");
		
		int userId = Integer.parseInt(userIdParameter);
		
		UserDAO dao = DAOFactory.createDAO(UserDAO.class);
		
		try {
			User user = dao.findById(userId);
			
			if (user == null)
				throw new ModelException("Usuário não encontrado para alteração");
			
			return user;
		} catch (ModelException e) {
			// log no servidor
			e.printStackTrace();
			ControllerUtil.errorMessage(req, e.getMessage());
		}
		
		return null;
	}
	
	private void listUsers(HttpServletRequest req) {
		UserDAO dao = DAOFactory.createDAO(UserDAO.class);
		
		List<User> users = null;
		try {
			users = dao.listAll();
		} catch (ModelException e) {
			// Log no servidor
			e.printStackTrace();
		}
		
		if (users != null)
			req.setAttribute("users", users);
	}
	
	private void insertUser(HttpServletRequest req, HttpServletResponse resp) {
		String userName = req.getParameter("name");
		String userGender = req.getParameter("gender");
		String userEMail = req.getParameter("mail");
		
		User user = new User();
		user.setName(userName);
		user.setGender(userGender);
		user.setEmail(userEMail);
		
		UserDAO dao = DAOFactory.createDAO(UserDAO.class);
		
		try {
			if (dao.save(user)) {
				ControllerUtil.sucessMessage(req, "Usuário '" + user.getName() + "' salvo com sucesso.");
			}
			else {
				ControllerUtil.errorMessage(req, "Usuário '" + user.getName() + "' não pode ser salvo.");
			}
				
		} catch (ModelException e) {
			// log no servidor
			e.printStackTrace();
			ControllerUtil.errorMessage(req, e.getMessage());
		}
	}
	
	private void updateUser(HttpServletRequest req, HttpServletResponse resp) {
		String userName = req.getParameter("name");
		String userGender = req.getParameter("gender");
		String userEMail = req.getParameter("mail");
		
		User user = loadUser(req);
		user.setName(userName);
		user.setGender(userGender);
		user.setEmail(userEMail);
		
		UserDAO dao = DAOFactory.createDAO(UserDAO.class);
		
		try {
			if (dao.update(user)) {
				ControllerUtil.sucessMessage(req, "Usuário '" + user.getName() + "' atualizado com sucesso.");
			}
			else {
				ControllerUtil.errorMessage(req, "Usuário '" + user.getName() + "' não pode ser atualizado.");
			}
				
		} catch (ModelException e) {
			// log no servidor
			e.printStackTrace();
			ControllerUtil.errorMessage(req, e.getMessage());
		}
	}
	
	private void deleteUser(HttpServletRequest req, HttpServletResponse resp) {
		String userIdParameter = req.getParameter("id");
		
		int userId = Integer.parseInt(userIdParameter);
		
		UserDAO dao = DAOFactory.createDAO(UserDAO.class);
		
		try {
			User user = dao.findById(userId);
			
			if (user == null)
				throw new ModelException("Usuário não encontrado para deleção.");
			
			if (dao.delete(user)) {
				ControllerUtil.sucessMessage(req, "Usuário '" + user.getName() + "' deletado com sucesso.");
			}
			else {
				ControllerUtil.errorMessage(req, "Usuário '" + user.getName() + "' não pode ser deletado. Há dados relacionados ao usuário.");
			}
		} catch (ModelException e) {
			// log no servidor
			if (e.getCause() instanceof SQLIntegrityConstraintViolationException) {
				ControllerUtil.errorMessage(req, e.getMessage());
			}
			e.printStackTrace();
			ControllerUtil.errorMessage(req, e.getMessage());
		}
	}
}
