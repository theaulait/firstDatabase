package me.theaulait.firstdatabase;

import android.provider.BaseColumns;

/**
 * Created by c4q-vanice on 7/16/15.
 */
public class TableData {

    public TableData(){ }

    public static abstract class TableInfo implements BaseColumns{

        public static final String userName = "Username";
        public static final String userPassword = "UserPassword";
        public static final String databaseName = "UserInfo";
        public static final String tableUserInfo = "Registration";

    }
}
