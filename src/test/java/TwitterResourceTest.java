import Models.Tweet;
import Resources.TwitterResource;
import Service.TimeLineService;
import Service.TweetService;
import org.junit.Assert;
import org.junit.Test;
import twitter4j.TwitterException;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TwitterResourceTest {
    private static final TweetService TWEET_SERVICE = mock(TweetService.class);
    private static final TimeLineService TIME_LINE = mock(TimeLineService.class);

    TwitterResource twitterResource = new TwitterResource(TWEET_SERVICE,TIME_LINE);
    @Test
    public void testPostTweet() throws TwitterException {
        Response response = Response.ok().build();
        when(TWEET_SERVICE.postTweet("Hello")).thenReturn("Hello");
        Assert.assertEquals(twitterResource.postTweet("Hello").getStatus(),response.getStatus());
    }

    @Test
    public void testGetTimeline() throws TwitterException {
        List<Tweet> strings = new ArrayList<Tweet>();
        strings.add(new Tweet());
        when(TIME_LINE.getTimeLine()).thenReturn(strings);
        Assert.assertEquals(twitterResource.getTimeline().getStatus(), Response.ok().build().getStatus());
    }
}