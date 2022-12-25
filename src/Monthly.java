import java.time.LocalDate;
import java.util.List;

public class Monthly extends Task  implements RepeatabilityTask {

    private Task task;

    public Task getTask() {
        return task;
    }
    public Monthly(List<LocalDate> dateTask, Task task) throws ErrorTask {
        super(dateTask);
        this.task=task;
    }

    @Override
    public void repeatability(LocalDate dateTask) {
        for (int i = 0; i < 36; i++) {//36 месяцев
            dateTask = dateTask.plusMonths(1);
            getTask().getDateTask().add(dateTask);
        }
    }
}
