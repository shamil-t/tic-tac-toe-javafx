module com.shamilt.myapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens com.shamilt.myapp to javafx.fxml;
    exports com.shamilt.myapp;
}