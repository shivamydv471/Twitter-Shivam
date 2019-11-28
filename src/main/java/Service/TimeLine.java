package Service;

import org.apache.commons.collections4.CollectionUtils;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TimeLine {

    public List<String> getTimeLine() throws TwitterException {
        Twitter twitter = TwitterFactory.getSingleton();

        return twitter.getHomeTimeline().stream()
                .map(item -> item.getText())
                .collect(Collectors.toList());
    }
}
