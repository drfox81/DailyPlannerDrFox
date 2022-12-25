import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class MethodTask {

    private static Map<Integer, Task> baza = new HashMap<>();// коллекция заданий, ключ id

    public static Map<Integer, Task> getBaza() {
        return baza;
    }

    // метод добавляет новую задачу
    public static void addTask(String nameTask, String descriptionTask, LocalDate dateTask, LocalTime timeTask, Type typeTask, int repeatabilityTask) throws ErrorTask {
        new Task(nameTask, descriptionTask, dateTask, timeTask, typeTask, repeatabilityTask);
    }

    //метод получения задач на день
    public static void getTaskForDay(LocalDate localDate) {
        for (Map.Entry<Integer, Task> entry : getBaza().entrySet()) {
            if (entry.getValue().isCurrent() == true && entry.getValue().getDateTask().contains(localDate)) {
                System.out.println(entry.getValue().getTimeTask() + " : " + entry.getValue().getNameTask() + " -> " +
                        entry.getValue().getDescriptionTask() + " || " +
                        localDate + " | " + entry.getValue().getId());
            }

        }
    }

    public static void listBazaZombi() {
        for (Map.Entry<Integer, Task> entry : getBaza().entrySet()) {
            if (entry.getValue().isCurrent() == false) {
                System.out.println(entry.getValue());
            }
        }
    }

    public static void deleteTask(int id) {
        getBaza().get(id).setCurrent(false);
    }


}

