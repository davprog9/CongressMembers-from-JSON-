package org.example;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import javafx.scene.control.*;


public class ControllerGUI {

    @FXML
    private Label WelcomeLabel;

    @FXML
    private TextField textFieldCommand;

    @FXML
    private Button getByNameButton;

    @FXML
    private Button getNumberOfMembersButton;

    @FXML
    private Button getNOldestPeopleButton;

    @FXML
    private Button getAverageAgeForPartyButton;

    @FXML
    private Button getYoungestDemocratButton;

    @FXML
    private TextArea resultLabel;

    @FXML
    public void initialize() throws IOException {
        System.out.println("Running the app!");

    }

    /**
     * When number of members button is clicked.
     * Displays the number of members for a party
     * @param event defines the action event
     * @throws IOException IOException
     * @author David Arzumanyan
     */
    @FXML
    public void getNumberOfMembersButtonClicked(ActionEvent event) throws IOException {
        CongressFinder members = new CongressFinder(CongressPersonLoader.load_from_file("/legislators-current.json"));

        int data = members.NumberOfPeopleInEachParty(this.textFieldCommand.getText());

        if (this.textFieldCommand.getText().equals("democrat")){
            this.resultLabel.setText(String.valueOf("There are " + data + " " + this.textFieldCommand.getText() + "s!"));
        } else if (this.textFieldCommand.getText().equals("republican")) {
            this.resultLabel.setText(String.valueOf("There are " + data + " " + this.textFieldCommand.getText() + "s!"));
        }else{
            this.resultLabel.setText("Wrong party name was provided, democrat/republican should be chosen! ");
        }

    }

    /**
     * Displays the name of the chosen congress member
     * @param event defines the action event
     * @throws IOException IOException
     * @author David Arzumanyan
     */
    public void getByNameButtonClicked(ActionEvent event) throws IOException {
        CongressFinder members = new CongressFinder(CongressPersonLoader.load_from_file("/legislators-current.json"));

        if (this.textFieldCommand.getText().isEmpty()){
            this.resultLabel.setText("Provide known congress member's first and last name - example Sherrod Brown");
        }

        String[] splitedData = this.textFieldCommand.getText().split(" ");
        String member = members.getByName(splitedData[0], splitedData[1]);

        this.resultLabel.setText(member);


    }

    /**
     * Displays N olders people from CongressPerson list
     * @param event defines the action event
     * @throws IOException IOException
     * @author David Arzumanyan
     */
    public void getNOldestPeopleButtonClicked(ActionEvent event) throws IOException {
        CongressFinder members = new CongressFinder(CongressPersonLoader.load_from_file("/legislators-current.json"));

        List<CongressPerson> sortingNOldestPeople = members.CustomSortedListOfOldestPeople(Integer.parseInt(this.textFieldCommand.getText()));
        this.resultLabel.setText(sortingNOldestPeople.toString());

    }

    /**
     * Displays the average age for the chosen party
     * @param actionEvent defines the action event
     * @throws IOException IOException
     * @author David Arzumanyan
     */
    public void getAverageAgeForPartyButtonClicked(ActionEvent actionEvent) throws IOException {
        CongressFinder members = new CongressFinder(CongressPersonLoader.load_from_file("/legislators-current.json"));

        HashMap<String, Integer> data = members.averageAgeCalculator();
        if (this.textFieldCommand.getText().equals("democrat")){
            this.resultLabel.setText("The average age of democrats is " + String.valueOf(data.get("Democrats")));
        } else if (this.textFieldCommand.getText().equals("republican")) {
            this.resultLabel.setText("The average age of republicans is " + String.valueOf(data.get("Republicans")));
        }else{
            this.resultLabel.setText("Wrong party was provided please provide one of these democrat/republican");
        }
    }

    /**
     * Displays the youngest person from CongressPerson list
     * @param actionEvent defines the action event
     * @throws IOException IOException
     * @author David Arzumanyan
     */
    public void getYoungestDemocratButtonClicked(ActionEvent actionEvent) throws IOException {
        CongressFinder members = new CongressFinder(CongressPersonLoader.load_from_file("/legislators-current.json"));

        CongressPerson youngestDemocrat = members.youngestDemocrat();
        this.resultLabel.setText(String.valueOf(youngestDemocrat));
    }
}
