import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) throws NumException {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");

        logger.log("Просим пользователя ввести входные данные для списка");
        logger.log("Введите размер списка:");
        int sizeArrays = Integer.parseInt(scanner.nextLine());
        if(sizeArrays <= 0){
            throw new NumException("Введите значение > 0");
        }

        logger.log("Введите верхнюю границу для значений:");
        int high = Integer.parseInt(scanner.nextLine());
        if(high <= 0){
            throw new NumException("Введите значение > 0");
        }

        List<Integer> list = makeArrays(sizeArrays, high);
        System.out.println(list);

        logger.log("Просим пользователя ввести входные данные для фильтрации");
        logger.log("Введите порог для фильтра:");
        int filterNum = Integer.parseInt(scanner.nextLine());

        List<Integer> newArrays = getNewArrays(list, filterNum);
        logger.log("Выводим результат на экран: ");
        System.out.print(newArrays);
    }

    private static List<Integer> makeArrays(int sizeArrays, int high) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < sizeArrays; i++) {
            list.add(random.nextInt(high));
        }
        return list;
    }

    private static List<Integer> getNewArrays(List<Integer> oldList, int filer) {
        List<Integer> newArrays = oldList.stream()
                .filter(value -> value >= filer)
                .collect(Collectors.toList());
        return newArrays;
    }
}
