import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OurListTest {

    OurList<String> b;
    OurList<String> c;

    @Before
    public void setUp() throws Exception {
        b = new OurArrayList<String>();
       // b = new OurLinkedList<String>();   can be switched to test case to link list by uncommenting this
    }

    @Test
    public void testAdd() {
        assertEquals(0, b.size());
        b.add("hello");
        assertEquals(1, b.size());
    }

    @Test
    public void testAddALot() {
        assertEquals(0, b.size());
        b.add("hello");
        b.add("there");
        b.add("class");
        b.add("I");
        b.add("am");
        b.add("your");
        b.add("professor");
        assertEquals(7, b.size());

        for (int i = 0; i < 100000; i++)
            b.add("string" + i);
        assertEquals(100007, b.size());
    }

    @Test
    public void testContains() {
        assertEquals(false, b.contains("stuff"));
        b.add("stuff");
        b.add("things");
        assertEquals(true, b.contains("stuff"));
        assertEquals(true, b.contains("things"));
        assertEquals(false, b.contains("truck"));
    }

    @Test
    public void testGet() {
        b.add("hello");
        b.add("I'm");
        b.add("running");
        b.add("some");
        b.add("tests");
        b.add("now");
        b.add("!!!");

        assertEquals("hello", b.get(0));
        assertEquals("I'm", b.get(1));
        assertEquals("running", b.get(2));
        assertEquals("some", b.get(3));
        assertEquals("tests", b.get(4));
        assertEquals("now", b.get(5));
        assertEquals("!!!", b.get(6));

        try {
            b.get(-1);
            fail();
        } catch (IndexOutOfBoundsException ex) {
            //DO NOTHING; JUST CHECKING THAT EXCEPTION WAS THROWN
        }

        try {
            b.get(7);
            fail();
        } catch (IndexOutOfBoundsException ex) {
            //DO NOTHING; JUST CHECKING THAT EXCEPTION WAS THROWN
        }
    }

    @Test
    public void testLinkedRemove() {
        assertEquals(false, b.remove("hi"));
        b.add("A");
        b.add("B");
        b.add("C");
        b.add("D");
        b.add("E");
        assertEquals(5, b.size());
        assertEquals(false, b.remove("F"));

        //removing from middle
        assertEquals(true, b.remove("C"));
        assertEquals(false, b.remove("C"));
        assertEquals(4, b.size());
        assertEquals("D", b.get(2));

        //removing from front
        assertEquals(true, b.remove("A"));
        assertEquals(3, b.size());
        assertEquals("B", b.get(0));
        assertEquals(false, b.remove("A"));

        //removing from end
        assertEquals(true, b.remove("E"));
        assertEquals(2, b.size());
        assertEquals("B", b.get(0));
        assertEquals("D", b.get(1));
        assertEquals(false, b.remove("E"));
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
        assertEquals(-1, b.firstIndexAfter("i", 3));


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
