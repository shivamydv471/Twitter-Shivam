import org.apache.commons.collections4.CollectionUtils;
import twitter4j.TwitterException;

import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("type 1 to Post a tweet");
            System.out.println("type 2 to get the timeline");
            System.out.println("type 3 to exit");
            Integer s = sc.nextInt();
            sc.nextLine();
            switch (s) {
                case 1:
                    try {
                        System.out.println("What's happening?");
                        String newTweet = sc.nextLine();
                        Tweet ct = new Tweet();
                        ct.postTweet(newTweet);
                    } catch (TwitterException e) {
                        System.out.println("Something weird happened. Sorry for the inconvenience");
                    }
                    break;
                case 2:
                    try {
                        TimeLine timeLine = new TimeLine();
                        List<String> tweets = timeLine.getTimeLine();
                        if (CollectionUtils.isNotEmpty(tweets)) {
                            for (String tweet : tweets) {
                                System.out.println(tweet);
                            }
                        }
                    } catch (TwitterException e) {
                        System.out.println("Something weird happened. Sorry for the inconvenience");
                    }
                    break;

                case 3:
                    return;


            }
        }
    }
}
