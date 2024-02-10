public class RubleFormatter {
    public String format(double number) {
        int floorNumber = (int) Math.floor(number);
        String ruble;
        if (floorNumber % 10 == 1 && floorNumber % 100 != 11) {
            ruble = "rubl'";
        } else if (floorNumber % 10 >= 2 && floorNumber % 10 <= 4 && (floorNumber % 100 < 10 || floorNumber % 100 >= 20)) {
            ruble = "rublya";
        } else {
            ruble = "rubley";
        }
        return ruble;
    }
}