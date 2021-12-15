public class RedoCommand extends Command{

    public RedoCommand(Application application, Editor editor) {
        super(application, editor);
    }

    @Override
    public boolean execute() {
        application.redo();
        return false;
    }
}
