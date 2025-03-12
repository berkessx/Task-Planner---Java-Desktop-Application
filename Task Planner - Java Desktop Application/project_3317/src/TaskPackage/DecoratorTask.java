package TaskPackage;

public abstract class DecoratorTask {
    componentTask componentTask;
    public DecoratorTask(componentTask componentTask) {
        this.componentTask = componentTask;
    }
}
