package io.sitoolkit.wt.gui.pres.editor.testscript;

import org.apache.commons.lang3.StringUtils;
import org.controlsfx.control.spreadsheet.SpreadsheetCell;
import org.controlsfx.control.spreadsheet.SpreadsheetCellBase;
import org.controlsfx.control.spreadsheet.SpreadsheetCellEditor;
import org.controlsfx.control.spreadsheet.SpreadsheetCellType;
import org.controlsfx.control.spreadsheet.SpreadsheetView;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;

public class BooleanCellType extends SpreadsheetCellType<Boolean> {

    private static final String FALSE_VALUE = "";
    private static final String TRUE_VALUE = "y";

    public SpreadsheetCell createCell(int row, int column, int rowSpan, int columnSpan,
            String value) {
        SpreadsheetCell cell = new SpreadsheetCellBase(row, column, rowSpan, columnSpan, this);

        boolean convertedValue = convertValue(value);
        cell.setItem(convertedValue);
        cell.getStyleClass().add("boolean-type");

        CheckBox checkBox = new CheckBox();
        checkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
                    Boolean newValue) {
                cell.setEditable(true);
                cell.setItem(newValue);
                cell.setEditable(false);
            }
        });
        checkBox.setSelected(convertedValue);
        cell.setGraphic(checkBox);

        return cell;
    }

    @Override
    public SpreadsheetCellEditor createEditor(SpreadsheetView view) {
        return null;
    }

    @Override
    public String toString(Boolean value) {
        return value ? TRUE_VALUE : FALSE_VALUE;
    }

    @Override
    public boolean match(Object value) {
        return true;
    }

    @Override
    public Boolean convertValue(Object value) {
        if (value instanceof String) {
            return StringUtils.isNotBlank((String) value);
        } else if (value instanceof Boolean) {
            return (Boolean) value;
        } else {
            return false;
        }
    }

}
