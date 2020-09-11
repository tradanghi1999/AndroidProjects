package vn.edu.uel.apptudien.model;

public class Metadata {
    public Word_meta_data word_meta_data;
    public News_meta_data news_meta_data;
    public Group_meta_data group_meta_data;

    public Metadata(Word_meta_data word_meta_data, News_meta_data news_meta_data, Group_meta_data group_meta_data) {
        this.word_meta_data = word_meta_data;
        this.news_meta_data = news_meta_data;
        this.group_meta_data = group_meta_data;
    }
}
