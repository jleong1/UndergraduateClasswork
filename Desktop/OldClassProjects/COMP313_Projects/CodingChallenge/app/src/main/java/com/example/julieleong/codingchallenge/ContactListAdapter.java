package com.example.julieleong.codingchallenge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Julie Leong on 2/16/2015.
 */
public class ContactListAdapter extends ArrayAdapter<ContactParse> {
    try
    {

        JSONArray jArray = new JSONArray(result);
        JSONObject jObj=new JSONObject ();
        String[] data=new String[jArray.length()]

        for(int i=0;i<jArray.length();i++)
        {
            jObj= jArray.getJSONObject(i);
            data[i]=json_data.getString("value");

        }

        GameAdapter adapter = new GameAdapter(this, R.layout.listview_item_row, data);
        listView1 = (ListView).findViewById(R.id.act);
        listView1.setAdapter(adapter);
    }
    catch(Exception e)
    {
    }
}
