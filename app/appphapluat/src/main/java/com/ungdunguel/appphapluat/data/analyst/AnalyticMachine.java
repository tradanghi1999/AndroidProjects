package com.ungdunguel.appphapluat.data.analyst;

import android.content.Context;

import com.ungdunguel.appphapluat.data.local.Group_Local_Data;
import com.ungdunguel.appphapluat.data.local.Word_Local_Data;
import com.ungdunguel.appphapluat.model.Group;
import com.ungdunguel.appphapluat.model.Word;
import com.ungdunguel.appphapluat.viewmodel.KeywordModel;

import java.util.ArrayList;

public class AnalyticMachine {
    Context context;
    AnalyticsReturn IAnalytics;

    public AnalyticMachine(Context context, AnalyticsReturn IAnalytics) {
        this.context = context;
        this.IAnalytics = IAnalytics;
    }


    public void getWordsMatchFromKeyword(KeywordModel keyword)
    {
        Group group = getGroupFromKw(keyword);
        if (group.group_name_en.toLowerCase().contains("all"))
        {
            getALLWordsMatchFromKeyword(keyword);
        }
        else
        {
            getWordsMatchFromKeyword(keyword, group);
        }
    }

    public void getALLWordsMatchFromKeyword(KeywordModel keyword)
    {
        Word[] words = new Word_Local_Data(context).getWordRecords();
        if(words == null)
            IAnalytics.onFailure();
        ArrayList<Word> wordsFound = new ArrayList<>();
        for(int i = 0; i< words.length; i++)
        {
            if(keyword.getVi_word() == words[i].vi_word ||
                    keyword.getVi_word() == words[i].en_word||
                    keyword.getEn_word() == words[i].vi_word||
                    keyword.getEn_word() == words[i].en_word)
            {
                wordsFound.add(words[i]);
            }
        }

        Word[] _wordsFoundToReturn = (Word[]) wordsFound.toArray();
        if(_wordsFoundToReturn.length ==0)
            IAnalytics.onFailure();
        IAnalytics.onWordsResponse(_wordsFoundToReturn);

    }


    public void getWordsMatchFromKeyword(KeywordModel keyword, Group group)
    {
        if(keyword.getGroupSearchZone()==null|| keyword.getGroupSearchZone()=="")
        {
            getALLWordsMatchFromKeyword(keyword);
            return;
        }

        Word[] words = new Word_Local_Data(context).getWordRecords();
        if(words == null)
            IAnalytics.onFailure();
        ArrayList<Word> wordsFound = new ArrayList<>();
        for(int i = 0; i< words.length; i++)
        {
            if((keyword.getVi_word() == words[i].vi_word ||
                    keyword.getVi_word() == words[i].en_word||
                    keyword.getEn_word() == words[i].vi_word||
                    keyword.getEn_word() == words[i].en_word)  &&
                    (keyword.getGroupSearchZone() == group.group_name_vi ||
                            keyword.getGroupSearchZone() == group.group_name_en))
            {
                wordsFound.add(words[i]);
                continue;
            }

        }

        Word[] _wordsFoundToReturn = new Word[wordsFound.size()];
        for(int i = 0 ; i< wordsFound.size();i++)
        {
            _wordsFoundToReturn[i] = wordsFound.get(i);
        }
        if(_wordsFoundToReturn.length ==0)
            IAnalytics.onFailure();
        IAnalytics.onWordsResponse(_wordsFoundToReturn);

    }

    public void getGroupFromKeyword(KeywordModel keyword)
    {
        Group[] groups = new Group_Local_Data(context).getGroupRecords();
        if(groups == null)
            IAnalytics.onFailure();

        String keyGroup = keyword.getGroupSearchZone();
        for(int i = 0; i < groups.length; i++)
        {
            if(keyGroup == groups[i].group_name_vi || keyGroup == groups[i].group_name_en)
            {
                IAnalytics.onGroupResponcse(groups[i]);
                return;
            }
        }
        IAnalytics.onGroupResponcse(groups[0]);


    }

    private  Group getGroupFromKw(KeywordModel keyword)
    {
        Group[] groups = new Group_Local_Data(context).getGroupRecords();
        if(groups == null)
            IAnalytics.onFailure();

        String keyGroup = keyword.getGroupSearchZone();
        for(int i = 0; i < groups.length; i++)
        {
            if(keyGroup == groups[i].group_name_vi || keyGroup == groups[i].group_name_en)
            {
                //IAnalytics.onGroupResponcse(groups[i]);
                return groups[i];
            }
        }
        return (groups[0]);
    };
}
