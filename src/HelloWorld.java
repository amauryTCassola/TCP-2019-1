/**
 * 
 */

import org.jfugue.player.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Amaury, Felipe and Rafael
 *
 */
public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print("Java fucking sucks ass");
		Player player = new Player();
		player.play("A B C D E F G");
	}

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
