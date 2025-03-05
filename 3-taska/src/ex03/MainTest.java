package ex03;

import ex02.ResultData
import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void testViewResult() {
        ViewResult view = new ViewResult();
        view.viewInit();
        assertEquals(5, view.getItems().size());
        assertEquals(0.0, view.getItems().get(0).getY(), 0.001);
    }

    @Test
    public void testSerialization() throws Exception {
        ViewResult view1 = new ViewResult();
        view1.viewInit();
        view1.viewSave();

        ViewResult view2 = new ViewResult();
        view2.viewRestore();

        assertEquals(view1.getItems().size(), view2.getItems().size());
        assertTrue(view2.getItems().get(1).getY() == 1.0);
    }
}