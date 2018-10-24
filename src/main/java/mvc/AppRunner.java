package mvc;

import mvc.view.DeveloperView;

import java.io.IOException;

/**
 * Created by Max Hluhov on 14.10.2018.
 */
public class AppRunner {
    public static void main(String[] args) throws IOException {
        DeveloperView developerView = new DeveloperView();
        developerView.updateDeveloper();
    }
}
