package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import entity.*;
import persistence.GenericDao;
import util.DaoFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A servlet for adding new users.
 */
@WebServlet(name = "AddUser", urlPatterns = { "/addUser" } )

public class AddUser extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * This method handles post actions.
     * @param req the request
     * @param resp the response
     * @throws ServletException if a servlet exception is thrown
     * @throws IOException if an input/output exception is thrown
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setUserName(req.getParameter("userName"));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        logger.debug("Adding User: " + user);
        Role role = new Role();
        role.setUser(user);
        role.setRoleName("roleName");
        user.addRole(role);

        GenericDao dao = DaoFactory.createDao(User.class);
        dao.insert(user);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/index" +
                ".jsp");
        dispatcher.forward(req, resp);
    }
}