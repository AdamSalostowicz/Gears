package org.example;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;

import java.net.URL;
import java.util.*;

import static org.example.Velocity.wheels;

public class PrimaryController implements Initializable {

    @FXML
    private Label speedLabel;
    @FXML
    private Spinner cadence;
    @FXML
    private Spinner casette;
    @FXML
    private Spinner chainring;
    @FXML
    private ChoiceBox<String> choiceSecondBoxSize;
    @FXML
    private ChoiceBox<String> choiceBoxSize;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillChoiceBox();
        calculateSpeed();
    }

    private void fillChoiceBox() {
        choiceBoxSize.getItems().addAll("12", "14", "16", "17", "18", "20", "22", "24", "25", "26", "650", "27", "27.5", "700", "29");
    }

    @FXML
    private void fillSecondChoiceBox() {
        String size;
        String width;
        String size1;
        ArrayList<String> sizeList = new ArrayList<>();
        if (choiceBoxSize.getValue() != null) {
            choiceSecondBoxSize.getItems().clear();
            size = choiceBoxSize.getValue();
            for (Wheel wheel: wheels
            ) {
                String[] strings = wheel.getTireSize().split("x");
                size1 = strings[0];
                width = strings[1];
                if (size.equals(size1)) {
                    sizeList.add(width);
                }
            }
            choiceSecondBoxSize.getItems().addAll(sizeList);
        }
        calculateSpeed();
    }

    private void centerTextInBox() {

    }

    @FXML
    private void calculateSpeed() {
        String size = choiceBoxSize.getValue();
        String width = choiceSecondBoxSize.getValue();
        int cad = (int) cadence.getValue();
        int cas = (int) casette.getValue();
        int ring = (int) chainring.getValue();
        double speed;
        double circumstances = calculateCircumstance(size, width);

        speed = (circumstances * cad * 3 * ring) / (50000 * cas);
        speed = Math.round(speed*10)/10.0;
        speedLabel.setText(String.valueOf(speed));
        System.out.println("Calculate speed is working!");
    }

    private double calculateCircumstance(String size, String width) {
        double circumstances;
        String fullSize;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(size);
        stringBuilder.append("x");
        stringBuilder.append(width);
        fullSize = stringBuilder.toString();
        for (Wheel wheel: wheels
             ) {
            if (fullSize.equals(wheel.getTireSize())) {
                circumstances = wheel.getCircumference();
                return circumstances;
            }
        }
        return 0;
    }
}
