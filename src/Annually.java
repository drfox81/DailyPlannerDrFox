import java.time.LocalDate;
import java.util.List;

public class Annually extends Task implements RepeatabilityTask {
    private Task task;
    public Task getTask() {
        return task;
    }
    public Annually(List<LocalDate> dateTask, Task task) throws ErrorTask {
        super(dateTask);
        this.task=task;
    }

    @Override
    public void repeatability(LocalDate dateTask) {
        for (int i = 0; i < 10; i++) {//10 лет
            dateTask = dateTask.plusYears(1);
            getTask().getDateTask().add(dateTask);
        }
    }
}
