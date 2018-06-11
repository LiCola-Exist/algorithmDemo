package design.command;

/**
 * Created by LiCola on 2018/6/8.
 * 命令接口，声明执行的操作
 */
public interface Command {

    /**
     * 执行命令对应的操作
     */
    void execute();
}
