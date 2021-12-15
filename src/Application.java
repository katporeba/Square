import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    private final Editor editor;
    private final CommandHistory commandHistory;
    private final CommandHistory commandHistoryRedo;


    public Application() {
        this.editor = new Editor();
        this.commandHistory = new CommandHistory();
        this.commandHistoryRedo = new CommandHistory();
    }

    public void handleCommands() throws IOException {
        Command command = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] arguments = reader.readLine().split(" ");

        if(arguments[0].equals("C"))
            command = new CreateCommand(this, editor, Integer.parseInt(arguments[1]),Integer.parseInt(arguments[2]));

        if(arguments[0].equals("M"))
            command = new MoveCommand(this, editor, Integer.parseInt(arguments[1]),Integer.parseInt(arguments[2]), Integer.parseInt(arguments[3]));

        if(arguments[0].equals("S"))
            command = new ScaleCommand(this, editor, Integer.parseInt(arguments[1]),Integer.parseInt(arguments[2]));

        if(arguments[0].equals("P"))
            command = new PrintCommand(this, editor);

        if(arguments[0].equals("U"))
            command = new UndoCommand(this, editor);

        if(arguments[0].equals("R"))
            command = new RedoCommand(this, editor);

        executeCommand(command);
    }

    public void executeCommand(Command command) {
        if(command != null)
            if(command.execute()) {
                commandHistory.push(command);
                commandHistoryRedo.clear();
            }
    }

    public void undo(){
        Command command = commandHistory.pop();
        if(command!=null) {
            command.undo();
            commandHistoryRedo.push(command);
        }
    }

    public void redo(){
        Command command = commandHistoryRedo.pop();
        if(command!=null) {
            command.undo();
            commandHistory.push(command);
        }
    }
}
