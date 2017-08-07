import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UGDataTest {

    private UGData ugData;

    @Before
    public void setUp() {

        //create a ugdata object
        ugData = new UGData();

    }

    @Test
    public void getTop100Tabs() throws Exception {

        //output the top 100 guitar tabs in console
        ugData.outputTop100Tabs();

    }

}