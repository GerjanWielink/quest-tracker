package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetRequest {
	private URL url;

	public GetRequest (String url) {
		try {
			this.url = new URL(url);
		} catch (MalformedURLException e) {
			System.out.println("Invalid url provided");
		}
	}

	public String execute () {
		// setup the request object
		try {
			System.out.print("Attempting to reach: ");
			System.out.println(this.url.toString());

			HttpURLConnection connection = (HttpURLConnection) this.url.openConnection();
			connection.setRequestMethod("GET");

			// execute the connection
			int status = connection.getResponseCode();

			// handle redirect
			if (status == HttpURLConnection.HTTP_MOVED_TEMP
					|| status == HttpURLConnection.HTTP_MOVED_PERM) {
				String location = connection.getHeaderField("Location");
				URL newUrl = new URL(location);
				connection = (HttpURLConnection) newUrl.openConnection();
			}

			// read the response
			BufferedReader in = new BufferedReader(
					new InputStreamReader(connection.getInputStream())
			);
			String inputLine;
			StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			// close the connection
			in.close();

			// return the content
			return content.toString();
		} catch (IOException e) {
			System.out.println("IOException in class GetRequest");
			return "";
		}
	}


}
