
//TASK 3 ADT
public class CourseInfo {
    private String courseCode;
    private String courseName;
    private String quizDate;
    private String testDate;
    private String projectDate;
    private String finalExamDate;

    //normal construtor
    public CourseInfo(String courseCode, String courseName, String quizDate, String testDate, String projectDate, String finalExamDate) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.quizDate = quizDate;
        this.testDate = testDate;
        this.projectDate = projectDate;
        this.finalExamDate = finalExamDate;
    }

    //getters and setters
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName(){ return courseName;}

    public String getQuizDate() { return quizDate;}

    public String getTestDate() { return testDate;}

    public String getProjectDate(){ return projectDate;}

    public String getFinalExamDate(){ return finalExamDate;}

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String toString() {
        return courseCode + " " + quizDate + " " + testDate + " " + projectDate + " " + finalExamDate;
    }
}
