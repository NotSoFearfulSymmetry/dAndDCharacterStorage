package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Monster;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * A servlet for handling the monster API.
 */
@WebServlet(name = "getMonsters", urlPatterns = "/getMonsters")
public class MonsterAPI extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Thiis method handles get actions.
     * @param req the request
     * @param res the response
     * @throws IOException if an input/output exception occurs
     * @throws ServletException if a servlet exception occurs
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://www.dnd5eapi.co/api/monsters/adult-black-dragon/");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();

        try {
            Monster sampleMonster = mapper.readValue(response, Monster.class);
        } catch (JsonProcessingException jse) {
            logger.error("JSON processing exception", jse);
        }

        String url = "/showMonsters.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, res);

    }
}