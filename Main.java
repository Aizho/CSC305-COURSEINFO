import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args){
        int numOfCourses = 7;

        CourseInfo[] courseInfo = new CourseInfo[7];
        String header = "";
        String data = "";

        //TASK 1 READ FILE
        try{//START WITH TRY
            BufferedReader bufferedReader = new BufferedReader(new FileReader("sample data.csv")); // read file and store as buffer
            header = bufferedReader.readLine(); // read the header of the file
            data = bufferedReader.readLine(); // read the first line of data
            int lineNum = 0;
            while (data != null) {
                StringTokenizer tokens = new StringTokenizer(data, ",");
                String CourseCode = tokens.nextToken().trim();
                String CourseName = tokens.nextToken().trim();
                String quizDate = tokens.nextToken().trim();
                String testDate = tokens.nextToken().trim();
                String projectDate = tokens.nextToken().trim();
                String finalExamDate = tokens.nextToken().trim();
                CourseInfo course = new CourseInfo(CourseCode, CourseName, quizDate, testDate, projectDate, finalExamDate);
                courseInfo[lineNum] = course;
                // add the temp course object to the array
                // task 2 ends
                lineNum++;
                data = bufferedReader.readLine(); // read next line
            }
            bufferedReader.close();//END OF READING
        }catch (IOException e){
            e.printStackTrace();
        }//END OF CATCH

        //TASK 3 PRINT ALL DETAILS
        System.out.println(header);
        for (int i = 0; i < numOfCourses; i++) {
            System.out.println(courseInfo[i].toString());
        }

        System.out.println("\n=========================================================================");
        //letak course code sini pakai print system.out.println

        int totalQuiz = 0;
        int totalTest = 0;
        int totalProject = 0;
        int totalFinalExam = 0;
        for (int i = 1; i < 20; i++){
            System.out.printf("%d   ", i);
            for (int j = 0; j < numOfCourses; j++) {
                if(i == findWeekBetween(courseInfo[j].getQuizDate())){
                    System.out.printf("Quiz       ");
                    totalQuiz++;
                }else if(i == findWeekBetween(courseInfo[j].getTestDate())){
                    System.out.printf("Test       ");
                    totalTest++;
                }else if(i == findWeekBetween(courseInfo[j].getProjectDate())){
                    System.out.printf("Project    ");
                    totalProject++;
                }else if(i == findWeekBetween(courseInfo[j].getFinalExamDate())){
                    System.out.printf("Final exam ");
                    totalFinalExam++;
                }
            }
            System.out.println("");
        }
    }

    //TASK 3
    private static long findWeekBetween(String date) {
        LocalDate start = LocalDate.of(2022, 10, 10);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy");
        LocalDate end = LocalDate.parse(date, formatter);
        return ChronoUnit.WEEKS.between(start, end);
    }
}