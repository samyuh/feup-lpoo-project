package Controller.Interact;

public class Invoker {
    private CommandInteract commandInteract;

    public void setCommandInteract(CommandInteract commandInteract) {
        this.commandInteract = commandInteract;
    }

    public Invoker(CommandInteract commandInteract) {
        this.commandInteract = commandInteract;
    }

    public void executeCommand(){
        commandInteract.execute();
    }
}
