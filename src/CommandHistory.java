import java.util.ArrayList;

public class CommandHistory {
    private final ArrayList<Command> commands;

    public CommandHistory() {
        this.commands = new ArrayList<>();
    }

    public void push(Command newCommand){
        commands.add(newCommand);
    }

    public Command pop(){
        if(commands.size()!=0) {
            return commands.remove(commands.size()-1);
        }
        return null;
    }

    public void clear() {
        commands.clear();
    }
}
