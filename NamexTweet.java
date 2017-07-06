/**
 * @(#)NamexTweet.java
 *
 * NamexTweet application
 *
 * @author 
 * @version 1.00 2017/5/28
 */
 
import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class NamexTweet {
    private final static String CONSUMER_KEY ="ugn3ZPMBm21tF8m1UAwYA7SfR";
    private final static String CONSUMER_KEY_SECRET ="08Nng6f6ZtS32rOqj9PXjavgtXd3ypce2CgNw0LtI105rbHwJ1";

    public void start() throws TwitterException, IOException {

	Twitter twitter = new TwitterFactory().getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

	// here's the difference
	String accessToken = getSavedAccessToken();
	String accessTokenSecret = getSavedAccessTokenSecret();
	AccessToken oathAccessToken = new AccessToken(accessToken,
		accessTokenSecret);

	twitter.setOAuthAccessToken(oathAccessToken);
	// end of difference

	twitter.updateStatus("Hi, im updating status again from Namex Tweet for Demo");

	System.out.println("\nMy Timeline:");

	// I'm reading your timeline
	ResponseList<Status> list = twitter.getHomeTimeline();
	for (Status each : list) {

	    System.out.println("Sent by: @" + each.getUser().getScreenName()
		    + " - " + each.getUser().getName() + "\n" + each.getText()
		    + "\n");
	}

    }

    private String getSavedAccessTokenSecret() {
	// consider this is method to get your previously saved Access Token
	// Secret
	return "BHcdLIDlct53YTB98pG0V1V4XXTzuZDRD3zCNIlNr65xx";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "231294415-OdCaY69ZSinJY330GXdYUC2UukkHD01FsIWnuqIl";
    }

    public static void main(String[] args) throws Exception {
	new NamexTweet().start();
    }
}
