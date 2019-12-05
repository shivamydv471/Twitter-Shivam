package Service;

import Models.Tweet;
import Models.User;
import org.apache.commons.collections4.CollectionUtils;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TimeLineService {

    public List<Tweet> getTimeLine() throws TwitterException {
        Twitter twitter = TwitterFactory.getSingleton();

        List<Status> statuses = twitter.getHomeTimeline();
        List<Tweet> tweets = new ArrayList<>();
        for(Status status:statuses){
            Tweet tweet = new Tweet();
            tweet.setCreatedAt(status.getCreatedAt());
            tweet.setMessage(status.getText());
            tweet.setId(String.valueOf( status.getId()));
            if(Objects.nonNull(status.getUser())){
                tweet.setUser(new User(status.getUser().getScreenName(),status.getUser().getName(),status.getUser().getProfileImageURL()));
            }
            tweets.add(tweet);
        }
        return tweets;
    }

    public List<Tweet> getTimeLineByFilter(String tweetFilter) throws TwitterException {
        Twitter twitter = TwitterFactory.getSingleton();

        List<Status> statuses = twitter.getHomeTimeline();
        List<Tweet> tweets = new ArrayList<>();
        for(Status status:statuses){
            Tweet tweet = new Tweet();
            tweet.setCreatedAt(status.getCreatedAt());
            tweet.setMessage(status.getText());
            if(Objects.nonNull(status.getUser())){
                tweet.setUser(new User(status.getUser().getScreenName(),status.getUser().getName(),status.getUser().getProfileImageURL()));
            }
            tweets.add(tweet);
        }
        return tweets;
    }
}
