package BadMa.Model;

import java.util.List;

public class Student {
    private int id;
    private String name;
    private List<String> weeklyStatuses;
    public Student(){}
    public Student(List<String> weeklyStatuses, String name, int id) {
        this.weeklyStatuses = weeklyStatuses;
        this.name = name;
        this.id = id;
    }

    public List<String> getWeeklyStatuses() {
        return weeklyStatuses;
    }

    public void setWeeklyStatuses(List<String> weeklyStatuses) {
        this.weeklyStatuses = weeklyStatuses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public boolean isPresent(int week){
        return weeklyStatuses.get(week).equals("Có mặt");
    }
    public String getAbsentReason(int week){
        return weeklyStatuses.get(week);
    }
}
