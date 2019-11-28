import Config.TwitterConfiguration;
import Resources.TwitterResource;
import Service.TimeLine;
import Service.Tweet;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class TwitterApplication extends Application<TwitterConfiguration> {

    public static void main(String[] args) throws Exception {
        new TwitterApplication().run(args);

        /* Scanner sc = new Scanner(System.in);
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
                        Service.Tweet ct = new Service.Tweet();
                        ct.postTweet(newTweet);
                    } catch (TwitterException e) {
                        System.out.println("Something weird happened. Sorry for the inconvenience");
                    }
                    break;
                case 2:
                    try {
                        Service.TimeLine timeLine = new Service.TimeLine();
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
        }*/
    }

    @Override
    public void initialize(Bootstrap<TwitterConfiguration> bootstrap) {
    }

    @Override
    public void run(TwitterConfiguration twitterConfiguration,
                    Environment environment) throws Exception {
        //Register resource
        TwitterResource twitterResource = new TwitterResource(new Tweet(), new TimeLine());

        //System.out.println(twitterConfiguration.getOauth().getAccessToken());
        environment.jersey().register(twitterResource);
    }


}
