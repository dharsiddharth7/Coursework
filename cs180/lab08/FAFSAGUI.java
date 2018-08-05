import javax.swing.*;

/**
 * The FAFSA class keeps track of information about a student and uses it to
 * determine the student's eligibility for federal financial aid and the total
 * estimated amount of aid awarded to those who are eligible.
 *
 * @author Siddharth Dhar
 *
 */
public class FAFSAGUI {


    public static void main(String[] args) {
        boolean a;

        int creditHours;
        int age;
        int studentIncome;
        int parentsIncome;
        boolean isAcceptedStudent1;
        boolean isSSregistered1;
        boolean hasSSN1;
        boolean hasValidResidency1;
        boolean isDependent1;

        while(true) {

            // Welcome Dialog
            JOptionPane.showMessageDialog(null, "Welcome to the FAFSA!", "Welcome", JOptionPane.INFORMATION_MESSAGE);

            //isAcceptedStudent Dialog

            int isAcceptedStudent = JOptionPane.showOptionDialog(null, "Have you been accepted into a degree or certificate program?", "Program Acceptance",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

            if (isAcceptedStudent == JOptionPane.YES_OPTION) {

                isAcceptedStudent1 = true;
            } else {

                isAcceptedStudent1 = false;
            }

            // isSSregistered Dialog

            int isSSregistered = JOptionPane.showOptionDialog(null, "Are you registered for the selective service ?", "Selective Service",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

            if (isAcceptedStudent == JOptionPane.YES_OPTION) {

                isSSregistered1 = true;
            } else {

                isSSregistered1 = false;
            }

            // hasSSN Dialog

            int hasSSN = JOptionPane.showOptionDialog(null, "Do you have a social security number?", "Social Security Number", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, null, null);

            if (hasSSN == JOptionPane.YES_OPTION) {
                hasSSN1 = true;
            } else {
                hasSSN1 = false;
            }

            // hasValidResidency Dialog


            int hasValidResidency = JOptionPane.showOptionDialog(null, "Do you have a valid residency status?", "Residency Status", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, null, null);

            if (hasValidResidency == JOptionPane.YES_OPTION) {
                hasValidResidency1 = true;
            } else {
                hasValidResidency1 = false;
            }


            // Age Dialog

            do {
                age = Integer.parseInt(JOptionPane.showInputDialog(null, "How old are you?", "Age", JOptionPane.QUESTION_MESSAGE));
                if (age < 0) {
                    JOptionPane.showMessageDialog(null, "Age cannot be a negative number.", "Error: Age", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
                break;
            } while (age < 0);

            // creditHours Dialog

            do {
                creditHours = Integer.parseInt(JOptionPane.showInputDialog(null, "How many credit hours do you plan on taking?", "Credit Hours", JOptionPane.QUESTION_MESSAGE));
                if (creditHours < 1 || creditHours > 24) {
                    JOptionPane.showMessageDialog(null, "Credit hours must be between 1 and 24, inclusive.", "Error: Credit Hours", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
                break;

            } while (creditHours >= 1 || creditHours <= 24);

            // studentIncome Dialog

            do {
                studentIncome = Integer.parseInt(JOptionPane.showInputDialog(null, "What is your total yearly income?", "Student Income", JOptionPane.QUESTION_MESSAGE));
                if (studentIncome < 0) {
                    JOptionPane.showMessageDialog(null, "Income cannot be a negative number.", "Error: Student Income", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
                break;
            } while (studentIncome < 0);

            // parentIncome Dialog

            do {
                parentsIncome = Integer.parseInt(JOptionPane.showInputDialog(null, "What is your parent's total yearly income?", "Parent Income", JOptionPane.QUESTION_MESSAGE));

                if (parentsIncome < 0) {
                    JOptionPane.showMessageDialog(null, "Income cannot be a negative number.", "Error: Parent Income", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
                break;
            } while (parentsIncome < 0);

            // isDependent Dialog

            int isDependent = JOptionPane.showOptionDialog(null, "Are you a dependent?", "Dependency",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

            if (isDependent == JOptionPane.YES_OPTION) {

                isDependent1 = true;
            } else {

                isDependent1 = false;
            }

            // classStanding Dialog

            String[] options = {"Freshman", "Sophomore", "Junior", "Senior", "Graduate"};

            String classStanding = (String) JOptionPane.showInputDialog(null, "What is your current class standing?", "Class Standing", JOptionPane.PLAIN_MESSAGE, null, options, null);

            if (classStanding.equals("Freshman") || classStanding.equals("Sophomore") || classStanding.equals("Junior") || classStanding.equals("Senior")) {
                classStanding = "Undergraduate";
            } else {
                classStanding = "Graduate";
            }

            FAFSA gui = new FAFSA(isAcceptedStudent1, isSSregistered1,
                    hasSSN1, hasValidResidency1, isDependent1,
                    age, creditHours, studentIncome, parentsIncome, classStanding);


            gui.calcStaffordLoan();
            gui.calcFederalGrant();
            gui.calcWorkStudy();
            gui.calcFederalAidAmount();
            gui.calcEFC();

            double sum = gui.calcStaffordLoan() + gui.calcFederalGrant() + gui.calcWorkStudy();

            JOptionPane.showMessageDialog(null, "Loan: " + gui.calcStaffordLoan() + "\n" + "Grant: " + gui.calcFederalGrant() + "\n" + "Work-Study: " + gui.calcWorkStudy() + "" +
                    "\n" + "------------------" + "\n" + "Total: " + sum);

            // Final Dialog

            int dialog = JOptionPane.showOptionDialog(null, "Would you like to complete another Application?","Continue",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

            if(dialog != JOptionPane.YES_OPTION){
                System.exit(0);
            }
        }

    }
}