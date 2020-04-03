package seedu.address.ui;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.deck.Deck;
import seedu.address.model.deck.card.Card;

import java.text.DecimalFormat;
import java.util.logging.Logger;

/**
 * The Browser Panel of the App.
 */
public class PlayPanel extends UiPart<Region> {

    private static final String FXML = "PlayPanel.fxml";

    private final Logger logger = LogsCenter.getLogger(getClass());

    private int attempted;

    private int remaining;

    @FXML
    Label front;

    @FXML
    Label back;

    @FXML
    ProgressBar progress;

    @FXML
    Label noAttempted;

    @FXML
    Label noRemaining;

    @FXML
    Label progressPercent;

    @FXML
    Label instruction;




    public PlayPanel(ObservableValue<Card> playingCard, ObservableValue<Boolean> flipped, ObservableValue<Integer> cardAttempted, ObservableValue<Integer> cardRemaining) {
        super(FXML);
        
        back.setVisible(false);
        progress.setProgress(0);
        progressPercent.setText("0.0%");


        //Load playing card
        playingCard.addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                showPlayingCard(newValue);

            }

        });

        //Show back face when flipped
        flipped.addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                back.setVisible(true);
                instruction.setText("Did you get your answer right? Answer 'yes' or 'no'");
            } else {
                back.setVisible(false);
                instruction.setText("Type 'flip' to reveal back face");
            }
        });

        cardAttempted.addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                attempted = newValue;
                setProgress();
                noAttempted.setText(String.valueOf(newValue));
            }
        });

        cardRemaining.addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                remaining = newValue;
                setProgress();
                noRemaining.setText(String.valueOf(newValue));
            }
        });
    }

    private void showPlayingCard(Card card) {
        front.setText(card.getFrontFace().toString());
        front.setWrapText(true);
        back.setText(card.getBackFace().toString());
        back.setWrapText(true);
        instruction.setText("Type 'flip' to reveal back face");
    }

    private void setProgress() {
        double currentProgress = Double.valueOf(attempted)/(attempted+remaining);
        double prog = currentProgress * 100;
        progressPercent.setText(String.format("%.1f", prog)+"%");
        progress.setProgress(currentProgress);
    }


}
