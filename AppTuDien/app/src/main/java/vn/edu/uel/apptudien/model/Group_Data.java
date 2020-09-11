package vn.edu.uel.apptudien.model;

public class Group_Data {
    public Group_meta_data meta_data;
    public Group[] records;

    public Group_Data(Group_meta_data meta_data, Group[] records) {
        this.meta_data = meta_data;
        this.records = records;
    }
}
