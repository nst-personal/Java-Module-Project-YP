import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = getNumberOfPeople(scanner);
        fillProducts(calculator, scanner);
        displayProducts(calculator);
        calculateSumPerPerson(calculator, numberOfPeople);
    }
    private static int getNumberOfPeople(Scanner scanner) {
        int numberOfPeople = 0;
        while (numberOfPeople <= 1) {
            System.out.println("Enter number of people to split the bill");
            if (scanner.hasNextInt()) {
                numberOfPeople = scanner.nextInt();
                if (numberOfPeople <= 0) {
                    System.out.println("The number of people must be positive");
                } else if (numberOfPeople == 1) {
                    System.out.println("There is no point in counting");
                }
            } else {
                System.out.println("Invalid input. Please enter value");
                scanner.next();
            }
        }
        return numberOfPeople;
    }

    private static void fillProducts(Calculator calculator, Scanner scanner) {
        System.out.println("Add product");
        String action = null;
        while (action == null || !action.equalsIgnoreCase("done")) {
            addProduct(scanner, calculator);
            System.out.println("Do you want to add more? Fill 'done' to complete");
            action = scanner.next();
        }
    }

    private static void addProduct(Scanner scanner, Calculator calculator) {
        String name = null;
        while (name == null || name.trim().isEmpty()) {
            System.out.println("Enter name of product");
            name = scanner.next();
        }
        Double price = 0.0;
        while (price <= 0 || Math.abs(price * 100 - Math.round(price * 100)) > 0.001) {
            System.out.println("Enter price of product");
            if (scanner.hasNextDouble()) {
                price = scanner.nextDouble();
                if (price <= 0 || Math.abs(price * 100 - Math.round(price * 100)) > 0.001) {
                    System.out.println("The number of people must be positive and has 2 digits after dot");
                }
            } else {
                System.out.println("Invalid input. Please enter value");
                scanner.next();
            }
        }
        calculator.add(new Product(name, price));
        System.out.println("Product added");
    }

    private static void displayProducts(Calculator calculator) {
        System.out.println("Added products:");
        RubleFormatter rubleFormatter = new RubleFormatter();
        for (Product product: calculator.getProducts()) {
            System.out.printf("%s || %.2f %s\n", product.getName(), product.getPrice(), rubleFormatter.format(product.getPrice()));
        }
    }

    private static void calculateSumPerPerson(Calculator calculator, int numberOfPeople) {
        double sumPerPerson = calculator.getSum() / numberOfPeople;
        RubleFormatter rubleFormatter = new RubleFormatter();
        System.out.printf("Sum per person  ===>  %.2f %s\n", sumPerPerson, rubleFormatter.format(sumPerPerson));
    }

}