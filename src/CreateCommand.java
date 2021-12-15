public class CreateCommand extends Command{
    public int i;
    public int j;

    public CreateCommand(Application application, Editor editor, int i, int j) {
        super(application, editor);
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean execute() {
        saveBackup(i);
        editor.createSquare(i, j);
        return true;
    }
}
