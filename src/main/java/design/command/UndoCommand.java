package design.command;

/**
 * Created by LiCola on 2018/6/11.
 */
public class UndoCommand implements Command {

  private Receiver receiver;

  public UndoCommand(Receiver receiver) {
    this.receiver = receiver;
  }

  @Override
  public void execute() {
    receiver.undo();
  }
}
