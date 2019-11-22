import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.Scanner;

public class Tweet {
    public static void main(String[] args) throws TwitterException {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("What's happening?");
            String newTweet = sc.nextLine();
            Tweet ct = new Tweet();
            ct.postTweet(newTweet);
        }

    }

    private String postTweet(String newTweet) throws TwitterException {
        Twitter twitter = getTwitterinstance();
        Status status = twitter.updateStatus(newTweet);
        return status.getText();
    }

    public static Twitter getTwitterinstance() {
        Twitter twitter = TwitterFactory.getSingleton();
        return twitter;
    }
}
