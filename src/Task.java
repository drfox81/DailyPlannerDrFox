import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class Task {
    private String nameTask;//задание
    private String descriptionTask;//описание задания
    private Type typeTask;//тип (личное||рабочее)
    private int repeatabilityTask;//повторяемость
    private static int count; //счетчик для создания id
    private LocalDateTime time;// время создания задания
    private List<LocalDate> dateTask=new ArrayList<>(); //дата напоминания задания
    private LocalTime timeTask;

    private boolean current;

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public LocalTime getTimeTask() {
        return timeTask;

    }

    private int id;// id

    public LocalDateTime getTime() {
        return time;
    }

    public List<LocalDate> getDateTask() {
        return dateTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public void setDescriptionTask(String descriptionTask) {
        this.descriptionTask = descriptionTask;
    }

    public Task(String nameTask, String descriptionTask, LocalDate dateTask, LocalTime timeTask, Type typeTask, int repeatabilityTask) throws ErrorTask {
        this.nameTask = check(nameTask);
        this.descriptionTask = check(descriptionTask);
        getDateTask().add(dateTask);
        this.typeTask = typeTask;
        this.timeTask = timeTask;
        this.repeatabilityTask = repeatabilityTask;
        this.current = true;
        this.id = count;
        this.time = LocalDateTime.now();
        count++;
        MethodTask.getBaza().put(id, this);
        listDateTask(dateTask, repeatabilityTask);
    }

    public Task(List<LocalDate> dateTask) throws ErrorTask {
        this.dateTask = dateTask;
    }

    public void listDateTask(LocalDate dateTask, int repeatabilityTask) throws ErrorTask {
        switch (repeatabilityTask) {
            case 0:
                //MethodTask.getBaza().put(dateTask, this);
                break;
            case 1:
                Daily daily = new Daily(getDateTask(), this);
                daily.repeatability(dateTask);
                break;
            case 2:
                Weekly weekly = new Weekly(getDateTask(), this);
                weekly.repeatability(dateTask);
                break;
            case 3:
                Monthly monthly = new Monthly(getDateTask(), this);
                monthly.repeatability(dateTask);
                break;
            case 4:
                Annually annually = new Annually(getDateTask(), this);
                annually.repeatability(dateTask);
                break;
            default:
                System.out.println("одумайся");
                break;
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

    public int getRepeatabilityTask() {
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
        return "Task{" +
                "nameTask='" + nameTask +"||"+descriptionTask+
                ", dateTask=" + dateTask +
                ", timeTask=" + timeTask +
                ", current=" + current +
                ", id=" + id +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(nameTask, task.nameTask);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameTask, id);
    }
}

