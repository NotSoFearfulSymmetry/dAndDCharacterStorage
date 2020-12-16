package controller;

import entity.Character;
import entity.User;
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

/**
 * A servlet for deleting a character.
 */
@WebServlet(name = "DeleteCharacter", urlPatterns = { "/deleteCharacter" } )
public class DeleteCharacter extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * This method handles post actions.
     * @param req the request
     * @param resp the response
     * @throws ServletException if a servlet exception is thrown
     * @throws IOException if an input/output exception is thrown
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Character character = new Character();
        character.setName(req.getParameter("name"));
        character.setRace(req.getParameter("race"));
        character.setGender(req.getParameter("gender"));
        character.setClassAndLevel(req.getParameter("classAndLevel"));

        character.setStrength(Integer.parseInt(req.getParameter("strength")));
        character.setDexterity(Integer.parseInt(req.getParameter("dexterity")));
        character.setConstitution(Integer.parseInt(req.getParameter("constitution")));
        character.setIntelligence(Integer.parseInt(req.getParameter("intelligence")));
        character.setWisdom(Integer.parseInt(req.getParameter("wisdom")));
        character.setCharisma(Integer.parseInt(req.getParameter("charisma")));
        character.setHitPoints(Integer.parseInt(req.getParameter("hitPoints")));

        character.setSkills(req.getParameter("skills"));
        character.setFeats(req.getParameter("feats"));
        character.setClassFeatures(req.getParameter("classFeatures"));
        character.setEquipment(req.getParameter("equipment"));
        character.setDescription(req.getParameter("description"));
        character.setBackground(req.getParameter("background"));
        character.setSecondUserAccess(Boolean.parseBoolean(req.getParameter("secondUserAccess")));
        character.setSecondUsername(req.getParameter("secondUsername"));

        GenericDao userDao = DaoFactory.createDao(User.class);
        User user = (User) userDao.getByPropertyEqual("username", req.getRemoteUser()).get(0);
        character.setUser(user);

        GenericDao characterDao = DaoFactory.createDao(Character.class);
        characterDao.delete(character);

        logger.debug("Deleting the character...");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/viewCharacters" +
                ".jsp");
        dispatcher.forward(req, resp);
    }
}