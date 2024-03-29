package Service;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class TweetService {

    Twitter twitter;

    public TweetService() {
        this.twitter = TwitterFactory.getSingleton();
    }

    public String postTweet(String newTweet) throws TwitterException {

        Status status = twitter.updateStatus(newTweet);
        return status.getText();
    }

}
