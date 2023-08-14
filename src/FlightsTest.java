import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class FlightsTest {

	@Test
	void test() throws IOException {
		
		var flights = new Flights();
		ArrayList <String> result = flights.getFlights();
		assertEquals(949000, result.size());
		
	}

}
