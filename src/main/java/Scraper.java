import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Scraper {

    private Document htmlDoc;
    private String webpageUrl;


    public Scraper(String webpageUrl) {

        this.webpageUrl = webpageUrl;

        try {

            //get the html document of the page using the Mozilla browser as user agent
            this.htmlDoc = Jsoup.connect(webpageUrl).userAgent("Mozilla").get();

            //getPageTitle() invokes htmlDoc.title()
            System.out.println("Scraping data from source titled:\n" + getPageTitle());

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    //Return the title of the webpage
    public String getPageTitle() {

        return htmlDoc.title();

    }

    public Document getHtmlDoc() {
        return htmlDoc;
    }

    public void refreshHtml() {
        this.htmlDoc = htmlDoc;
    }

    public String getWebpageUrl() {
        return webpageUrl;
    }

    public void setWebpageUrl(String webpageUrl) {
        this.webpageUrl = webpageUrl;
    }
}
