module eus.ehu.final2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires okhttp3;
    requires com.google.gson;
    requires javafx.web;

    opens eus.ehu.final2 to javafx.fxml,com.google.gson;
    exports eus.ehu.final2;
}