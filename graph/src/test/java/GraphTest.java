import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GraphTest {
    private Graph graph;

    @Before
    public void setUp() {
        graph = new Graph();

    }

    @Test
    public void testOnFile1() {
        graph.initGraph("./src/test/resources/test1.txt");
        graph.numberOfGraphEdgesToAdd();
        graph.gaps();
        assertEquals(3, graph.getCountGraph());
    }

    @Test
    public void testOnFile2() {
        graph.initGraph("./src/test/resources/test2.txt");
        graph.numberOfGraphEdgesToAdd();
        graph.gaps();
        assertEquals(46, graph.getCountGraph());
    }

    @Test
    public void testOnFile3() {
        graph.initGraph("./src/test/resources/test3.txt");
        graph.numberOfGraphEdgesToAdd();
        graph.gaps();
        assertEquals(82, graph.getCountGraph());
    }

    @Test
    public void testOnFil4() {
        graph.initGraph("./src/test/resources/test4.txt");
        graph.numberOfGraphEdgesToAdd();
        graph.gaps();
        assertEquals(11, graph.getCountGraph());
    }

    @Test
    public void testOnFil5() {
        graph.initGraph("./src/test/resources/test5.txt");
        graph.numberOfGraphEdgesToAdd();
        graph.gaps();
        assertEquals(7, graph.getCountGraph());
    }

    @Test
    public void testOnFil6() {
        graph.initGraph("./src/test/resources/123.txt");
        graph.numberOfGraphEdgesToAdd();
        graph.gaps();
        assertEquals(10, graph.getCountGraph());
    }
}