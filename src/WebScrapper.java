import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WebScrapper {

	private URL url;

	public WebScrapper(String webUrl) throws MalformedURLException {
		this.url = new URL(webUrl);
	}
	
	public URLConnection connect() throws IOException {
		URLConnection text = url.openConnection();
		String redirect = text.getHeaderField("Location");
		while (redirect != null) {
			text = new URL(redirect).openConnection();
			redirect = text.getHeaderField("Location");
		}
		return text;
	}

	public void printHTML() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(connect().getInputStream()));
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
	}
	
	// For testing
	public static void main(String[] args) throws MalformedURLException, IOException { 
		WebScrapper scrap = new WebScrapper("https://en.wikipedia.org/wiki/Computer_programming");
		scrap.printHTML();
	}

}
