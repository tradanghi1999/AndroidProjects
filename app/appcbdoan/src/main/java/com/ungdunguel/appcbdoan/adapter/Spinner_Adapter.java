package com.ungdunguel.appcbdoan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.databinding.DataBindingUtil;

import com.ungdunguel.appcbdoan.R;
import com.ungdunguel.appcbdoan.databinding.GroupBinding;
import com.ungdunguel.appcbdoan.viewmodel.GroupModel;

public class Spinner_Adapter extends BaseAdapter {

    private GroupModel[] groupModel;
    private GroupBinding groupBinding;
    Context context;

    public Spinner_Adapter(GroupModel[] groupModel, Context context) {
        this.groupModel = groupModel;
        this.context = context;
    }

    @Override
    public int getCount() {
        return groupModel.length;
    }

    @Override
    public Object getItem(int position) {
        if(groupModel == null)
            return null;
        if(groupModel.length > position)
            return groupModel[position];
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {

        if(convertview == null)
        {

            convertview = LayoutInflater.from(context).inflate(R.layout.spinner_item_layout,null);
            groupBinding = DataBindingUtil.bind(convertview);
            convertview.setTag(groupBinding);
        }
        else
        {
            groupBinding = (GroupBinding) convertview.getTag();
        }



        groupBinding.setGroupViewModel(groupModel[position]);


        return groupBinding.getRoot();


        //return null;
    }


}
