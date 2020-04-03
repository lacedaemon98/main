package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.model.Library;
import seedu.address.model.Model;

/**
 * Clears the library.
 */
public class ResetLibraryCommand extends Command {

    public static final String COMMAND_WORD = "reset";
    public static final String MESSAGE_SUCCESS = "Library has been cleared!";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.setLibrary(new Library());
        model.returnToLibrary();
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
