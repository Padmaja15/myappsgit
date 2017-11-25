//*   In-Class 
public class Airplane {

	private boolean[] lights = new boolean[5];
	
	public void cancel () {
		for (int i = 0; i < 5; i++)
			lights[i] = false;
	}
	
	public void call (int seatNumber) {
		lights [seatNumber] = !lights[seatNumber];
	}
	
	public boolean[] currentState() {
		return lights;
	}
}
