import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ErrorTask {
        try (Scanner scanner = new Scanner(System.in)) {

            label:
            while (true) {
//            Scanner scanner = new Scanner(System.in);
                printMenu();
                if (scanner.hasNextInt()) {
                    int number = scanner.nextInt();
                    scanner.nextLine();
                    switch (number) {
                        case 1:
                            System.out.println("Введите название задачи:");
                            String nameTask = scanner.nextLine();
                            System.out.println("Введите описание задачи:");
                            String descriptionTask = scanner.nextLine();
                            System.out.println("Введите дату задачи и время\n");
                            System.out.println("Введите год\n");
                            int year = scanner.nextInt();
                            System.out.println("Введите месяц\n");
                            int mounth = scanner.nextInt();
                            System.out.println("Введите день\n");
                            int day = scanner.nextInt();
                            System.out.println("Введите часы\n");
                            int hour = scanner.nextInt();
                            System.out.println("Введите минуты\n");
                            int minute = scanner.nextInt();
                            System.out.println("Введите тип задачи\n");
                            System.out.println("1-личная\n");
                            System.out.println("2-рабочая\n");
                            Type typeTask1;
                            int typeTask = scanner.nextInt();
                            if (typeTask == 1) {
                                typeTask1 = Type.PERSONAL_TASK;
                            } else {
                                typeTask1 = Type.WORKING_TASK;
                            }
                            System.out.println("Введите повторяемость\n");
                            System.out.println("0 - однократная\n");
                            System.out.println("1-ежедневная\n");
                            System.out.println("2-еженедельная\n");
                            System.out.println("3-ежемесечная\n");
                            System.out.println("4-ежегодная\n");
                            Repeatability repeatabilityTask = null;
                            int numberRepeat = scanner.nextInt();
                            switch (numberRepeat) {
                                case 0:
                                    repeatabilityTask = Repeatability.ONCE;
                                    break;
                                case 1:
                                    repeatabilityTask = Repeatability.DAILY;
                                    break;
                                case 2:
                                    repeatabilityTask = Repeatability.WEEKLY;
                                    break;
                                case 3:
                                    repeatabilityTask = Repeatability.MONTHLY;
                                    break;
                                case 4:
                                    repeatabilityTask = Repeatability.ANNUALLY;
                                    break;
                                default:
                                    System.out.println("умник, читай внимательно!");
                            }

                            MethodTask.addTask(nameTask, descriptionTask, LocalDate.of(year, mounth, day), LocalTime.of(hour, minute),
                                    typeTask1, repeatabilityTask);
                            // todo
                            break;
                        case 2:
                            System.out.println("Введите id для удаления задачи");
                            int id = scanner.nextInt();
                            MethodTask.getMapTask().remove(id);
                            // todo: обрабатываем пункт меню 2
                            break;
                        case 3:
                            System.out.println("ВВедите дату");
                            System.out.println("Введите год\n");
                            int yearTarget = scanner.nextInt();
                            System.out.println("Введите месяц\n");
                            int mounthTarget = scanner.nextInt();
                            System.out.println("Введите день\n");
                            int dayTarget = scanner.nextInt();
                            MethodTask.getTaskForDay(LocalDate.of(yearTarget, mounthTarget, dayTarget));
                            // todo: обрабатываем пункт меню 3
                            break;
                        case 0:
                            break label;
                        default:// todo: обрабатываем пункт меню 4

                    }




                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }

                for (Map.Entry<Integer, Task> entry : MethodTask.getMapTask().entrySet()) {
                    System.out.println(entry.toString());
                }
                System.out.println(MethodTask.getMapTask().entrySet().size());

            }
        }
    }

    private static void printMenu() {
        System.out.println(
                "1. Добавить задачу\n" +
                        "2. Удалить задачу\n" +
                        "3. Получить задачу на указанный день\n" +
                        "0. Выход\n"
        );
    }

}
