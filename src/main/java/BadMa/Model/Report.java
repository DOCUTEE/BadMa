package BadMa.Model;

import java.util.List;


public class Report {
    private int groupId;
    private List<Record> records;
    public Report() {

    }
    public Report(int groupId, List<Record> records) {
        this.groupId = groupId;
        this.records = records;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }
}
