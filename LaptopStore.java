package sem6.HW;


import java.util.*;

public class LaptopStore {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>(Arrays.asList(
            new Laptop("Asus", "Windows", 8, 500, "Intel", "white"),
            new Laptop("MSI", "Windows", 16, 1000, "Intel", "black"),
            new Laptop("Dell", "Linux", 32, 1500, "AMD", "white"),
            new Laptop("Dell", "Linux", 64, 250, "Intel", "black")
        ));

        Scanner scanner = new Scanner(System.in);
        Map<String, String> filters = new HashMap<>();

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        System.out.print("Ваш выбор: ");
        int criterion = scanner.nextInt();

        switch (criterion) {
            case 1:
                System.out.print("Введите минимальный объем ОЗУ: ");
                filters.put("ram", String.valueOf(scanner.nextInt()));
                break;
            case 2:
                System.out.print("Введите минимальный объем ЖД: ");
                filters.put("hdd", String.valueOf(scanner.nextInt()));
                break;
            case 3:
                System.out.print("Выберите операционную систему (1 - Windows, 2 - Linux): ");
                int osChoice = scanner.nextInt();
                filters.put("os", osChoice == 1 ? "Windows" : "Linux");
                break;
            case 4:
                System.out.print("Выберите цвет (1 - белый, 2 - черный): ");
                int colorChoice = scanner.nextInt();
                filters.put("color", colorChoice == 1 ? "white" : "black");
                break;
            default:
                System.out.println("Неверный выбор");
                return;
        }

        filterAndPrintLaptops(laptops, filters);
    }

    public static void filterAndPrintLaptops(Set<Laptop> laptops, Map<String, String> filters) {
        System.out.println("Ноутбуки, соответствующие критериям фильтрации:");
        for (Laptop laptop : laptops) {
            boolean matches = true;
            for (Map.Entry<String, String> filter : filters.entrySet()) {
                String key = filter.getKey();
                String value = filter.getValue();

                switch (key) {
                    case "ram":
                        if (laptop.getRam() < Integer.parseInt(value)) {
                            matches = false;
                        }
                        break;
                    case "hdd":
                        if (laptop.getHdd() < Integer.parseInt(value)) {
                            matches = false;
                        }
                        break;
                    case "os":
                        if (!laptop.getOs().equalsIgnoreCase(value)) {
                            matches = false;
                        }
                        break;
                    case "color":
                        if (!laptop.getColor().equalsIgnoreCase(value)) {
                            matches = false;
                        }
                        break;
                }
                if (!matches) break;
            }
            if (matches) {
                System.out.println(laptop);
            }
        }
    }
}
