package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * José Javier Bermúdez Hernández
 *
 * Validar JavaFX TextField como Integer
 */
public class JavaFXvalidarInteger extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Crear etiqueta para escribir lo qeu se pide al usuario
        Label etiInfo = new Label();
        etiInfo.setText("Introduzca un número entero");

        // Crear campo de texto donde se espera que se escriba el número
        TextField textIn = new TextField();

        // Crear etiqueta donde el programa escribirá el resultado
        Label etiRespuesta = new Label();

        // Crear botón de acptar
        Button boton = new Button("Aceptar");
        boton.setOnAction(new EventHandler<ActionEvent>() {
                              @Override
                              public void handle(ActionEvent e) {
                                  // Convertir el texto en Integer, sin salta la excepción será porque
                                  // el usuario no introdujo un entero.
                                  try {
                                      Integer i = Integer.parseInt(textIn.getText());
                                      etiRespuesta.setText("Correcto: " + i);
                                  } catch (NumberFormatException excep) {
                                      etiRespuesta.setText("¡No es un entero!");
                                  }
                              }
                          });
        /*
        // Crear manejador de evento para el botón (empleamos notación lambda)
        boton.setOnAction((ActionEvent event) -> {
            // Convertir el texto en Integer, sin salta la excepción será porque
            // el usuario no introdujo un entero.
            try{
                Integer i = Integer.parseInt(textIn.getText());
                etiRespuesta.setText("Correcto: " + i);
            }catch (NumberFormatException e){
                etiRespuesta.setText("¡No es un entero!");
            }
        });
        */

        // Crear un layout
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(20));
        vBox.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
        // Añadir los controles al layout
        vBox.getChildren().addAll(etiInfo, textIn, boton, etiRespuesta);

        // Crear la escena
        Scene scene = new Scene(vBox, 400, 200);
        // Añadir estilos en fichero css
        //scene.getStylesheets().add("/recursos/css/estilos.css");
        scene.getStylesheets().add(this.getClass().getResource("estilos.css").toString());
        // Establecer el título del escenario
        primaryStage.setTitle("Probando validaciones");
        // Añadir la escena al escenario
        primaryStage.setScene(scene);
        // Mostrar el escenario
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}


