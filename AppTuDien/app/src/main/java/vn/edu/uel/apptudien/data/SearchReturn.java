package vn.edu.uel.apptudien.data;

import vn.edu.uel.apptudien.model.News;

public interface SearchReturn {
    void onResponse(News[] news);
    void onFailure();
}
