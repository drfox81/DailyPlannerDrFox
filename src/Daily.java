import java.time.LocalDate;
import java.util.List;

public class Daily extends Task implements RepeatabilityTask {
    private Task task;
    public Task getTask() {
        return task;
    }
    public Daily(List<LocalDate> dateTask, Task task) throws ErrorTask {
        super(dateTask);
        this.task = task;
    }
    @Override
    public void repeatability(LocalDate dateTask) {
        for (int i = 0; i < LocalDate.now().getDayOfYear(); i++) { //
            dateTask = dateTask.plusDays(1);
            getTask().getDateTask().add(dateTask);
        }
    }

}
