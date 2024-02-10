public class RubleFormatter {
    public String format(double number) {
        int floorNumber = (int) Math.floor(number);
        int lastDigit = floorNumber % 10;
        int lastTwoDigits = floorNumber % 100;
        if (lastTwoDigits >= 11 && lastTwoDigits <= 19) {
            return "rubley";
        } else if (lastDigit == 1) {
            return "ruble";
        } else if (lastDigit >= 2 && lastDigit <= 4) {
            return "rublya";
        } else {
            return "rubley";
        }
    }
}