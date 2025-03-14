package ex05;

import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sviatik-fedora
 */
public interface Command {
    void execute();
    void undo();

    class MacroCommand implements Command {
        private final List<Command> commands = new ArrayList<>();

        public void addCommand(Command command) {
            commands.add(command);
        }

        @Override
        public void execute() {
            commands.forEach(Command::execute);
        }

        @Override
        public void undo() {
            for (int i = commands.size() - 1; i >= 0; i--) {
                commands.get(i).undo();
            }
        }
    }

    class History {
        private final Stack<Command> stack = new Stack<>();

        public void push(Command command) {
            stack.push(command);
        }

        public Command pop() {
            return stack.pop();
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }
    }
}

