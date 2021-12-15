public class MoveCommand extends Command{
    private final int i;
    private final int j;
    private final int k;

    public MoveCommand(Application application, Editor editor, int i, int j, int k) {
        super(application, editor);
        this.i = i;
        this.j = j;
        this.k = k;
    }

    @Override
    public boolean execute() {
        saveBackup(i);
        editor.moveSquare(i,j,k);
        return true;
    }
}
