import java.util.Scanner;//Import scanner class to read user input

public class Main{// main class
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//create  scanner object for input

        // ============================
        // 1. INPUT SCHOOL DETAILS
        // ============================
        System.out.print("Enter School Name: ");
        String schoolName = sc.nextLine();

        System.out.print("Enter Teacher Name: ");
        String teacherName = sc.nextLine();

        System.out.print("Enter Grade: ");
        String grade = sc.nextLine();

        System.out.print("Enter Year: ");
        int year = sc.nextInt();

        int totalStudents;

        // Students must be at least 12
        do {
            System.out.print("Enter number of students (minimum 12): ");
            totalStudents = sc.nextInt();
        } while (totalStudents < 12);

        sc.nextLine(); // clear buffer

        // ============================
        // ARRAYS FOR STUDENT DATA
        // ============================
        String[] names = new String[totalStudents];
        double[] eng = new double[totalStudents];
        double[] mat = new double[totalStudents];
        double[] his = new double[totalStudents];
        double[] geo = new double[totalStudents];
        double[] sci = new double[totalStudents];
        double[] programm = new double[totalStudents];
        double[] total = new double[totalStudents];
        String[] gradeList = new String[totalStudents];

        // ============================
        // 2. INPUT STUDENT RECORDS
        // ============================
        System.out.println("\nENTER STUDENT DETAILS");

        for (int i = 0; i < totalStudents; i++) {//loop through the students
            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter Student Name: ");//ask for student name
            names[i] = sc.nextLine();//read name

            System.out.print("English: ");
            eng[i] = sc.nextDouble();

            System.out.print("Math: ");
            mat[i] = sc.nextDouble();

            System.out.print("History: ");
            his[i] = sc.nextDouble();

            System.out.print("Geography: ");
            geo[i] = sc.nextDouble();

            System.out.print("Science: ");
            sci[i] = sc.nextDouble();

            System.out.print("Programming: ");
            programm[i] = sc.nextDouble();

            sc.nextLine(); // clear buffer

            total[i] = eng[i] + mat[i] + his[i] + geo[i] + sci[i] +programm[i];
            gradeList[i] = getGrade(total[i]);
        }

        // ============================
        // 3. COMPUTE CLASS STATISTICS
        // ============================
        double sumEng = 0, sumMat = 0, sumhis = 0, sumgeo = 0, sumSci = 0, sumprogramm =0, sumtotal =0;
        int countA = 0, countB = 0, countC = 0, countD = 0, countE = 0;

        for (int i = 0; i < totalStudents; i++) {
            sumEng += eng[i];
            sumMat += mat[i];
            sumhis += his[i];
            sumgeo += geo[i];
            sumSci += sci[i];
            sumprogramm += programm[i];
            sumtotal += total[i];

            switch (gradeList[i]) {
                case "A" -> countA++;
                case "B" -> countB++;
                case "C" -> countC++;
                case "D" -> countD++;
                case "E" -> countE++;
            }
        }

        // ============================
        // 4. OUTPUT REPORT
        // ============================
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\t\tSchool Name: " + schoolName);
        System.out.println("\t\t\t\t\t\t\tTeacher: " + teacherName);
        System.out.println("\t\t\t\t\t\t\t  Grade: " + grade);
        System.out.println("\t\t\t\t\t\t\t   Year: " + year);
        System.out.println("===========================================================================================");
        System.out.printf("%-19s %-7s %-8s %-7s %-8s %-8s %-8s %-8s %-5s\n",
                " Student Name", "English", "Math", "History", "Geography", "Science", "Programming", "Total", "Rank");
        System.out.println("===========================================================================================");

        for (int i = 0; i < totalStudents; i++) {
            System.out.printf("%-19s %-7.2f %-8.2f %-7.2f %-10.2f %-11.2f %-6.2f %-10.2f %-5s\n",
                     names[i], eng[i], mat[i], his[i], geo[i], sci[i], programm[i], total[i], gradeList[i]);
        }
        System.out.println("\n-----------------------------------------------------------------------------------------");

// TOTALS
        System.out.printf("\t\t\t\t%9.2f %8.2f %8.2f %8.2f %8.2f %10.2f %8.2f\n",
                sumEng, sumMat, sumhis, sumgeo, sumSci, sumprogramm, sumtotal,
                (sumEng + sumMat + sumhis + sumgeo + sumSci + sumprogramm + sumtotal));

        System.out.println("-------------------------------------------------------------------------------------------");

// AVERAGES
        System.out.printf("\t\t\t\t%9.2f %8.2f %8.2f %8.2f %8.2f %10.2f %8.2f\n",
                sumEng / totalStudents,
                sumMat / totalStudents,
                sumhis / totalStudents,
                sumgeo / totalStudents,
                sumSci / totalStudents,
                sumprogramm / totalStudents,
                sumtotal / totalStudents,
                (sumEng + sumMat + sumhis + sumgeo + sumSci + sumprogramm + sumtotal) / totalStudents);
        System.out.println("===========================================================================================");

// GRADE COUNTS
        System.out.printf("\t\t\t\t\tRanks   A's: %d   B's: %d   C's: %d   D's: %d   F's: %d\n",
                countA, countB, countC, countD, countE);
    }

    // ============================
    // GRADE FUNCTION
    // ============================
    public static String getGrade(double total) {
        if (total >= 540.0) return "A";
        else if (total >= 480.0) return "B";
        else if (total >= 420.0) return "C";
        else if (total >= 360.0) return "D";
        else return "F";
    }
}
