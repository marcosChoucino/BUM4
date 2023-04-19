package eus.ehu.final2;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import com.google.gson.Gson;
import javafx.scene.control.CheckBox;

public class HelloController {
    int n = 0;
    List<Status> Lista;
    @FXML
    private ResourceBundle resources;
    private WebEngine webEngine;
    @FXML
    private URL location;

    @FXML
    private TextField authorField;

    @FXML
    private CheckBox boosted;
    @FXML
    private WebView contendField;
    @FXML
    private TextField dateFIeld;

    @FXML
    void NextAction(ActionEvent event) {
        if(n<Lista.size()-1){
            n++;
            actualizar();


        }
    }

    @FXML
    void PreviusAction(ActionEvent event) {
        if(n !=0){
            n--;
            actualizar();


        }
    }

    @FXML
    void initialize() throws IOException {

        webEngine = contendField.getEngine();
        String id = "109903425109125819";
        Gson gson = new Gson();

        Lista = Utils.dameList();
        webEngine.loadContent(Lista.get(n).content);
        actualizar();
    }
    void actualizar() {
        if (Lista.get(n).reblog == null) {
            boosted.setSelected(false);
            webEngine.loadContent(Lista.get(n).content);
            authorField.setText(Lista.get(n).account.username);
            dateFIeld.setText(Lista.get(n).created_at);

        }
        else {
            boosted.setSelected(true);
            webEngine.loadContent(Lista.get(n).reblog.content);
            authorField.setText(Lista.get(n).reblog.account.username);
            dateFIeld.setText(Lista.get(n).reblog.created_at);
        }
    }
}
