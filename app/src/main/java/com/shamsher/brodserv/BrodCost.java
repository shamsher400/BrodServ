//This is my git project.
package com.shamsher.brodserv;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by shamsher on 22/6/16.
 */
public class BrodCost extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        context.startService(new Intent(context,ServiceS.class));
		Toast.makeText(context,"sdfny gnf yda",Toast.LENGTH_LONG).show();
    }
}
