package vn.edu.uel.apptudien.data.sync;

public interface SyncResult {
    void onFailure();
    void onSyncedWord();
    void onSyncGroup();
    void onSyncNews();
    void onSyncMeta();
}
