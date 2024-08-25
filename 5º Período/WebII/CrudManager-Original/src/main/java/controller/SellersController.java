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
import model.ModelException;
import model.Seller;
import model.User;
import model.dao.CompanyDAO;
import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.dao.UserDAO;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/sellers", "/seller/form", "/seller/insert", "/seller/update", "/seller/delete" })
public class SellersController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getRequestURI();

		switch (action) {
		case "/crud-manager/seller/form": {
			loadCompanies(req);
			req.setAttribute("action", "insert");
			ControllerUtil.forward(req, resp, "/form-seller.jsp");
			break;
		}
		case "/crud-manager/seller/update": {
			loadSeller(req);
			loadCompanies(req);
			req.setAttribute("action", "update");
			ControllerUtil.forward(req, resp, "/form-seller.jsp");
			break;
		}
		default:
			listSellers(req);

			ControllerUtil.transferSessionMessagesToRequest(req);

			ControllerUtil.forward(req, resp, "/sellers.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getRequestURI();

		switch (action) {
		case "/crud-manager/seller/insert": {
			insertSeller(req);
			ControllerUtil.redirect(resp, req.getContextPath() + "/sellers");
			break;
		}
		case "/crud-manager/seller/update": {
			updateSeller(req);
			ControllerUtil.redirect(resp, req.getContextPath() + "/sellers");
			break;
		}
		case "/crud-manager/seller/delete": {
			deleteSeller(req, resp);
			ControllerUtil.redirect(resp, req.getContextPath() + "/sellers");
			break;
		}

		default:
			throw new IllegalArgumentException("Unexpected value: " + action);
		}
	}

	private void deleteSeller(HttpServletRequest req, HttpServletResponse resp) {

		String sellerIdParameter = req.getParameter("id");

		int sellerId = Integer.parseInt(sellerIdParameter);

		SellerDAO dao = DAOFactory.createDAO(SellerDAO.class);

		try {
			Seller seller = dao.findById(sellerId);

			if (seller == null)
				throw new ModelException("Vendedor não encontrado para deleção.");

			if (dao.delete(seller)) {
				ControllerUtil.sucessMessage(req, "Vendedor '" + seller.getName() + "' deletado com sucesso.");
			} else {
				ControllerUtil.errorMessage(req, "Vendedor '" + seller.getName()
						+ "' não pode ser deletado. Há dados relacionados ao vendedor.");
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

	private void insertSeller(HttpServletRequest req) {

		Seller seller = createSeller(req, 0);

		SellerDAO dao = DAOFactory.createDAO(SellerDAO.class);

		try {
			if (dao.save(seller))
				ControllerUtil.sucessMessage(req, "Vendedor " + seller.getName() + " salvo com sucesso.");
			else
				ControllerUtil.errorMessage(req, "Vendedor " + seller.getName() + " não pode ser salvo.");
		} catch (ModelException e) {
			e.printStackTrace(); // log
			ControllerUtil.errorMessage(req, e.getMessage());
		}
	}

	private void updateSeller(HttpServletRequest req) {

		String sellerIdStr = req.getParameter("seller_id");
		int sellerId = Integer.parseInt(sellerIdStr);

		Seller seller = createSeller(req, sellerId);

		SellerDAO dao = DAOFactory.createDAO(SellerDAO.class);

		try {
			if (dao.update(seller))
				ControllerUtil.sucessMessage(req, "Vendedor " + seller.getName() + " alterado com sucesso.");
			else
				ControllerUtil.errorMessage(req, "Vendedor " + seller.getName() + " não pode ser alterado.");
		} catch (ModelException e) {
			e.printStackTrace(); // log
			ControllerUtil.errorMessage(req, e.getMessage());
		}

	}

	private void loadSeller(HttpServletRequest req) {
		String sellerIdStr = req.getParameter("sellerId");
		int sellerId = Integer.parseInt(sellerIdStr);

		SellerDAO dao = DAOFactory.createDAO(SellerDAO.class);

		Seller seller = new Seller(0);

		try {
			seller = dao.findById(sellerId);
		} catch (ModelException e) {
			ControllerUtil.errorMessage(req, "Erro ao carregar vendedor para edição.");
		}

		req.setAttribute("sellerToEdit", seller);
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

	private void listSellers(HttpServletRequest req) {

		SellerDAO dao = DAOFactory.createDAO(SellerDAO.class);

		List<Seller> sellers = new ArrayList<>();

		try {
			sellers = dao.listAll();
		} catch (ModelException e) {
			ControllerUtil.errorMessage(req, "Erro ao carregar dados dos vendedores.");
		}

		req.setAttribute("sellers", sellers);
	}

	private Seller createSeller(HttpServletRequest req, int sellerId) {

		String sellerName = req.getParameter("seller_name");
		String sellerEmail = req.getParameter("seller_email");
		String sellerFone = req.getParameter("seller_fone");
		String sellerCompany = req.getParameter("seller_company");
		int sellerCompanyId = Integer.parseInt(sellerCompany);

		Seller seller;
		if (sellerId == 0) {
			seller = new Seller();
		} else {
			seller = new Seller(sellerId);
		}
		seller.setName(sellerName);
		seller.setEmail(sellerEmail);
		seller.setFone(sellerFone);
		seller.setCompany(new Company(sellerCompanyId));

		return seller;
	}

}
