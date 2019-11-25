import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.TwitterException;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.print.Book;
import java.util.List;

@Path("/api/1.0/twitter")
public class TwitterResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwitterResource.class);

    @POST
    @Path("/tweet")
    public Response postTweet(@QueryParam("message") String tweetMsg) throws TwitterException {
        if (StringUtils.isNotEmpty(tweetMsg)) {
            Tweet tweet = new Tweet();
            tweet.postTweet(tweetMsg);
            return Response.ok().build();
        }
        return Response.noContent().build();
    }

    @GET
    @Path("/timeline")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTimeline() throws TwitterException {

        TimeLine timeLine = new TimeLine();
        List<String> tweets = timeLine.getTimeLine();
        GenericEntity<List<String>> list = new GenericEntity<List<String>>(tweets) {
        };
        return Response.ok(list).build();

    }
}
