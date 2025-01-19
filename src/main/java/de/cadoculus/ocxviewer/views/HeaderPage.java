package de.cadoculus.ocxviewer.views;

import atlantafx.base.theme.Styles;
import atlantafx.base.util.BBCodeParser;
import de.cadoculus.ocxviewer.MainController;
import de.cadoculus.ocxviewer.models.WorkingContext;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.TextFlow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.Temporal;

public class HeaderPage extends BorderPane implements Page{

    public static final String NAME = "Header Page";
    private static final Logger LOG = LogManager.getLogger(HeaderPage.class);


    public HeaderPage() {
        super();

        this.maxHeight(1950);
        this.setMaxWidth(1800);
        this.setMinHeight(500);
        this.setMinWidth(500);
        this.setPrefHeight(1024);
        this.setPrefWidth(1200);

        this.setMargin(this, new Insets(15));

        this.setStyle( """
         -fx-hgap: 20px;
        -fx-padding: 15px;

        -fx-background-color: -color-bg-default;
        -fx-background-radius: 15px;                         
                         
        -fx-border-radius: 15px;
        -fx-border-width: 1px;
        -fx-border-color: -color-accent-0;""");

        var titleBox = new VBox();
        this.setTop(titleBox);
        var title = new Label( NAME);
        title.getStyleClass().add(Styles.TITLE_2);
        titleBox.setPadding( new Insets(0, 0, 10 , 0));
        titleBox.getChildren().add(title);
        final TextFlow formattedText = BBCodeParser.createFormattedText("Information from the OCX file's header.");
        titleBox.getChildren().add(formattedText);


        ScrollPane scrollPane = new ScrollPane();
        this.setCenter(scrollPane);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        GridPane gridPane = new GridPane();
        //this.setCenter(gridPane);
        //gridPane.setBackground(new Background(new BackgroundFill(Color.web("#edcccc"), CornerRadii.EMPTY, Insets.EMPTY)));

        scrollPane.setContent(gridPane);
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHalignment(HPos.RIGHT);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHalignment(HPos.LEFT);
        col2.setHgrow(Priority.ALWAYS);
        col2.setMaxWidth(600);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setHalignment(HPos.RIGHT);
        ColumnConstraints col4 = new ColumnConstraints();
        col4.setHalignment(HPos.LEFT);
        col4.setHgrow(Priority.ALWAYS);
        col4.setMaxWidth(600);

        gridPane.getColumnConstraints().addAll(col1,col2, col3, col4);
        gridPane.setStyle("-fx-hgap: 10; -fx-vgap: 10; -fx-padding: 10;");

          //<ocx:Header name="OCX-MODEL1/A" author="MJ" organization="NAPA" originating_system="NAPA Steel" documentation="OCX Export" application_version="TNAPA Release B9999 2024.9 sonmy x64 T" time_stamp="2024-09-17T13:25:33.8320118+03:00" />

        int row = 0;
        // Newbuilding Society
        var label = new Label("File Identification");
        label.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(label, 0, row++, 2,1);
        GridPane.setHalignment(label, HPos.LEFT);

        label = new Label("Author");
        label.setTooltip(new Tooltip("Name of the XML instance."));
        gridPane.add(label, 0, row);
        var textField = new TextField();
        textField.textProperty().bindBidirectional( WorkingContext.getInstance().getOcx().getHeader().Author);
        gridPane.add(textField, 1, row);


        label = new Label("Organization");
        label.setTooltip(new Tooltip("Name of originating organization."));
        gridPane.add(label, 2,row);
        textField = new TextField();
        textField.textProperty().bindBidirectional( WorkingContext.getInstance().getOcx().getHeader().Organization);
        gridPane.add(textField, 3, row++);


        label = new Label("Time Stamp");
        label.setTooltip(new Tooltip("Time stamp of the instance."));
        gridPane.add(label, 2, row);
        textField = new TextField();

        textField.textProperty().bindBidirectional( WorkingContext.getInstance().getOcx().getHeader().TimeStamp, new HPStringConverter());
        gridPane.add(textField, 3, row++);


        label = new Label("Source System");
        label.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(label, 0, row++, 2,1);
        GridPane.setHalignment(label, HPos.LEFT);
        GridPane.setMargin(label, new Insets(10, 0, 10, 0));

        label = new Label("Originating System");
        label.setTooltip(new Tooltip("Name of originating system or application."));
        gridPane.add(label, 0, row);
        textField = new TextField();
        textField.textProperty().bindBidirectional( WorkingContext.getInstance().getOcx().getHeader().OriginatingSystem);
        gridPane.add(textField, 1, row);


        label = new Label("Application Version");
        label.setTooltip(new Tooltip("Version of originating application."));
        gridPane.add(label, 2,row);

        textField = new TextField();
        textField.textProperty().bindBidirectional( WorkingContext.getInstance().getOcx().getHeader().ApplicationVersion);
        gridPane.add(textField, 3, row++);

        label = new Label("Documentation");
        label.getStyleClass().add(Styles.TITLE_4);
        label.setTooltip(new Tooltip("Documentation of the content of the XML file."));
        gridPane.add(label, 0, row,2,1);
        GridPane.setMargin(label, new Insets(10, 0, 10, 0));
        GridPane.setHalignment(label, HPos.LEFT);

        textField = new TextField();
        textField.textProperty().bindBidirectional( WorkingContext.getInstance().getOcx().getHeader().Documentation);
        gridPane.add(textField, 1, row, 3, 1);


    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public Pane getView() {
        return this;
    }

    private class HPStringConverter extends Format {
        private final DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);

        @Override
        public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
            if ( obj instanceof Temporal) {
                toAppendTo.append( formatter.format((Temporal) obj));
            } else {
                toAppendTo.append(obj.toString());
            }
            return toAppendTo;
        }

        @Override
        public Object parseObject(String source, ParsePosition pos) {
            return null;
        }
    }
}
