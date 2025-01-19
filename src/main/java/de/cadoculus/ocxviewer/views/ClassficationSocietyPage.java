package de.cadoculus.ocxviewer.views;

import atlantafx.base.theme.Styles;
import atlantafx.base.util.BBCodeParser;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.TextFlow;


public class ClassficationSocietyPage extends BorderPane implements Page {

    public static final String NAME = "Classfication Society";
    private final TextField classNotationHull;
    private final TextField classNotationMachinery;
    private final TextField classNotationIceClass;
    private final TextField classNotationServiceArea;
    private final TextField classNotationServiceFactor;
    private final TextField classNotationAdditional;

    public ClassficationSocietyPage() {
        super();

        //this.setBackground(new Background(new BackgroundFill(Color.web("#bcbcbc"), CornerRadii.EMPTY, Insets.EMPTY)));
        this.setMargin(this, new Insets(15));
//        this.setPadding( new Insets(10));
//        this.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY,
//                BorderStrokeStyle.SOLID, new CornerRadii(10), BorderWidths.DEFAULT)));




        this.maxHeight(1950);
        this.setMaxWidth(1800);
        this.setMinHeight(500);
        this.setMinWidth(500);
        this.setPrefHeight(1024);
        this.setPrefWidth(1200);
;
        this.setStyle( """
         -fx-hgap: 20px;
        -fx-padding: 15px;

        -fx-background-color: -color-bg-default;
        -fx-background-radius: 15px;                         
                         
        -fx-border-radius: 15px;
        -fx-border-width: 1px;
        -fx-border-color: -color-accent-0;""");


        this.setMargin(this, new Insets(15));

        var titleBox = new VBox();
        this.setTop(titleBox);
        var title = new Label( NAME);
        title.getStyleClass().add(Styles.TITLE_2);
        titleBox.setPadding( new Insets(0, 0, 10 , 0));
        titleBox.getChildren().add(title);
        final TextFlow formattedText = BBCodeParser.createFormattedText("Information that specifies design and intended performance characteristics of the ship in accordance with classification society rules and statutory regulations (see ISO 10303-218, section 4.2.36).");
        titleBox.getChildren().add(formattedText);

        //formattedText.setBackground(new Background(new BackgroundFill(Color.web("#cdcdcd"), CornerRadii.EMPTY, Insets.EMPTY)));

        ScrollPane scrollPane = new ScrollPane();
        this.setCenter(scrollPane);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        GridPane gridPane = new GridPane();
        //gridPane.setBackground(new Background(new BackgroundFill(Color.web("#edcccc"), CornerRadii.EMPTY, Insets.EMPTY)));

        scrollPane.setContent(gridPane);
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHalignment(HPos.RIGHT);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHalignment(HPos.LEFT);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setHalignment(HPos.RIGHT);
        ColumnConstraints col4 = new ColumnConstraints();
        col4.setHalignment(HPos.LEFT);

        gridPane.getColumnConstraints().addAll(col1,col2, col3, col4);


        gridPane.setHgap(10); //horizontal gap in pixels => that's what you are asking for
        gridPane.setVgap(10); //vertical gap in pixels
        gridPane.setPadding(new Insets(10, 0, 0, 10)); //margins around the whole grid
        //(top/right/bottom/left)


        int row = 0;
        // Newbuilding Society
        var label = new Label("Classification");
        label.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(label, 0, ++row);

        label = new Label("Newbuilding Society");
        label.setTooltip(new Tooltip("The name and organizational details of the classification society whose rules and regulations are being used to assess the ship during construction."));
        gridPane.add(label, 0, ++row);

        var combo = new ComboBox<String>();
        combo.getItems().addAll("ABS", "BV", "CCS", "DNV", "GL", "KR", "LR", "NK", "NV", "PR", "RS", "RINA", "OTHER");
        gridPane.add(combo, 1, row);

        label = new Label("Newbuilding Society Name");
        label.setTooltip(new Tooltip("The common name of the class society relevant for operating the ship. Needs only to be specified when @newbuildingSociety = OTHER"));
        gridPane.add(label, 2, row);

        var textField = new TextField();
        gridPane.add(textField, 3, row);

        // Society

        label = new Label("Society");
        label.setTooltip(new Tooltip("The name and organizational details of the classification society whose rules and regulations are being used to assess the ship during construction."));
        gridPane.add(label, 0, ++row);

        combo = new ComboBox<String>();
        combo.getItems().addAll("ABS", "BV", "CCS", "DNV", "GL", "KR", "LR", "NK", "NV", "PR", "RS", "RINA", "OTHER");
        gridPane.add(combo, 1, row);

        label = new Label("Society Name");
        label.setTooltip(new Tooltip("The common name of the class society relevant for operating the ship. Needs only to be specified when @society = OTHER"));
        gridPane.add(label, 2, row);

        textField = new TextField();
        gridPane.add(textField, 3, row);


        label = new Label("Class Notation");
        label.setTooltip(new Tooltip("The notations given to the hull and machinery of the Ship by the classification society as a result of its approval activities during the design, manufacture and in-service maintenance of the ship (see ISO 10303-218, section 4.2.35)"));
        label.getStyleClass().add(Styles.TITLE_4);
        gridPane.add(label, 0, ++row);

        label = new Label("Hull");
        label.setTooltip(new Tooltip("The notation given to the hull of the ship by the classification society as a result of its approval activities done on the hull."));
        gridPane.add(label, 0, ++row);
        classNotationHull = new TextField();
        gridPane.add(classNotationHull, 1, row);


        label = new Label("Machinery");
        label.setTooltip(new Tooltip("The notation given to the machinery on the ship by the classification society as a result of its approval activities done on the machinery."));
        gridPane.add(label, 2, row);
        classNotationMachinery = new TextField();
        gridPane.add(classNotationMachinery, 3, row);

        label = new Label("Service Area");
        label.setTooltip(new Tooltip("The area or route in which the ship operates. NOTE: This may include information about waterway, wave, weather and wind conditions."));
        gridPane.add(label, 0, ++row);
        classNotationServiceArea = new TextField();
        gridPane.add(classNotationServiceArea, 1, row);

        label = new Label("Service Factor");
        label.setTooltip(new Tooltip("The service area of the ship and the waves that occur in that area. The service factor should be in the range of 0.5 to 1.0."));
        gridPane.add(label, 2, row);
        classNotationServiceFactor = new TextField();
        gridPane.add(classNotationServiceFactor, 3, row);


        label = new Label("Ice Class");
        label.setTooltip(new Tooltip("The type of class notation given to the ship indicating the ice conditions in which the ship has been approved to operate."));
        gridPane.add(label, 0, ++row);
        classNotationIceClass = new TextField();
        gridPane.add(classNotationIceClass, 1, row);


        label = new Label("Additional Annotations");
        label.setTooltip(new Tooltip("Additional notations assigned by the society."));
        gridPane.add(label, 0, ++row);
        classNotationAdditional = new TextField();
        gridPane.add(classNotationAdditional, 1, row);


    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public Pane getView() {
        return this;
    }

}
