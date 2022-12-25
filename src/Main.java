import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;
import java.util.Scanner;

// выбор даты до которой действует задача не задавал, не сложно, просто вводить в ручную не так удобно при тестировании ))
public class Main {
    public static void main(String[] args) throws ErrorTask {
        try (Scanner scanner = new Scanner(System.in)) {

            label:
            while (true) {
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
                            int repeatabilityTask = scanner.nextInt();
                            MethodTask.addTask(nameTask, descriptionTask, LocalDate.of(year, mounth, day), LocalTime.of(hour, minute),
                                    typeTask1, repeatabilityTask);
                            // todo
                            break;
                        case 2:
                            System.out.println("Введите id для удаления задачи");
                            int id = scanner.nextInt();
                            MethodTask.deleteTask(id);
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
                        case 4:
                            System.out.println("Удалены (завершены): \n");
                            MethodTask.listBazaZombi();
                            // todo: обрабатываем пункт меню 4
                            break;
                        case 5:
                            System.out.println("Введите id для редоктирования задачи\n");
                            int idEditTask = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Введите название задачи:\n");
                            String nameNew = scanner.nextLine();
                            if (nameNew != null && !nameNew.isBlank() && !nameNew.isEmpty()) {
                                MethodTask.getBaza().get(idEditTask).setNameTask(nameNew);
                            }
                            System.out.println("Введите описание задачи:\n");
                            String descriptionTaskNew = scanner.nextLine();
                            if (nameNew != null && !nameNew.isBlank() && !nameNew.isEmpty()) {
                                MethodTask.getBaza().get(idEditTask).setDescriptionTask(descriptionTaskNew);
                            }
                            System.out.println(MethodTask.getBaza().get(idEditTask));
                            // todo: обрабатываем пункт меню 5
                            break;
                        case 0:
                            break label;
                        default:// todo: обрабатываем пункт меню 4

                    }


                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }

        } catch (DateTimeException e) {
            System.out.println("!!!!!!!!!!Внимательно циферки тыкайте!!!!!!!!!!");
            e.getMessage();
        }
    }

    private static void printMenu() {
        System.out.println(
                "1. Добавить задачу\n" +
                        "2. Удалить задачу\n" +
                        "3. Получить задачу на указанный день\n" +
                        "4. Получить список удаленных(завершенных) задач\n" +
                        "5. Исправить название или описание задачи\n" +
                        "0. Выход\n"
        );
    }

}
