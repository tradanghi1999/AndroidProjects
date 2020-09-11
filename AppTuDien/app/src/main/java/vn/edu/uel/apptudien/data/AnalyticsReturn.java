package vn.edu.uel.apptudien.data;

import vn.edu.uel.apptudien.model.Group;
import vn.edu.uel.apptudien.model.Word;

public interface AnalyticsReturn {
    void onWordsResponse(Word[] words);
    void onGroupResponcse(Group group);
    void onFailure();
}
