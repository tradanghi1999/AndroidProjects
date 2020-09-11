package com.ungdunguel.appcbdoan.data.translate;



public interface ITranslateResult {
    void onSuccess(String en_word);
    void onError(String vi_word);
}
