package BadMa.Model;

public class Record {
    private int studentId;
    private String studentName;
    private String reason;
    public Record(){}
    public Record(String studentName, String reason, int studentId) {
        this.studentName = studentName;
        this.reason = reason;
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
