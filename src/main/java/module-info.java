/* doesn't work with source level 1.8:
module com.mycompany.banco {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.banco to javafx.fxml;
    exports com.mycompany.banco;
}
*/
