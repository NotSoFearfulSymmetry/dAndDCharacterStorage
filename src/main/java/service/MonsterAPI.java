package service;

import entity.Monster;

import javax.ws.rs.*;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A class to retrieve information about monsters from the D&D API.
 */
@Path("/monsterAPI")
public class MonsterAPI {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Gets monsters.
     * @param challengeRating  the challenge rating
     * @return the monsters
     */
    @Path("/{challenge_rating}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMonsters(
            @PathParam("challenge_rating") String challengeRating) throws NullPointerException {

        String url = "https://www.dnd5eapi.co/api/monsters?challenge_rating=" + challengeRating;

        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target(url);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        Monster monster = new Monster();
        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writeValueAsString(Monster.toString());
        } catch (JsonProcessingException e) {
            logger.error("JSON processing exception: " + e);
        }

        return Response.status(200).entity(json).build();
    }
}