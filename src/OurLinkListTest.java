import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OurLinkListTest {

    OurList<String> b;

    @Before
    public void setUp() throws Exception {
        b = new OurLinkedList<String>();
    }

    @Test
    public void testFirstIndexAfter() {
        b.add("hello");
        b.add("there");
        b.add("class");
        b.add("I");
        b.add("am");
        b.add("your");
        b.add("professor");
        b.add("hello");
        b.add("boys");
        assertEquals(7, b.firstIndexAfter("hello", 0));

    }

    @Test
    public void moveLater() {
        b.add("hello");
        b.add("there");
        b.add("class");
        b.add("I");
        b.add("am");
        b.add("your");
        b.add("professor");

        b.moveLater("hello");
        assertEquals(b.get(1), "hello");

        b.moveLater("your");
        assertEquals(b.get(6), "your");

    }
}
