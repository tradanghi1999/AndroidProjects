package com.ungdunguel.appcbdoan.data.sync;

public interface SyncResult {
    void onFailure();
    void onSyncedWord();
    void onSyncGroup();
    void onSyncNews();
    void onSyncMeta();
}
