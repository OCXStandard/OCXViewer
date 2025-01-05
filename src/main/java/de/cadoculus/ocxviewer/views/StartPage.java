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
}
