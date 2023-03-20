import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestModel {

    @Test
    void testOptellen() {
        Model model = new Model();
        model.setValue1(3);

        model.setValue2(4);
        model.setOperator('+');

        assertEquals(7, model.calculate());
    }

    @Test
    void testMin() {
        Model model = new Model();
        model.setValue1(3);

        model.setValue2(4);
        model.setOperator('-');

        assertEquals(-1, model.calculate());
    }

    @Test
    void testVerm() {
        Model model = new Model();

        model.setValue1(3);
        model.setValue2(4);
        model.setOperator('*');

        assertEquals(12, model.calculate());
    }
}
