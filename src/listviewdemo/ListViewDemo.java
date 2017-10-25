    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package listviewdemo;

    import java.util.Observable;
    import javafx.application.Application;
    import javafx.beans.value.ChangeListener;
    import javafx.beans.value.ObservableValue;
    import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;
    import javafx.event.ActionEvent;
    import javafx.event.EventHandler;
    import javafx.geometry.Orientation;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.scene.control.ListView;
    import javafx.scene.control.MultipleSelectionModel;
    import javafx.scene.layout.FlowPane;
    import javafx.scene.layout.StackPane;
    import javafx.stage.Stage;

    /**
     *
     * @author Yasser Muhamed
 */
public class ListViewDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Label labelItem = new Label("Select admin from list");
        Label labelSelectedItem = new Label("you select");
        
        // Create ListView
        // first define dataset
        ObservableList<String> accounts = FXCollections.observableArrayList( "admin" , "Tester", "QA" ,"developer");
        // second define listView and move data to it
        ListView<String> listVeiwAccount = new ListView<String>(accounts);
        
        listVeiwAccount.setPrefSize(300 , 150 );
        listVeiwAccount.setOrientation(Orientation.VERTICAL);
        // third define multi select options
        MultipleSelectionModel<String> multipleSelectionModel = listVeiwAccount.getSelectionModel();
        multipleSelectionModel.selectedItemProperty().addListener( new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("Selected : "  + newValue);
                 
                labelSelectedItem.setText("You Selected : "  + newValue);
             
            }
            
            
            
            
        });
        
       
        FlowPane root = new FlowPane();
        root.setOrientation(Orientation.VERTICAL);
        root.getChildren().add(labelItem);
        root.getChildren().add(listVeiwAccount);
        
        root.getChildren().add(labelSelectedItem);
        
        Scene scene = new Scene(root, 400, 350);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
