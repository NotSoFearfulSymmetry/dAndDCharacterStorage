package controller;

import entity.Character;
import persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.DaoFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * A servlet for displaying a user's characters.
 */
@WebServlet(name = "ViewCharacters", urlPatterns = { "/viewCharacters" } )
public class ViewCharacters extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * This method handles get actions.
     * @param req the request
     * @param resp the response
     * @throws ServletException if a servlet exception is thrown
     * @throws IOException if an input/output exception is thrown
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        GenericDao dao = DaoFactory.createDao(Character.class);
        List<Character> characters = dao.getAll();
        req.setAttribute("characters", characters);
        logger.debug("Sending back the character/s..." + characters);

        System.out.println("One ring to rule them all");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/viewCharacters" +
                ".jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
