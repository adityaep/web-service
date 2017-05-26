//aditya eko prabowo 
//15.01.53.0053



import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class NamexTweet {
    private final static String CONSUMER_KEY = "cfO2eRc9IkjzTZQyw2V4AzQ1i";
    private final static String CONSUMER_KEY_SECRET = "yX9kfWdClSSjUf1vTkfDDcFySzabH4FDabsFkUt4jSlGYZNy4e";

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

	twitter.updateStatus("im updating status again from Namex Tweet for Demo");

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
	return "3D2uXvoeHMpSGqKZlOGShGVQrvdhj0GEbbscvRowbNnmO";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "2816419068-nhOeQ8iJHP4qnNCx5RwRHAdlyfp4xOT0FAoAhp4";
    }

    public static void main(String[] args) throws Exception {
	new NamexTweet().start();
    }
}