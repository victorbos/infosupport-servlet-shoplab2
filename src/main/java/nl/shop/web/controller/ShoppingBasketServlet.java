package nl.shop.web.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.shop.domain.Product;
import nl.shop.srv.ProductService;
import nl.shop.web.ShoppingBasket;

/**
 * Servlet implementation class ShoppingBasketServlet
 */
@WebServlet("/basket")
public class ShoppingBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String SHOPPINGBASKETATTR="shoppingBasket";

	@Inject
	ProductService productService;
 	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShoppingBasketServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Long productId= Long.valueOf(request.getParameter("productId"));
        Product product=productService.findProductById(productId);

        HttpSession httpSession=request.getSession();

        if (httpSession.getAttribute(SHOPPINGBASKETATTR) == null){
            httpSession.setAttribute(SHOPPINGBASKETATTR, new ShoppingBasket());
        }
        ShoppingBasket shoppingBasket= (ShoppingBasket) httpSession.getAttribute(SHOPPINGBASKETATTR);

        shoppingBasket.addProduct(product);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/shoppingbasket.jsp");
        requestDispatcher.forward(request,response);

		// Stappen:

		// Haal het productid uit het request, en haal op basis van het
		// productid het volledige product uit de productservice op.

		// controleer in de sessie of de shopping basket reeds bestaat
		// Zo niet, maak een nieuwe shoppingbasket aan en sla hem op in de
		// sessie.

		// voeg het product toe aan de basket (kijk in de shoppingBasket klasse
		// voor de juiste methode).

		// Redirect naar de basket pagina.

	}

}
