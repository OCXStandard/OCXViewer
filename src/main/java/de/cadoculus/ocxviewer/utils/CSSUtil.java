/*
 * Copyright 2026 Carsten Zerbst
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.cadoculus.ocxviewer.utils;


import de.cadoculus.ocxviewer.models.CSSRecord;
import de.cadoculus.ocxviewer.models.WorkingContext;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Utility class for looking up CSS properties for a given identifier.
 * The idea is to configure colours and widths in the light.css or dark.css and then look them up here to use them in the application
 * in those cases, where colours and widths cannot be set via CSS, e.g. for the canvas paintings.
 * E.g. to configure the colour for the brackets, you can add the following to the CSS file:
 *<pre>
 *#bracket {
 *     -fx-background-color:-color-success-4;
 *     -fx-border-color:-color-success-6;
 *     -fx-border-width:1px;
 *     -fx-font-size: 10px;
 *     -fx-text-fill: black;
 *}
 *</pre>
 * and then retrieve the colours and widths via {@code CSSUtil.lookup("bracket")} and use the returned record to get the colours and widths.
 *
 * The CSS could contain up to 4 different border colours and widths, use
 * <pre>
 *     -fx-border-color: red green blue yellow;
 *     -fx-border-width: 0 0 2px 0;
 * </pre>
 *
 * The fifth colour and width in the record are read from text fill colour and font size.
 *
 * The record returned by the lookup method contains the identifier, the background fill colour,
 * the 4 border colours and the 4 border widths in the order top, right, bottom, left, the text fill colour and the font size.
 * *
 * @author Carsten Zerbst
 */
public class CSSUtil {
    private static final Logger LOG = LogManager.getLogger(CSSUtil.class);

    public static CSSRecord lookup(String identifier) {

        var stylesheets = WorkingContext.getInstance().getMainScene().getStylesheets();
        LOG.debug("stylesheets: {}", stylesheets);

        var pane = new HBox();
        var label1 = new Button("test");
        label1.setId(identifier);
        pane.getChildren().add(label1);

        Scene sceneAux = new Scene(pane);
        sceneAux.getStylesheets().addAll(stylesheets);
        pane.applyCss();

        Color colourFill = null;
        Color colour1 = null;
        Color colour2 = null;
        Color colour3 = null;
        Color colour4 = null;
        Color colour5 = null;
        double width1 = Double.NaN;
        double width2 = Double.NaN;
        double width3 = Double.NaN;
        double width4 = Double.NaN;
        double width5 = Double.NaN;
        try {
            colourFill = (Color) label1.getBackground().getFills().getFirst().getFill();
        } catch (Exception e) {
            LOG.debug("Could not get background fill for {}", identifier, e);
        }
        try {
            colour1 = (Color) label1.getBorder().getStrokes().getFirst().getTopStroke();
            colour2 = (Color) label1.getBorder().getStrokes().getFirst().getRightStroke();
            colour3 = (Color) label1.getBorder().getStrokes().getFirst().getBottomStroke();
            colour4 = (Color) label1.getBorder().getStrokes().getFirst().getLeftStroke();

        } catch (Exception e) {
            LOG.debug("Could not get border stroke for {}", identifier, e);
        }
        try {
            colour5 = (Color) label1.getTextFill();
        } catch (Exception e) {
            LOG.debug("Could not get text fill for {}", identifier, e);
        }

        try {
            width1 = label1.getBorder().getStrokes().getFirst().getWidths().getTop();
            width2 = label1.getBorder().getStrokes().getFirst().getWidths().getRight();
            width3 = label1.getBorder().getStrokes().getFirst().getWidths().getBottom();
            width4 = label1.getBorder().getStrokes().getFirst().getWidths().getLeft();
        } catch (Exception e) {
            LOG.debug("Could not get border stroke for {}", identifier, e);
        }
        try {
            width5= label1.getFont().getSize();
        } catch (Exception e) {
            LOG.debug("Could not get font size for {}", identifier, e);
        }


        return new CSSRecord(identifier, colourFill, colour1,colour2, colour3, colour4,colour5,
                width1, width2, width3, width4, width5);
    }



}
