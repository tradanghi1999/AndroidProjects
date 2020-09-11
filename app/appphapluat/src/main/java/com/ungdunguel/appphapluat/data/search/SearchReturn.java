package com.ungdunguel.appphapluat.data.search;

import com.ungdunguel.appphapluat.model.News;

public interface SearchReturn {
    void onResponse(News[] news);
    void onFailure();
}