package com.ungdunguel.appphapluat.data.analyst;

import com.ungdunguel.appphapluat.model.Group;
import com.ungdunguel.appphapluat.model.Word;

public interface AnalyticsReturn {
    void onWordsResponse(Word[] words);
    void onGroupResponcse(Group group);
    void onFailure();
}
