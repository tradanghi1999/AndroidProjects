package com.ungdunguel.appcbdoan.data.analyst;

import com.ungdunguel.appcbdoan.model.Group;
import com.ungdunguel.appcbdoan.model.Word;

public interface AnalyticsReturn {
    void onWordsResponse(Word[] words);
    void onGroupResponcse(Group group);
    void onFailure();
}
