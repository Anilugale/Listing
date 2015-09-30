package com.androidworks.anil.listing.util;

import android.content.Context;
import android.content.Intent;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
   Created by Anil on 13/08/2015.
 */
public  class CommanMethod {



 public static void share(Context context,String shareSting)
 {
     Intent shareIntent = new Intent();
     shareIntent.setAction(Intent.ACTION_SEND);
     shareIntent.putExtra(Intent.EXTRA_TEXT, shareSting);
     shareIntent.setType("text/plain");
     context.startActivity(shareIntent);
 }



  public final static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }


    public  static  String changeDateFormate(String dateString) throws ParseException {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); // 2015-09-14 01:48:32
        Date date = fmt.parse(dateString);

        SimpleDateFormat fmtOut = new SimpleDateFormat("dd MMM yyyy");
        return fmtOut.format(date);
    }
}
