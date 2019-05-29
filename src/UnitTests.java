import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTests {
    @Test
    @DisplayName("Exemplo de Teste")
    public void helloTest() {
        int exemplo = 5;
        assertEquals(exemplo, 5);
    }

    @Test
    @DisplayName("Another Test")
    public void helloTest2() {
        String testString = "Teste";
        assertEquals(testString, "Teste");
    }
}
