public class ScaleCommand extends Command{
    private final int i;
    private final int j;

    public ScaleCommand(Application application, Editor editor, int i, int j) {
        super(application, editor);
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean execute() {
        saveBackup(i);
        editor.scaleSquare(i,j);
        return true;
    }
}
