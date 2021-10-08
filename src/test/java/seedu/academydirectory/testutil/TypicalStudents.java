package seedu.academydirectory.testutil;

import static seedu.academydirectory.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.academydirectory.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.academydirectory.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.academydirectory.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.academydirectory.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.academydirectory.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.academydirectory.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.academydirectory.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.academydirectory.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.academydirectory.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.academydirectory.logic.commands.CommandTestUtil.VALID_TELEGRAM_AMY;
import static seedu.academydirectory.logic.commands.CommandTestUtil.VALID_TELEGRAM_BOB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.academydirectory.model.AcademyDirectory;
import seedu.academydirectory.model.student.Student;

/**
 * A utility class containing a list of {@code Student} objects to be used in tests.
 */
public class TypicalStudents {

    public static final Student ALICE = new StudentBuilder().withName("Alice Pauline")
            .withAddress("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
            .withTelegram("@alice").withPhone("94351253")
            .withTags("friends").build();
    public static final Student BENSON = new StudentBuilder().withName("Benson Meier")
            .withAddress("311, Clementi Ave 2, #02-25")
            .withEmail("johnd@example.com").withTelegram("@johnd").withPhone("98765432")
            .withTags("owesMoney", "friends").build();
    public static final Student CARL = new StudentBuilder().withName("Carl Kurz").withPhone("95352563")
            .withEmail("heinz@example.com").withTelegram("@heinz").withAddress("wall street").build();
    public static final Student DANIEL = new StudentBuilder().withName("Daniel Meier").withPhone("87652533")
            .withEmail("cornelia@example.com").withTelegram("@cornelia")
            .withAddress("10th street").withTags("friends").build();
    public static final Student ELLE = new StudentBuilder().withName("Elle Meyer").withPhone("9482224")
            .withEmail("werner@example.com").withTelegram("@werner").withAddress("michegan ave").build();
    public static final Student FIONA = new StudentBuilder().withName("Fiona Kunz").withPhone("9482427")
            .withEmail("lydia@example.com").withTelegram("@lydia").withAddress("little tokyo").build();
    public static final Student GEORGE = new StudentBuilder().withName("George Best").withPhone("9482442")
            .withEmail("anna@example.com").withTelegram("@anna").withAddress("4th street").build();

    // Manually added
    public static final Student HOON = new StudentBuilder().withName("Hoon Meier").withPhone("8482424")
            .withEmail("stefan@example.com").withTelegram("@stefan").withAddress("little india").build();
    public static final Student IDA = new StudentBuilder().withName("Ida Mueller").withPhone("8482131")
            .withEmail("hans@example.com").withTelegram("@hans").withAddress("chicago ave").build();

    // Manually added - Student's details found in {@code CommandTestUtil}
    public static final Student AMY = new StudentBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
            .withEmail(VALID_EMAIL_AMY).withTelegram(VALID_TELEGRAM_AMY)
            .withAddress(VALID_ADDRESS_AMY).withTags(VALID_TAG_FRIEND).build();
    public static final Student BOB = new StudentBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
            .withEmail(VALID_EMAIL_BOB).withTelegram(VALID_TELEGRAM_BOB)
            .withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND)
            .build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalStudents() {} // prevents instantiation

    /**
     * Returns an {@code AcademyDirectory} with all the typical students.
     */
    public static AcademyDirectory getTypicalAcademyDirectory() {
        AcademyDirectory ab = new AcademyDirectory();
        for (Student student : getTypicalStudents()) {
            ab.addStudent(student);
        }
        return ab;
    }

    public static List<Student> getTypicalStudents() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
