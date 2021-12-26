import java.util.*;

public class Driver<T> {
	private MSLL<T> msll = new MSLL<>();
	private SLL<T> sll = new SLL<>();
	private static Driver driver = new Driver();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int input = -1;
		while (input != 12) {
			System.out.println("1. AddCityToSublistAtRear\n2. AddCityToSublistAtPosition \n"
					+ "3. SearchForCity \n4. DeleteCityFromCitySublist \n5. DeleteCitySublist \n"
					+ "6. MakeCitySublistEmpty \n7. DisplayCitySublist \n8. addToMSSLAtHead \n"
					+ "9. AddToMSSLAtTail \n10. SearchMSLList \n11. getDistance \n12. Exit");
			input = scanner.nextInt();
			driver.openMethodOfChoice(input);
		}
	}

	private void openMethodOfChoice(int input) {
		sll.setMsll(msll);
		switch (input + "") {
		case "1": {
			City city = new City();
			System.out.println("Enter the city name: ");
			city.setCityName(scanner.next());
			System.out.println("Enter the city latitude in decimal degrees: ");
			city.setDecimalLatitude(scanner.nextDouble());
			System.out.println("Enter the city longitude in decimal degrees: ");
			city.setDecimalLatitude(scanner.nextDouble());

			sll.setMsllNode(msll.addToMSLL("" + city.getCityName().charAt(0)));
			driver.sll.addCityToSublistAtRear(city);
		}
			break;
		case "2": {
			City city = new City();
			System.out.println("Enter the city name: ");
			city.setCityName(scanner.next());
			System.out.println("Enter the city latitude in decimal degrees: ");
			city.setDecimalLatitude(scanner.nextDouble());
			System.out.println("Enter the city longitude in decimal degrees: ");
			city.setDecimalLatitude(scanner.nextDouble());
			System.out.println("Enter the insertion position: ");
			int position = scanner.nextInt();
			sll.setMsllNode(msll.addToMSLL("" + city.getCityName().charAt(0)));
			try {
				driver.sll.addToCitySublistList(city, position);
			} catch (ExceptionType exceptionType) {
				exceptionType.printStackTrace();
			}
		}
			break;
		case "3": {
			City city = new City();
			System.out.println("Enter the city name to search: ");
			city.setCityName(scanner.next());
			if (driver.sll.cityIsInSubList(city)) {
				System.out.println("City exists");
			} else {
				System.out.println("City does not exist");
			}
		}
			break;
		case "4": {
			City city = new City();
			System.out.println("Enter the city name to delete: ");
			city.setCityName(scanner.next());
			MSLLNode<T> msllNode = msll.getMSLLNodeByInfo("" + city.getCityName().charAt(0));
			if (msllNode == null) {
				try {
					throw new ExceptionType("City does not exist");
				} catch (ExceptionType exceptionType) {
					exceptionType.printStackTrace();
				}
			} else {
				sll.setMsllNode(msllNode);
				try {
					driver.sll.deleteCityFromSublist(city);
				} catch (ExceptionType exceptionType) {
					exceptionType.printStackTrace();
				}
			}
		}
			break;
		case "5": {
			City city = new City();
			System.out.println("Enter the city name to delete: ");
			city.setCityName(scanner.next());
			try {
				driver.msll.deleteCitySublist("" + city.getCityName().charAt(0));
			} catch (ExceptionType exceptionType) {
				exceptionType.printStackTrace();
			}
		}
			break;
		case "6": {
			City city = new City();
			System.out.println("Enter the city name to delete: ");
			city.setCityName(scanner.next());
			try {
				driver.msll.makeCitySublistEmpty("" + city.getCityName().charAt(0));
			} catch (ExceptionType exceptionType) {
				exceptionType.printStackTrace();
			}
		}
			break;
		case "7": {
			City city = new City();
			System.out.println("Enter the string to display city sublist: ");
			city.setCityName(scanner.next());
			try {
				driver.msll.displayCitySublist("" + city.getCityName().charAt(0));
			} catch (ExceptionType exceptionType) {
				exceptionType.printStackTrace();
			}
		}
			break;
		case "8": {
			System.out.println("Enter the string to add at head: ");
			String str = scanner.next();
			try {
				driver.msll.addToMSLLHead(str);
			} catch (ExceptionType exceptionType) {
				exceptionType.printStackTrace();
			}
		}
			break;
		case "9": {
			System.out.println("Enter the string to add at tail: ");
			String str = scanner.next();
			try {
				driver.msll.addToMSLLTail(str);
			} catch (ExceptionType exceptionType) {
				exceptionType.printStackTrace();
			}
		}
			break;
		case "10": {
			System.out.println("Enter the string to search MSLL: ");
			String str = scanner.next();
			try {
				if (driver.msll.isInMSLList(str)) {
					System.out.println("String exists in MSLL");
				} else {
					throw new ExceptionType("String doesn't exist in MSLL");
				}
			} catch (ExceptionType exceptionType) {
				exceptionType.printStackTrace();
			}
		}
			break;
		case "11": {
			System.out.println("Enter the name of city1: ");
			String city1Name = scanner.next();
			System.out.println("Enter the name of city2: ");
			String city2Name = scanner.next();
			try {
				driver.sll.getDistance(city1Name, city2Name);
			} catch (ExceptionType exceptionType) {
				exceptionType.printStackTrace();
			}
		}
			break;
		case "12": {
			System.exit(0);
		}
			break;
		}
	}
}
