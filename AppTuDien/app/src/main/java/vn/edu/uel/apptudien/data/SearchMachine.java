package vn.edu.uel.apptudien.data;

import android.content.Context;

import java.lang.reflect.Array;
import java.util.ArrayList;

import vn.edu.uel.apptudien.data.local.Group_Local_Data;
import vn.edu.uel.apptudien.data.local.News_Local_Data;
import vn.edu.uel.apptudien.data.local.Word_Local_Data;
import vn.edu.uel.apptudien.model.Group;
import vn.edu.uel.apptudien.model.News;
import vn.edu.uel.apptudien.model.Word;
import vn.edu.uel.apptudien.util.OwnLibrary;
import vn.edu.uel.apptudien.viewmodel.KeywordModel;

public class SearchMachine {
    Context context;
    KeywordModel keyword;
    SearchReturn ISearch;
    public SearchMachine(Context context,KeywordModel keyword, SearchReturn ISearch)
    {
        this.context = context;
        this.keyword = keyword;
        this.ISearch = ISearch;
    }

    News[] news;
    Word[] words;
    Group[] groups;
    public void SentToGetNews()
    {
         if(news == null)
         {
             news = new News_Local_Data(context).getNewsRecords();
         }
         if(groups ==null)
         {
             groups = new Group_Local_Data(context).getGroupRecords();
         }
         if(words ==null)
         {
             words = new Word_Local_Data(context).getWordRecords();
         }

         //point system
         int[] point = new int[news.length];

         String[] wordArrayFromKeyword = OwnLibrary.getWordsArrayFromSentence(
                 keyword.getVi_word()
         );

        for (String word: wordArrayFromKeyword
             ) {
            for(int i = 0; i< point.length;i++)
            {
                for (String keywordInNews: news[i].keywords
                     ) {
                    if(keywordInNews.contains(word))
                        point[i]++;
                }
            }
        }

        int newsFound = 0;
        News[] topFiveNews = new News[5];
        for(int i = 0; i< 5; i++)
        {
            int maxPos = OwnLibrary.getMaxPos(point);
            if(point[maxPos] == 0)
                break;

            News newsToAdd = new News(
                    news[maxPos].id,
                    news[maxPos].name,
                    news[maxPos].para,
                    news[maxPos].onlink,
                    news[maxPos].offlink,
                    news[maxPos].keywords.clone(),
                    news[maxPos].group_id,
                    news[maxPos].search_times,
                    news[maxPos].search_times_client
            );
            point[maxPos]=0;
            topFiveNews[i] = newsToAdd;
            newsFound++;
        }

        News[] newsToRespone = new News[newsFound];
        for(int i=0;i<newsFound;i++)
        {
            newsToRespone[i] = topFiveNews[i];
        }

        try
        {
            ISearch.onResponse(newsToRespone);
        }
        catch (Exception e)
        {
            ISearch.onFailure();
        }

    }




}
