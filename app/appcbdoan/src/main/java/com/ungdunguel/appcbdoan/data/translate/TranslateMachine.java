package com.ungdunguel.appcbdoan.data.translate;

import android.content.Context;

import com.ungdunguel.appcbdoan.data.local.Word_Local_Data;
import com.ungdunguel.appcbdoan.model.Word;


public class TranslateMachine {

    public  ITranslateResult itranslate;
    public Context context;
    public TranslateMachine(ITranslateResult itranslate, Context context)
    {
        this.itranslate = itranslate;
        this.context = context;
    }

    Word[] words;
    public void sendToGetEnWord(String vi_word)
    {
        if(words ==null)
        {
            words = new Word_Local_Data(context).getWordRecords();
        }
        if(words.length <=0)
            //return "cannot translate";
            itranslate.onError(vi_word);

        for(int i = 0; i < words.length;i++)
        {
            if(words[i].vi_word.equalsIgnoreCase(vi_word))
            {
                itranslate.onSuccess(words[i].en_word);
                return;
            }
        }

        itranslate.onError(vi_word);
    }
}
