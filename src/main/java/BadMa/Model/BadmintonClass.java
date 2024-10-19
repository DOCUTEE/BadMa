package BadMa.Model;

import java.util.ArrayList;
import java.util.List;

public class BadmintonClass {

    private List<Group> groupList;

    public BadmintonClass() {
        groupList = new ArrayList<Group>();
    }

    public BadmintonClass(List<Group> groupList) {
        this.groupList = groupList;
    }
    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }
    public void addGroup(Group group) {
        this.groupList.add(group);
    }
    public List<Report> getGroupsReport(int week) {
        List<Report> reportList = new ArrayList<>();
        for(Group group : groupList) {
            reportList.add(group.getGroupReport(week));
        }
        return reportList;
    }

}
