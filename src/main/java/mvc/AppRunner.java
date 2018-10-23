package mvc;

import mvc.controller.SkillController;
import mvc.model.Skill;
import mvc.view.SkillViewer;

import java.io.IOException;
import java.util.List;

/**
 * Created by Max Hluhov on 14.10.2018.
 */
public class AppRunner {
    public static void main(String[] args) throws IOException {
        SkillController c = new SkillController();
        SkillViewer skillViewer = new SkillViewer(c);
        List<Skill> skillList = skillViewer.getAll();
        for (Skill s : skillList) {
            System.out.println(s);
        }
    }
}
