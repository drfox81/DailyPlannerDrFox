import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class MethodTask {
    private static Map<Integer, Task> mapTask = new HashMap<>();// коллекция заданий, ключ id

    public static Map<Integer, Task> getMapTask() {
        return mapTask;
    }

    // метод добавляет новую задачу
    public static void addTask(String nameTask, String descriptionTask, LocalDate dateTask, LocalTime timeTask, Type typeTask, Repeatability repeatabilityTask) throws ErrorTask {
        new Task(nameTask, descriptionTask, dateTask, timeTask, typeTask, repeatabilityTask);
    }


    // метод получения задач на день

    public static void getTaskForDay(LocalDate localDate) {
        for (Map.Entry<Integer, Task> entry : mapTask.entrySet()) {
            if (entry.getValue().getDateTaskList().contains(localDate)) {
                System.out.println("На дату " + localDate + " на время " + entry.getValue().getTimeTaskList().get(0).getHour()+
                        ":"+entry.getValue().getTimeTaskList().get(0).getMinute()
                        + " запланировано " + entry.getValue().getNameTask() +
                        " примечание " + entry.getValue().getDescriptionTask());
            }
        }
    }


}

