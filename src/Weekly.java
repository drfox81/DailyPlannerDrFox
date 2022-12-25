import java.time.LocalDate;
import java.util.List;

public class Weekly extends Task  implements RepeatabilityTask{
    private Task task;

    public Task getTask() {
        return task;
    }
    public Weekly(List<LocalDate> dateTask, Task task) throws ErrorTask {
        super(dateTask);
        this.task=task;
    }

    @Override
    public void repeatability(LocalDate dateTask) {
        for (int i = 0; i < 50 ; i++) { //
            dateTask = dateTask.plusWeeks(1);
            getTask().getDateTask().add(dateTask);
        }
    }
}
