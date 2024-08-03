package controller;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Company;
import model.Manager;
import model.ModelException;
import model.dao.CompanyDAO;
import model.dao.DAOFactory;
import model.dao.ManagerDAO;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/managers", "/manager/form", "/manager/insert", "/manager/update", "/manager/delete" })
public class ManagersController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getRequestURI();

		switch (action) {
		case "/crud-manager/manager/form": {
			loadCompanies(req);
			req.setAttribute("action", "insert");
			ControllerUtil.forward(req, resp, "/form-manager.jsp");
			break;
		}
		case "/crud-manager/manager/update": {
			loadManager(req);
			loadCompanies(req);
			req.setAttribute("action", "update");
			ControllerUtil.forward(req, resp, "/form-manager.jsp");
			break;
		}
		default:
			listManagers(req);

			ControllerUtil.transferSessionMessagesToRequest(req);

			ControllerUtil.forward(req, resp, "/managers.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getRequestURI();

		switch (action) {
		case "/crud-manager/manager/insert": {
			insertManager(req);
			ControllerUtil.redirect(resp, req.getContextPath() + "/managers");
			break;
		}
		case "/crud-manager/manager/update": {
			updateManager(req);
			ControllerUtil.redirect(resp, req.getContextPath() + "/managers");
			break;
		}
		case "/crud-manager/manager/delete": {
			deleteManager(req, resp);
			ControllerUtil.redirect(resp, req.getContextPath() + "/managers");
			break;
		}

		default:
			throw new IllegalArgumentException("Unexpected value: " + action);
		}
	}

	private void deleteManager(HttpServletRequest req, HttpServletResponse resp) {

		String managerIdParameter = req.getParameter("id");

		int managerId = Integer.parseInt(managerIdParameter);

		ManagerDAO dao = DAOFactory.createDAO(ManagerDAO.class);

		try {
			Manager manager = dao.findById(managerId);

			if (manager == null)
				throw new ModelException("Gerente não encontrado para deleção.");

			if (dao.delete(manager)) {
				ControllerUtil.sucessMessage(req, "Gerente '" + manager.getName() + "' deletado com sucesso.");
			} else {
				ControllerUtil.errorMessage(req,
						"Gerente '" + manager.getName() + "' não pode ser deletado. Há dados relacionados ao gerente.");
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

	private void insertManager(HttpServletRequest req) {

		Manager manager = createManager(req, 0);

		ManagerDAO dao = DAOFactory.createDAO(ManagerDAO.class);

		try {
			if (dao.save(manager))
				ControllerUtil.sucessMessage(req, "Gerente" + manager.getName() + " salvo com sucesso.");
			else
				ControllerUtil.errorMessage(req, "Gerente " + manager.getName() + " não pode ser salvo.");
		} catch (ModelException e) {
			e.printStackTrace(); // log
			ControllerUtil.errorMessage(req, e.getMessage());
		}
	}

	private void updateManager(HttpServletRequest req) {

		String managerIdStr = req.getParameter("managerId");
		int managerId = Integer.parseInt(managerIdStr);

		Manager manager = createManager(req, managerId);

		ManagerDAO dao = DAOFactory.createDAO(ManagerDAO.class);

		try {
			if (dao.update(manager))
				ControllerUtil.sucessMessage(req, "Gerente " + manager.getName() + " alterado com sucesso.");
			else
				ControllerUtil.errorMessage(req, "Gerente " + manager.getName() + " não pode ser alterado.");
		} catch (ModelException e) {
			e.printStackTrace(); // log
			ControllerUtil.errorMessage(req, e.getMessage());
		
	}

	}

	private void loadManager(HttpServletRequest req) {
		String managerIdStr = req.getParameter("managerId");
		int managerId = Integer.parseInt(managerIdStr);

		ManagerDAO dao = DAOFactory.createDAO(ManagerDAO.class);

		Manager manager = new Manager(0);

		try {
			manager = dao.findById(managerId);
		} catch (ModelException e) {
			ControllerUtil.errorMessage(req, "Erro ao carregar gerente para edição.");
		}

		req.setAttribute("managerToEdit", manager);
	}

	private void loadCompanies(HttpServletRequest req) {
		CompanyDAO dao = DAOFactory.createDAO(CompanyDAO.class);
		List<Company> companies = new ArrayList<>();
		try {
			companies = dao.listAll();
		} catch (ModelException e) {
			ControllerUtil.errorMessage(req, "Erro ao carregar as empresas.");
		}
		req.setAttribute("companies", companies);
	}

	private void listManagers(HttpServletRequest req) {

		ManagerDAO dao = DAOFactory.createDAO(ManagerDAO.class);

		List<Manager> managers = new ArrayList<>();

		try {
			managers = dao.listAll();
		} catch (ModelException e) {
			ControllerUtil.errorMessage(req, "Erro ao carregar dados dos gerentes.");
		}

		req.setAttribute("managers", managers);
	}

	private Manager createManager(HttpServletRequest req, int managerId) {

		String managerName = req.getParameter("manager-name");
		String managerEmail = req.getParameter("manager-email");
		String managerFone = req.getParameter("manager-fone");
		String managerSexo = req.getParameter("manager-sexo");
		String managerCompany = req.getParameter("manager-company");
		int managerCompanyId = Integer.parseInt(managerCompany);

		Manager manager;
		if (managerId == 0) {
			manager = new Manager();
		} else {
			manager = new Manager(managerId);
		}
		manager.setName(managerName);
		manager.setEmail(managerEmail);
		manager.setFone(managerFone);
		manager.setGender(managerSexo);
		manager.setCompany(new Company(managerCompanyId));

		return manager;
	}

}
