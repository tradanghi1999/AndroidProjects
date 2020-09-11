package vn.edu.uel.apptudien.data.remote;

public interface IParallelDotsAPI {
    void onSimilarityResponse(String json);
    void onFailire(String json);
}
