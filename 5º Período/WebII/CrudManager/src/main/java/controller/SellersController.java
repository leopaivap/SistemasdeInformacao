package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ModelException;
import model.Seller;
import model.dao.DAOFactory;
import model.dao.SellerDAO;

@WebServlet(urlPatterns = { "/sellers", "/seller/form", "/seller/insert" })
public class SellersController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getRequestURI();

		switch (action) {
		case "/crud-manager/seller/form": {
			
			ControllerUtil.forward(req, resp, "/form-seller.jsp");
			break;
		}
		default:
			listSellers(req);

			ControllerUtil.transferSessionMessagesToRequest(req);

			ControllerUtil.forward(req, resp, "sellers.jsp");
		}
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
}
