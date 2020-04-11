package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.deck.card.BackFace;
import seedu.address.model.deck.card.Card;
import seedu.address.model.deck.card.FrontFace;

/**
 * A utility class containing a list of {@code Card} objects to be used in tests.
 */
public class CardUtils {

    public static final String EMPTY_FACE = "";

    public static final Card JAP_CARD_1 = new CardBuilder()
            .withFrontFace("Hello")
            .withBackFace(" こんにちは")
            .build();

    public static final Card JAP_CARD_2 = new CardBuilder()
            .withFrontFace("Goodbye")
            .withBackFace(" さよなら")
            .build();

    public static final Card JAP_CARD_3 = new CardBuilder()
            .withFrontFace("Thank you")
            .withBackFace(" ありがとう")
            .build();

    public static final Card MALAY_CARD_1 = new CardBuilder()
            .withFrontFace("I")
            .withBackFace("Saya")
            .build();

    public static final Card MALAY_CARD_2 = new CardBuilder()
            .withFrontFace("You")
            .withBackFace("Awak")
            .build();

    public static final Card MALAY_CARD_3 = new CardBuilder()
            .withFrontFace("Chicken")
            .withBackFace("Ayam")
            .build();

    private CardUtils() {} // prevents instantiation

    /**
     * Gets the Japanese test deck.
     */
    public static List<Card> JAP_CARDS = new ArrayList<>(
            Arrays.asList(JAP_CARD_1, JAP_CARD_2, JAP_CARD_3));

    /**
     * Gets the Malay test deck.
     */
    public static List<Card> MALAY_CARDS = new ArrayList<>(
            Arrays.asList(MALAY_CARD_1, MALAY_CARD_2, MALAY_CARD_3));

}