import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class Task {
    private String nameTask;//задание
    private String descriptionTask;//описание задания
    private Type typeTask;//тип (личное||рабочее)
    private Repeatability repeatabilityTask;//повторяемость
    private static int count; //счетчик для создания id
    private LocalDateTime time;// время создания задания
    private LocalDate dateTask; //дата напоминания задания
    private LocalTime timeTask;
    private List<LocalDate> dateTaskList=new ArrayList<>(); //список дат повторений конкретного задания
    private List<LocalTime> timeTaskList=new ArrayList<>();//время

    public LocalTime getTimeTask() {
        return timeTask;
    }

    public List<LocalTime> getTimeTaskList() {
        return timeTaskList;
    }

    public List<LocalDate> getDateTaskList() {
        return dateTaskList;
    }

    private int id;// id

    public static int getCount() {
        return count;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public LocalDate getDateTask() {
        return dateTask;
    }

    public Task(String nameTask, String descriptionTask, LocalDate dateTask, LocalTime timeTask, Type typeTask, Repeatability repeatabilityTask) throws ErrorTask {
        this.nameTask = check(nameTask);
        this.descriptionTask = check(descriptionTask);
        this.dateTask = dateTask;
        this.typeTask = typeTask;
        listDateTask(dateTask,timeTask,repeatabilityTask);
        this.timeTask=timeTask;
        this.repeatabilityTask = repeatabilityTask;
        this.time = LocalDateTime.now();
        this.id = count;
        count++;
        MethodTask.getMapTask().put(id, this);
    }

    //метод создания списка дат повторений конкретного задания
    private void listDateTask(LocalDate dateTask,LocalTime localTime,Repeatability repeatabilityTask){
        if (repeatabilityTask.getRepeatability()==Repeatability.WEEKLY.getRepeatability()){
            for (int i = 0; i < (LocalDate.MAX.getDayOfYear()/Repeatability.WEEKLY.getRepeatability()); i++) {
                dateTaskList.add(dateTask);
                getTimeTaskList().add(localTime);
                dateTask=dateTask.plusWeeks(1);
            }
        }
        if (repeatabilityTask.getRepeatability()==Repeatability.DAILY.getRepeatability()){
            for (int i = 0; i < (LocalDate.MAX.getDayOfYear()); i++) {
                dateTaskList.add(dateTask);
                getTimeTaskList().add(localTime);
                dateTask=dateTask.plusDays(1);
            }
        }
        if (repeatabilityTask.getRepeatability()==Repeatability.MONTHLY.getRepeatability()){
            for (int i = 0; i < (LocalDate.MAX.getDayOfYear()/Repeatability.MONTHLY.getRepeatability()); i++) {
                dateTaskList.add(dateTask);
                getTimeTaskList().add(localTime);
                dateTask=dateTask.plusDays(1);
            }
        }
        if (repeatabilityTask.getRepeatability()==Repeatability.ANNUALLY.getRepeatability()){
            for (int i = 0; i < 50; i++) {   //по умолчанию 50 лет
                dateTaskList.add(dateTask);
                getTimeTaskList().add(localTime);
                dateTask=dateTask.plusYears(1);
            }
        }
        if (repeatabilityTask.getRepeatability()==Repeatability.ONCE.getRepeatability()){
            //однократно
            dateTaskList.add(dateTask);
            getTimeTaskList().add(localTime);

        }
    }

    public String getNameTask() {
        return nameTask;
    }

    public int getId() {
        return id;
    }

    public String getDescriptionTask() {
        return descriptionTask;
    }

    public Type getTypeTask() {
        return typeTask;
    }

    public Repeatability getRepeatabilityTask() {
        return repeatabilityTask;
    }

    // метод для проверки вводимых String -ов
    public String check(String str) throws ErrorTask {
        try {
            if (str != null && !str.isBlank() && !str.isEmpty()) {
                return str;
            } else {
                throw new ErrorTask();
            }
        } catch (ErrorTask e) {
            e.getMessage();
        }
        return str;
    }

    @Override
    public String toString() {
        return "ID " + id +
                " : " + nameTask  +
                " | описание: " + descriptionTask + ", тип задачи - " + typeTask.getType() +
                ", повторяемость - " + repeatabilityTask.getRepeatability() + ", время создания -> " + time +
                " || дата и время создания задачи -> " + dateTask+"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

