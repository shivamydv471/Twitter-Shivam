package Resources;

import Models.Tweet;
import Service.TimeLineService;
import Service.TweetService;
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

    private TweetService tweetService;

    private TimeLineService timeLineService;

    public TwitterResource(TweetService tweetService, TimeLineService timeLineService) {
        this.tweetService = tweetService;
        this.timeLineService = timeLineService;
    }

    @POST
    @Path("/tweet")
    public Response postTweet(@QueryParam("message") String tweetMsg) throws TwitterException {
        LOGGER.debug("postTweet method started",tweetMsg);
        if (StringUtils.isNotEmpty(tweetMsg)) {
            String s = tweetService.postTweet(tweetMsg);
            if(StringUtils.isNotEmpty(s)){
                return Response.ok().build();
            }
            return Response.serverError().build();
        }
        LOGGER.debug("postTweet method ends");
        return Response.noContent().build();
    }

    @GET
    @Path("/timeline")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTimeline() throws TwitterException {
        LOGGER.debug("getTimeline method started");
        List<Tweet> tweets = timeLineService.getTimeLine();
        GenericEntity<List<Tweet>> list = new GenericEntity<List<Tweet>>(tweets) {
        };
        LOGGER.debug("getTimeline method ends");
        return Response.ok(list).build();

    }
    @GET
    @Path("/timeline/filter")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTimelineFilter(@QueryParam("filter") String tweetFilter) throws TwitterException {
        LOGGER.debug("getTimelineFilter method started");
        List<Tweet> tweets = timeLineService.getTimeLineByFilter(tweetFilter);
        GenericEntity<List<Tweet>> list = new GenericEntity<List<Tweet>>(tweets) {
        };
        LOGGER.debug("getTimelineFilter method ends");
        return Response.ok(list).build();

    }
}
