/*
Copyright 2025 Carsten Zerbst

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package de.cadoculus.ocxviewer.views;

public class StartPage extends OutlinePage{

    public static final String NAME = "StartPage";


    public StartPage() {
        super();

        addPageHeader();
        addFormattedText("""
            [i]MenuButton[/i] is a button which, when clicked or pressed, will \
            show a context (dropdown) menu.
                        
            [i]SplitMenuButton[/i] is a variation of menu button. It is broken into two \
            pieces, the [i]action[/i] area and the [i]menu open[/i] area. If the user clicks \
            in the action area, the [i]SplitMenuButton[/i] will act similarly to [i]Button[/i], \
            while the menu open area of the control will show a context menu if clicked."""
        );

    }

    @Override
    public String getName() {
                return NAME;
    }

    @Override
    public void beforeShow() {

    }

    @Override
    public void afterShow() {

    }

    @Override
    public void beforeHide() {

    }

    @Override
    public void afterHide() {

    }

    @Override
    public void beforeClose() {

    }
}
