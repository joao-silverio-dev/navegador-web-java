import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Main extends Application {
    public void start(Stage stage) {
        TextField url = new TextField();
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();

        url.setOnAction(evento -> webEngine.load(formataURL(url.getText())));

        VBox vBox = new VBox();
        vBox.getChildren().addAll(url, webView);
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }

    public String formataURL(String url) {
        if (!url.startsWith("http://") || !url.startsWith("https://")) {
            url = "https://" + url;
        }
        return url;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
