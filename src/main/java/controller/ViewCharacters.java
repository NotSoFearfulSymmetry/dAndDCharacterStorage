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

@WebServlet(name = "ViewCharacters", urlPatterns = { "/viewCharacters" } )

public class ViewCharacters extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        GenericDao dao = DaoFactory.createDao(Character.class);
//        GenericDao dao = new GenericDao(Character.class);
        List<Character> characters = dao.getAll();
        req.setAttribute("characters", characters);
        logger.debug("Sending back the character/s..." + characters);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/viewCharacters" +
                ".jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
