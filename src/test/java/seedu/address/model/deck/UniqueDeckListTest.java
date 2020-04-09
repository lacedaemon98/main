package seedu.address.model.deck;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.CardUtils.getTypicalJapCards;
import static seedu.address.testutil.DeckUtils.JAPANESE_DECK;
import static seedu.address.testutil.DeckUtils.MALAY_DECK;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.DeckBuilder;

public class UniqueDeckListTest {

    private final UniqueDeckList uniqueDeckList = new UniqueDeckList();

    @Test
    public void contains_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueDeckList.contains(null));
    }

    @Test
    public void contains_deckNotInList_returnsFalse() {
        assertFalse(uniqueDeckList.contains(JAPANESE_DECK));
    }

    @Test
    public void contains_deckInList_returnsTrue() {
        uniqueDeckList.add(JAPANESE_DECK);
        assertTrue(uniqueDeckList.contains(JAPANESE_DECK));
    }

    @Test
    public void contains_deckWithSameIdentityFieldsInList_returnsTrue() {
        uniqueDeckList.add(JAPANESE_DECK);
        Deck newDeck = new DeckBuilder()
                .withName("Japanese")
                .withCards(getTypicalJapCards()).build();
        assertTrue(uniqueDeckList.contains(newDeck));
    }

    @Test
    public void add_nullDeck_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueDeckList.add(null));
    }

    @Test
    public void add_duplicateDeck_doNotAdd() {
        uniqueDeckList.add(JAPANESE_DECK);
        uniqueDeckList.add(JAPANESE_DECK);
        UniqueDeckList expectedUniqueDeckList = new UniqueDeckList();
        expectedUniqueDeckList.add(JAPANESE_DECK);
        assertEquals(expectedUniqueDeckList, uniqueDeckList);
    }




    @Test
    public void setDeck_editedDeckIsSameDeck_success() {
        uniqueDeckList.add(JAPANESE_DECK);
        uniqueDeckList.setDeck(JAPANESE_DECK, MALAY_DECK);
        UniqueDeckList expectedUniqueDeckList = new UniqueDeckList();
        expectedUniqueDeckList.add(MALAY_DECK);
        assertEquals(expectedUniqueDeckList, uniqueDeckList);
    }


    @Test
    public void remove_nullDeck_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueDeckList.remove(null));
    }

    @Test
    public void remove_deckDoesNotExist_donotremove() {
        uniqueDeckList.add(JAPANESE_DECK);
        uniqueDeckList.remove(MALAY_DECK);
        UniqueDeckList expectedUniqueDeckList = new UniqueDeckList();
        expectedUniqueDeckList.add(JAPANESE_DECK);
        assertEquals(expectedUniqueDeckList, uniqueDeckList);
    }

    @Test
    public void remove_existingDeck_removesDeck() {
        uniqueDeckList.add(JAPANESE_DECK);
        uniqueDeckList.remove(JAPANESE_DECK);
        UniqueDeckList expectedUniqueDeckList = new UniqueDeckList();
        assertEquals(expectedUniqueDeckList, uniqueDeckList);
    }

    @Test
    public void setDecks_nullUniqueDeckList_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueDeckList.setDecks((UniqueDeckList) null));
    }

    @Test
    public void setDecks_uniqueDeckList_replacesOwnListWithProvidedUniqueDeckList() {
        uniqueDeckList.add(JAPANESE_DECK);
        UniqueDeckList expectedUniqueDeckList = new UniqueDeckList();
        expectedUniqueDeckList.add(MALAY_DECK);
        uniqueDeckList.setDecks(expectedUniqueDeckList);
        assertEquals(expectedUniqueDeckList, uniqueDeckList);
    }

    @Test
    public void setDecks_nullList_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueDeckList.setDecks((List<Deck>) null));
    }

    @Test
    public void setDecks_list_replacesOwnListWithProvidedList() {
        uniqueDeckList.add(JAPANESE_DECK);
        List<Deck> deckList = Collections.singletonList(MALAY_DECK);
        uniqueDeckList.setDecks(deckList);
        UniqueDeckList expectedUniqueDeckList = new UniqueDeckList();
        expectedUniqueDeckList.add(MALAY_DECK);
        assertEquals(expectedUniqueDeckList, uniqueDeckList);
    }


    @Test
    public void asUnmodifiableObservableList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, ()
            -> uniqueDeckList.asUnmodifiableObservableList().remove(0));
    }
}
