package service;

import entity.Monster;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * A class to retrieve information about monsters from the D&D API.
 */
@WebServlet(urlPatterns = {"/getMonsters"})
//@Path("/monsterAPI")
public class MonsterAPI extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Gets a list of monsters of a given challenge rating.
     * @param req the request
     * @param resp the response
     * @throws ServletException if there's a servlet exception
     * @throws IOException if there's an input/output exception
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String challengeRating = req.getParameter("challengeRating");

        req.setAttribute("challengeRating", challengeRating);
        String url = "https://www.dnd5eapi.co/api/monsters?challenge_rating=" + challengeRating;
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);

        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

//        Monster monster = new Monster();
//        ObjectMapper mapper = new ObjectMapper();
//        String json = null;
//
//        try {
//            json = mapper.writeValueAsString(monster);
//        } catch (JsonProcessingException e) {
//            logger.error("JSON processing exception: " + e);
//        }
//
//        return Response.status(200).entity(json).build();

        RequestDispatcher dispatcher = req.getRequestDispatcher("/showMonsters.jsp");
        dispatcher.forward(req, resp);
    }
}