import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class UGData {

    private static final String TOP_100_TABS_URL = "https://www.ultimate-guitar.com/top/top100.htm";
    private ArrayList<String> top100Tabs;

    public UGData() {

        top100Tabs = new ArrayList<String>();
        loadTop100Tabs();

    }

    private void loadTop100Tabs() {

        Scraper scraper = new Scraper(TOP_100_TABS_URL);

        Element table = scraper.getHtmlDoc().select("table").get(15); //table count here starts at zero, so index is 15 not 16.
        Elements rows = table.select("tr"); //access the tables rows

        //loop through the table's rows
        for (int i = 1; i < rows.size(); i++) { //start at 1 because 0 is not part of list

            Element row = rows.get(i); //access row(i) in the table
            Elements cols = row.select("td"); //access the td's in this row

            //set ugdata, had to study the table cols in source to know which parts to access for each type of data
            String rank = cols.get(0).select("b").text();
            String artist = cols.get(0).select("a").text();
            String songTitle = cols.get(1).text();
            String hits = cols.get(3).text();
            String tabLink = cols.get(1).select("a").attr("href");

            //form data string to be stored
            String tabData = "\nRank: " + rank
                           + "\nArtist: " + artist
                           + "\nSong Title: " + songTitle
                           + "\nHits: " + hits
                           + "\nTab Link: " + tabLink;

            //store the guitar tab data
            top100Tabs.add(tabData);

        }

    }

    //output each tab string stored in array list
    public void outputTop100Tabs() {

        for (String tab : top100Tabs) {

            System.out.println(tab);

        }

    }

    public ArrayList<String> getTop100Tabs() {
        return top100Tabs;
    }

    public void setTop100Tabs(ArrayList<String> top100Tabs) {
        this.top100Tabs = top100Tabs;
    }
}
