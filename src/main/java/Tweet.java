import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.Scanner;

public class Tweet {


    public String postTweet(String newTweet) throws TwitterException {
        Twitter twitter = TwitterFactory.getSingleton();
        Status status = twitter.updateStatus(newTweet);
        return status.getText();
    }
    
}
