import entities.Movements;
import entities.Weapons;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String args[]){
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Movements.loadList();
        Movements.loadListName();
        Weapons.loadList();
        Weapons.loadListName();

        FXMLLoader menuSceneLoader = new FXMLLoader(getClass().getResource("/menu/menu.fxml"));
        Parent root = menuSceneLoader.load();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
