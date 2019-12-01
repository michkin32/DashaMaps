import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TestClass {

    private DashaMapOne dasha1;
    private DashaMapTwo dasha2;
    private DashaMapThree dasha3;

    @Before
    public void setUp() throws FileNotFoundException {
        dasha1 = new DashaMapOne();
        dasha2 = new DashaMapTwo();
        dasha3 = new DashaMapThree();
        setMapsUp();

    }
    private void setMapsUp() throws FileNotFoundException {
        String file = "word-list.txt";

            Scanner scanner = new Scanner(new File(file));
            while (scanner.hasNext()) {
                String[] line = scanner.nextLine().split(" ");

                dasha1.set(line[0], line[1]);
                dasha2.set(line[0], line[1]);
                dasha3.set(line[0], line[1]);
            }
        }
    @Test
    public void testDelete(){


        dasha1.delete("i");
        dasha2.delete("you");
        dasha3.delete("her");

        Assert.assertEquals(123, dasha1.size());
        Assert.assertEquals(123, dasha2.size());
        Assert.assertEquals(123, dasha3.size());
    }

    @Test
    public void SizeTest(){
        Assert.assertEquals(124, dasha1.size());
        Assert.assertEquals(124, dasha2.size());
        Assert.assertEquals(124, dasha3.size());
    }
    @Test
    public void testGet(){


        Assert.assertEquals("6", dasha1.get("after"));
        Assert.assertEquals("0", dasha2.get("it"));
        Assert.assertEquals("56", dasha3.get("who"));
    }
    @Test
    public void IsEmptyTest(){


        Assert.assertFalse(dasha1.isEmpty());
        Assert.assertFalse(dasha2.isEmpty());
        Assert.assertFalse(dasha3.isEmpty());
    }

    }

