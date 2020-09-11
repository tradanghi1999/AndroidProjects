package com.ungdunguel.appcbdoan.data.search;

import com.ungdunguel.appcbdoan.model.News;

public interface SearchReturn {
    void onResponse(News[] news);
    void onFailure();
}