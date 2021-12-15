public abstract class Command {
    protected Application application;
    protected Editor editor;
    protected Square backupSquare;

    public Command(Application application, Editor editor) {
        this.application = application;
        this.editor = editor;
    }

    public abstract boolean execute();

    public void saveBackup(int i){
        int index = editor.returnIndexOfI(i);
        if (index != -1) backupSquare = (Square) editor.getSquares().get(index).clone();
    }

    public void undo() {
        backupSquare = editor.setSquare(backupSquare);
    }
}
