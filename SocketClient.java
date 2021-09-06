import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;


public class SocketClient extends Application{
    

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Registration Form JavaFX Application");

        // Create the registration form grid pane
        GridPane gridPane = createRegistrationFormPane();
        // Add UI controls to the registration form grid pane
        addUIControls(gridPane);
        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(gridPane, 800, 500);
        // Set the scene in primary stage	
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }


    private GridPane createRegistrationFormPane() {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(10);

        // Set the vertical gap between rows
        gridPane.setVgap(10);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    private void addUIControls(GridPane gridPane) {
        // Add Header
        Label headerLabel = new Label("Registration Form");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        // Add firstName Label
        Label nameLabel = new Label("First name : ");
        gridPane.add(nameLabel, 0,1);

        // Add firstName Text Field
        TextField nameField = new TextField();
        nameField.setPrefHeight(40);
        gridPane.add(nameField, 1,1);

        // Add lastName Label
        Label lastNameLabel = new Label("Last name : ");
        gridPane.add(lastNameLabel, 0,2);

        // Add lastName Text Field
        TextField lastNameField = new TextField();
        lastNameField.setPrefHeight(40);
        gridPane.add(lastNameField, 1,2);

        // Add facultyName Label
        Label facultyLabel = new Label("Faculty name : ");
        gridPane.add(facultyLabel, 0,3);

        // Add facultyName Text Field
        TextField facultyNameField = new TextField();
        facultyNameField.setPrefHeight(40);
        gridPane.add(facultyNameField, 1,3);

        // Add Coursename Label
        Label courseNameLabel = new Label("Course name : ");
        gridPane.add(courseNameLabel, 0,4);

        // Add courseName Text Field
        TextField courseNameField = new TextField();
        courseNameField.setPrefHeight(40);
        gridPane.add(courseNameField, 1,4);

        // Add Unitname Label
        Label UnitnameLabel = new Label("Unit name : ");
        gridPane.add(UnitnameLabel, 0,5);

        // Add Unitname Text Field
        TextField UnitnameField = new TextField();
        UnitnameField.setPrefHeight(40);
        gridPane.add(UnitnameField, 1,5);

        // Add AdmNo Label
        Label AdmNoLabel = new Label("AdmNo. : ");
        gridPane.add(AdmNoLabel, 0,6);

        // Add AdmNo Text Field
        TextField AdmNoField = new TextField();
        AdmNoField.setPrefHeight(40);
        gridPane.add(AdmNoField, 1,6);

        // Add thankYou Label
        Label thankYouLabel = new Label("Add a thank you note : ");
        gridPane.add(thankYouLabel, 0,7);

        // Add thankYou Text Field
        TextField thankYouField = new TextField();
        thankYouField.setPrefHeight(40);
        gridPane.add(thankYouField, 1,7);

        // Add Submit Button
        Button submitButton = new Button("Submit");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 8, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(nameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your first name");
                    return;
                }
                if(lastNameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your last name");
                    return;
                }
                if(facultyNameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a faculty name");
                    return;
                }
                if(UnitnameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a unit name");
                    return;
                }
                if(AdmNoField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter an AdmNo.");
                    return;
                }
                if(courseNameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a course name");
                    return;
                }
                if(thankYouField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a thank you note");
                    return;
                }


                String names [] = {nameField.getText(),lastNameField.getText()};
                String detailArr [] = {facultyNameField.getText(),courseNameField.getText(),UnitnameField.getText()};

                ClientProtocol clientProtocol = new ClientProtocol();
                try {
                    clientProtocol.startClient(names ,AdmNoField.getText(),detailArr,thankYouField.getText());
                    System.out.println(clientProtocol.getInputLine());
                    showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Registration Successful!", clientProtocol.getInputLine());
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }




    public static void main(String[] args) {
        launch(args);
    }

}
