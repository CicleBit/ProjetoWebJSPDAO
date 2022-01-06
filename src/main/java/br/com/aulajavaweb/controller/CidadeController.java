package br.com.aulajavaweb.controller;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import br.com.aulajavaweb.dao.CidadeDao;
import br.com.aulajavaweb.dao.CidadeDaoImpl;
import br.com.aulajavaweb.model.Cidade;

public class CidadeController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	RequestDispatcher dispatcher = null;
	CidadeDao cidadeDao = null;

	public CidadeController() {
		cidadeDao = new CidadeDaoImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action == null) {
			action = "LIST";
		}

		switch (action) {

		case "LIST":
			listCidade(request, response);
			break;

		case "EDIT":
			getSingleCidade(request, response);
			break;

		case "DELETE":
			deleteCidade(request, response);
			break;

		default:
			listCidade(request, response);
			break;

		}

	}

	private void deleteCidade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");

		if (cidadeDao.delete(Integer.parseInt(id))) {
			request.setAttribute("NOTIFICATION", "Employee Deleted Successfully!");
		}

		listCidade(request, response);
	}

	private void getSingleCidade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");

		Cidade theCidade = cidadeDao.get(Integer.parseInt(id));

		request.setAttribute("cidade", theCidade);

		dispatcher = request.getRequestDispatcher("/views/Cidade-Edit.jsp");

		dispatcher.forward(request, response);
	}

	private void listCidade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Cidade> theList = cidadeDao.get();

		request.setAttribute("list", theList);

		dispatcher = request.getRequestDispatcher("/views/Cidade-List.jsp");

		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");

		Cidade c = new Cidade();
		c.setCidade(request.getParameter("cidade"));
		c.setEstado(request.getParameter("estado"));

		if (id.isEmpty() || id == null) {

			if (cidadeDao.save(c)) {
				request.setAttribute("NOTIFICATION", "Cidade Saved Successfully!");
			}

		} else {
			c.setId(Integer.parseInt(id));
			if (cidadeDao.update(c)) {
				request.setAttribute("NOTIFICATION", "Cidade Updated Successfully!");
			}

		}

		listCidade(request, response);
	}

}
