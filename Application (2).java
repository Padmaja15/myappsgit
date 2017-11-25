
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		
		Airplane airplane = new Airplane();
		boolean[] lights;
		
		Scanner input = new Scanner(System.in);
		
		while (true) {
			
			lights = airplane.currentState();
			for (int i = 0; i < 5; i++)
				if (lights[i])
					System.out.print("On  ");
				else
					System.out.print("Off  ");
			System.out.println("");
			
			System.out.println("Enter choice: (1)Cancel, (2) Call <num>, (3) exit");
			
			int command;
			int seatNumber;
			command = input.nextInt();
			if (command == 1) {
				airplane.cancel();
			}
			else if (command == 2) {
				seatNumber = input.nextInt();
				airplane.call(seatNumber);
			}
			else if (command == 3) {
				break;
			}
		}

	}

}
