package com.ungdunguel.appcbdoan.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.ungdunguel.appcbdoan.model.Group;

public class GroupModel extends BaseObservable {
    public String group_name_vi;
    public String group_name_en;
    public String locale;


    public GroupModel(Group group, String locale)
    {
        this.group_name_vi = group.group_name_vi;
        this.group_name_en = group.group_name_en;
        this.locale = locale;
    }

    @Bindable
    public String getName()
    {
        if(locale.contains("vi"))
        {
            return group_name_vi;
        }
        else if (locale.contains("en"))
        {
            return group_name_en;
        }
        return null;
    }

    @Bindable
    public void setName(String name)
    {
        this.group_name_vi = name;
        this.group_name_en = name;
    }

//     @Bindable
//     public void setShortName(String name)
//     {
//         return;
//     }
//
//     @Bindable
//    public String getShortName()
//     {
//         if(locale.contains("vi"))
//         {
//             return group_name_vi;
//         }
//         else if (locale.contains("en"))
//         {
//             return group_name_en;
//         }
//         return null;
//     }


    //    public GroupModel(String group_name_vi, String group_name_en) {
//        this.group_name_vi = group_name_vi;
//        this.group_name_en = group_name_en;
//    }
}

