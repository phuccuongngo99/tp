package seedu.academydirectory.logic.commands;

import static seedu.academydirectory.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.academydirectory.testutil.TypicalStudents.getTypicalAcademyDirectory;

import org.junit.jupiter.api.Test;

import seedu.academydirectory.model.AcademyDirectory;
import seedu.academydirectory.model.Model;
import seedu.academydirectory.model.ModelManager;
import seedu.academydirectory.model.UserPrefs;

public class ClearCommandTest {

    @Test
    public void execute_emptyAcademyDirectory_success() {
        Model model = new ModelManager();
        Model expectedModel = new ModelManager();

        assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_nonEmptyAcademyDirectory_success() {
        Model model = new ModelManager(getTypicalAcademyDirectory(), new UserPrefs());
        Model expectedModel = new ModelManager(getTypicalAcademyDirectory(), new UserPrefs());
        expectedModel.setAcademyDirectory(new AcademyDirectory());

        assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

}