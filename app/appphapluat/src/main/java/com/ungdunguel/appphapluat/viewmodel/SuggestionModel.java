package com.ungdunguel.appphapluat.viewmodel;

import android.content.Context;

import com.ungdunguel.appphapluat.data.local.Group_Local_Data;
import com.ungdunguel.appphapluat.data.local.Word_Local_Data;
import com.ungdunguel.appphapluat.model.Group;
import com.ungdunguel.appphapluat.model.Word;

import java.util.ArrayList;

public class SuggestionModel {
    private Word[] words;
    private Group[] groups;
    private Context context;

    String[] suggestedStrings;
    public SuggestionModel(Context context)
    {
        this.context = context;
        words = new Word_Local_Data(context).getWordRecords();
        groups = new Group_Local_Data(context).getGroupRecords();

    }
    public String[] getWordsSuggestionBasedOnKeyWordMdel(KeywordModel keywordModel)
    {
        ArrayList<String> sugs= new ArrayList<String>();
        Group groupToSearch = getGroupFromKeyModel(keywordModel);
//        for(int i =0;i< words.length;i++)
//        {
//
//            if(groupToSearch == groups[0])
//            {
//                sugs.add(words[i].vi_word);
//                sugs.add(words[i].en_word);
//                continue;
//            }
//
//            if(groupToSearch.group_id == words[i].group_id)
//            {
//                sugs.add(words[i].vi_word);
//                sugs.add(words[i].en_word);
//            }
//
//
//
//        }
        return getWordsSuggestionBasedOnKeyWordMdelBasic(keywordModel);


        //return sugs.toArray(new String[0]);
    }


    //get all posible suggesstion
    private String[] getWordsSuggestionBasedOnKeyWordMdelBasic(KeywordModel keywordModel)
    {
        ArrayList<String> sugs= new ArrayList<String>();
        for(int i =0;i< words.length;i++)
        {
            sugs.add(words[i].vi_word);
            sugs.add(words[i].en_word);
        }
        return sugs.toArray(new String[0]);

    }
    private Group getGroupFromKeyModel(KeywordModel keywordModel)
    {
        if(keywordModel.getGroupSearchZone() == null||
                keywordModel.getGroupSearchZone()=="")
            return groups[0];
        for(int i=0; i< groups.length;i++)
        {
            if(groups[i].group_name_en.contains(keywordModel.groupSearchZone) && keywordModel.groupSearchZone.contains(groups[i].group_name_en))
                return  groups[i];
            if(groups[i].group_name_vi.contains(keywordModel.groupSearchZone) && keywordModel.groupSearchZone.contains(groups[i].group_name_vi))
                return  groups[i];

        }
        return groups[0];
    }
}
