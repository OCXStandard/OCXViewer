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
package de.cadoculus.ocxviewer.models;

import javafx.scene.paint.Color;

/**
 * A record representing the CSS properties for a given identifier, containing the identifier, the background fill colour, the 4 border colours and the 4 border widths in the order top, right, bottom, left.
 * @param name the identifier for which the CSS properties were looked up
 * @param fill the background fill colour
 * @param colour1 the border colour for the top border
 * @param colour2 the border colour for the right border
 * @param colour3 the border colour for the bottom border
 * @param colour4 the border colour for the left border
*  @param colour5 the text fill
 * @param width1 the border width for the top border
 * @param width2 the border width for the top border
 * @param width3 the border width for the bottom border
 * @param width4 the border width for the left border
*   @param width5 from font size
 */
public record CSSRecord(String name, Color fill,
                        Color colour1,Color colour2,Color colour3,Color colour4, Color colour5,
                        double width1, double width2, double width3, double width4, double width5) {
}
