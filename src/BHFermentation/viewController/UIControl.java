/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHFermentation.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class UIControl {

    @FXML
    private TableView<?> ChamberOneTable;

    @FXML
    private TableColumn<?, ?> ChamberOneTableColumnVessel;

    @FXML
    private TableColumn<?, ?> ChamberOneTableColumnStatus;

    @FXML
    private TableColumn<?, ?> ChamberOneTableColumnTemp;

    @FXML
    private TextField ChamberOneHeaterStatus;

    @FXML
    private TextField ChamberOneFanStatus;

    @FXML
    private TextField ChamberOneHeaterPercentage;

    @FXML
    private TextField ChamberOneValveStatus;

    @FXML
    private TextField ChamberOneValvePercentage;

    @FXML
    private TextField ChamberOneTemp;

    @FXML
    private TextField GlycolTemp;

    @FXML
    private TextField ChillerStatus;

    @FXML
    private TextField PumpStatus;

    @FXML
    private TextField BypassStatus;

    @FXML
    private TableView<?> ChamberTwoTable;

    @FXML
    private TableColumn<?, ?> ChamberTwoTableColumnVessel;

    @FXML
    private TableColumn<?, ?> ChamberTwoTableColumnStatus;

    @FXML
    private TableColumn<?, ?> ChamberTwoTableColumnTemp;

    @FXML
    private TextField ChamberTwoHeaterStatus;

    @FXML
    private TextField ChamberTwoFanStatus;

    @FXML
    private TextField ChamberTwoHeaterPercentage;

    @FXML
    private TextField ChamberTwoValveStatus;

    @FXML
    private TextField ChamberTwoValvePercentage;

    @FXML
    private TextField ChamberTwoTemp;

    @FXML
    private TextField AmbientTemp;

    @FXML
    private TextField ChestFreezerTemp;

    @FXML
    private TextField ChestFreezerStatus;

    @FXML
    private TextField ChestFreezerTemp2;

    @FXML
    private TextField AmbientStatus;

}
