package de.cadoculus.ocxviewer.views;

import atlantafx.base.theme.Styles;
import atlantafx.base.util.BBCodeParser;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.TextFlow;


public class PrincipalParticularsPage extends BorderPane implements Page {

    public static final String NAME = "Principal Particulars";

    public PrincipalParticularsPage() {
        super();

        //this.setBackground(new Background(new BackgroundFill(Color.web("#bcbcbc"), CornerRadii.EMPTY, Insets.EMPTY)));
        this.setMargin(this, new Insets(15));
        this.setPadding( new Insets(10));
        this.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY,
                BorderStrokeStyle.SOLID, new CornerRadii(10), BorderWidths.DEFAULT)));


        this.maxHeight(1950);
        this.setMaxWidth(1800);
        this.setMinHeight(500);
        this.setMinWidth(500);
        this.setPrefHeight(1024);
        this.setPrefWidth(1200);
;

        var titleBox = new VBox();
        this.setTop(titleBox);


        var title = new Label( NAME);
        title.getStyleClass().add(Styles.TITLE_2);
        titleBox.getChildren().add(title);

        final TextFlow formattedText = BBCodeParser.createFormattedText("Type definition of the  main vessel particulars required by the Society.");
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
        // ocx:Lpp
        var label = new Label("Lpp");
        label.setTooltip(new Tooltip("Length between perpendiculars"));
        gridPane.add(label, 0, ++row);

        // ocx:FreeboardLength
        label = new Label("Freeboard Length");
        label.setTooltip(new Tooltip("The free-board length of the Vessel, Lll."));
        gridPane.add(label, 2, row);

        // ocx:RuleLength
        label = new Label("Rule Length");
        label.setTooltip(new Tooltip("Length of the ship according to the classification society rules"));
        gridPane.add(label, 0, ++row);


        // ocx:LengthOfWaterline" minOccurs="0"/>
        label = new Label("Length of Waterline");
        label.setTooltip(new Tooltip("The length of the waterline at T, Lwl."));
        gridPane.add(label, 2, row);

        //ocx:DeepestEquilibriumWL" minOccurs="0"/>
        label = new Label("Deepest Equilibrium WL");
        label.setTooltip(new Tooltip("Deepest equilibrium waterline in damaged condition."));
        gridPane.add(label, 2, ++row);

        //ocx:FP_Pos
        label = new Label("FP Pos");
        label.setTooltip(new Tooltip("Forward Perpendicular Position"));
        gridPane.add(label, 0, ++row);

        //ocx:AP_Pos
        label = new Label("AP Pos");
        label.setTooltip(new Tooltip("Aftward Perpendicular Position"));
        gridPane.add(label, 2, row);

        //        ocx:MouldedBreadth
        label = new Label("Moulded Breadth");
        label.setTooltip(new Tooltip("The maximum breadth of the ship measured between the moulded lines of the ship"));
        gridPane.add(label, 0, ++row);

        //        ocx:MouldedDepth
        label = new Label("Moulded Depth");
        label.setTooltip(new Tooltip("The moulded depth of the ship, Hm"));
        gridPane.add(label, 2, row);
        //        ocx:ScantlingDraught
        label = new Label("Scantling Draught");
        label.setTooltip(new Tooltip("Design draught moulded, fully loaded condition, Td. The summer load draught used by the classification society in its calculations for structural integrity and strength (see ISO 10303-218, section 4.2.32.6)."));
        gridPane.add(label, 2, ++row);




//ocx:NormalBallastDraught" minOccurs="0"/>
        label = new Label("Normal Ballast Draught");
        label.setTooltip(new Tooltip("The Vessel draught at normal ballast, Tnb."));
        gridPane.add(label, 0, ++row);

//ocx:HeavyBallastDraught" minOccurs="0"/>
        label = new Label("Heavy Ballast Draught");
        label.setTooltip(new Tooltip("The Vessel draught at heavy ballast, Thb."));
        gridPane.add(label, 2, row);

//ocx:SlammingDraughtEmptyFP" minOccurs="0"/>
        label = new Label("Slamming Draught Empty FP");
        label.setTooltip(new Tooltip("The design slamming draught at FP (all ballast tanks empty), Tf-e."));
        gridPane.add(label, 0, ++row);
//ocx:SlammingDraughtFullFP" minOccurs="0"/>
        label = new Label("Slamming Draught Full FP");
        label.setTooltip(new Tooltip("The Vessel draught at FP used when calculation design slamming loads (all ballast tanks full), Tf-f."));
        gridPane.add(label, 2, row);


//ocx:FreeboardDeckHeight" minOccurs="0"/>
        label = new Label("Freeboard Deck Height");
        label.setTooltip(new Tooltip("The height of free-board deck, D1."));
        gridPane.add(label, 0, ++row);

//
//ocx:ZPosOfDeck" minOccurs="0"/>
        label = new Label("ZPos of Deck");
        label.setTooltip(new Tooltip("Z coordinate of the bulkhead deck."));
        gridPane.add(label, 2, row);

//ocx:ZPosDeckline" minOccurs="0"/>
        label = new Label("ZPos of Deckline");
        label.setTooltip(new Tooltip("Vertical distance from baseline to deck-line at FE."));
        gridPane.add(label, 2, ++row);

//ocx:UpperDeckArea" minOccurs="0"/>
        label = new Label("UpperDeckArea");
        label.setTooltip(new Tooltip("Projected area of upper deck forward 0.2 L."));
        gridPane.add(label, 0, ++row);
//ocx:WaterPlaneArea" minOccurs="0"/>
        label = new Label("WaterPlaneArea");
        label.setTooltip(new Tooltip("The area of water-plane forward 0.2 L at scantling draught Td."));
        gridPane.add(label, 2, row);



//ocx:BlockCoefficient
        label = new Label("Block Coefficient");
        label.setTooltip(new Tooltip("The ratio of the moulded displacement volume to the volume of a block that has its length equal to the length class, its breadth equal to the moulded breadth and its depth equal\t\t\t\t\tto the scantlings draught (see ISO 10303-218, section 4.2.32.1)."));
        gridPane.add(label, 0, ++row);
//
//ocx:DesignSpeed
        label = new Label("Design Speed");
        label.setTooltip(new Tooltip("The forward or service speed at which the ship is designed to operate (see ISO 10303-218, section 4.2.32.2)."));
        gridPane.add(label, 0, ++row);

//ocx:SpeedFactor" minOccurs="0"/>
        label = new Label("Speed Factor");
        label.setTooltip(new Tooltip("Speed factor Cav."));
        gridPane.add(label, 2, row);



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
