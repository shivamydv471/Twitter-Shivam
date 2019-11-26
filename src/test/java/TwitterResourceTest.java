import org.junit.Assert;
import org.junit.Test;
import twitter4j.TwitterException;

import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TwitterResourceTest {
    private static final Tweet TWEET = mock(Tweet.class);
    private static final TimeLine TIME_LINE = mock(TimeLine.class);

    TwitterResource twitterResource = new TwitterResource(TWEET,TIME_LINE);
    @Test
    public void testPostTweet() throws TwitterException {
        Response response = Response.ok().build();
        when(TWEET.postTweet("Hello")).thenReturn("Hello");
        Assert.assertEquals(twitterResource.postTweet("Hello").getStatus(),response.getStatus());
    }

    @Test
    public void testGetTimeline() throws TwitterException {
        List<String> strings = new ArrayList<String>();
        strings.add("twitterTimeline");
        when(TIME_LINE.getTimeLine()).thenReturn(strings);
        Assert.assertEquals(twitterResource.getTimeline().getStatus(), Response.ok().build().getStatus());
    }
}