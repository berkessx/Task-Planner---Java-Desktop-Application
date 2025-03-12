package TaskPackage;

public class BirthdayTask extends DecoratorTask{
    String bdMessage;
    public BirthdayTask(TaskPackage.componentTask componentTask, String birthdayMessage) {
        super(componentTask);
        bdMessage = birthdayMessage;
    }

    @Override
    public String toString() {
        return componentTask.toString() + "BirthdayTask [bdMessage=" + bdMessage + "]";
    }
}
