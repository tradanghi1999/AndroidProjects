package vn.edu.uel.apptudien.model;

public class Word {
    public String id;
    public String group_id;
    public String vi_word;
    public String en_word;
    public String search_times;
    public String search_times_client;

    public Word(String id, String group_id, String vi_word, String en_word, String search_times, String search_times_client) {
        this.id = id;
        this.group_id = group_id;
        this.vi_word = vi_word;
        this.en_word = en_word;
        this.search_times = search_times;
        this.search_times_client = search_times_client;
    }
}
