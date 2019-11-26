import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.TwitterException;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/1.0/twitter")
public class TwitterResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwitterResource.class);

    private Tweet tweet;

    private TimeLine timeLine;

    public TwitterResource(Tweet tweet, TimeLine timeLine) {
        this.tweet = tweet;
        this.timeLine = timeLine;
    }

    @POST
    @Path("/tweet")
    public Response postTweet(@QueryParam("message") String tweetMsg) throws TwitterException {
        if (StringUtils.isNotEmpty(tweetMsg)) {
            String s = tweet.postTweet(tweetMsg);
            if(StringUtils.isNotEmpty(s)){
                return Response.ok().build();
            }
            return Response.serverError().build();
        }
        return Response.noContent().build();
    }

    @GET
    @Path("/timeline")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTimeline() throws TwitterException {

        List<String> tweets = timeLine.getTimeLine();
        GenericEntity<List<String>> list = new GenericEntity<List<String>>(tweets) {
        };
        return Response.ok(list).build();

    }
}
