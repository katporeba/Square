public class PrintCommand extends Command{
    public PrintCommand(Application application, Editor editor) {
        super(application, editor);
    }

    @Override
    public boolean execute() {
        editor.printSquares();
        return false;
    }
}
