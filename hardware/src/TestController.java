import javafx.application.Application;
import javafx.stage.Stage;

public class TestController extends Application {
    public static void main(String[] args){ launch(args);};

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        testView = new TestView();
        window.setScene(testView.getScene());

        window.setMaximized(true);
        window.show();
    }

    private Stage window;
    private TestView testView;

}
