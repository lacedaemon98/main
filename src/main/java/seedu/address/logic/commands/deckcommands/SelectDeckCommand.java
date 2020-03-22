package seedu.address.logic.commands.deckcommands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.deck.Deck;
import seedu.address.model.util.Mode;

import java.util.List;

/**
 * Selects a deck in the library.
 */
public class SelectDeckCommand extends Command {

    public static final String COMMAND_WORD = "select";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Selects a deck in the library.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example:" + COMMAND_WORD + " 1";

    public static final String MESSAGE_SUCCESS = "Deck selected: %1$s";

    // not needed, parser handles invalid index, unless for invalid list, but
    // remove deck also doesnt has this, so should not need
    public static final String MESSAGE_DECK_NOT_FOUND = "Deck not found in the library!";

    private final Index targetIdx;

    /**
     * Creates an AddCommand to add the specified {@code Deck}
     */
    public SelectDeckCommand(Index targetIdx) {
        requireNonNull(targetIdx);
        this.targetIdx = targetIdx;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        /* not needed, parser handles invalid index
        if (!model.hasDeck(toSelect)) {
            throw new CommandException(MESSAGE_DECK_NOT_FOUND);
        }
        */

        List<Deck> filteredDeckList = model.getFilteredDeckList();

        model.selectDeck(targetIdx);
        model.setSelectedDeck(filteredDeckList.get(targetIdx.getZeroBased()));
        model.setCurrentMode(Mode.VIEW);

        Deck selectedDeck = model.getDeck(targetIdx);
        return new CommandResult(String.format(MESSAGE_SUCCESS, selectedDeck));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof SelectDeckCommand // instanceof handles nulls
                && targetIdx.equals(((SelectDeckCommand) other).targetIdx));
    }
}
