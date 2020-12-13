//package controller;
//
//import entity.Character;
//import persistence.GenericDao;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import util.DaoFactory;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet(name = "AddCharacter", urlPatterns = { "/addCharacter" } )
//
//public class AddCharacter extends HttpServlet {
//
//    private final Logger logger = LogManager.getLogger(this.getClass());
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        GenericDao<Character> dao = DaoFactory.createDao(Character.class);
//        int id = ; //TODO: get from viewCharacters.jsp
//        Character character = dao.getByPropertyEqual("id", id);
//        dao.insert(character);
//        req.setAttribute("character", character);
//        logger.debug("Sending back the character/s..." + character);
//
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/viewCharacters" +
//                ".jsp");
//        dispatcher.forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req, resp);
//    }
//}
