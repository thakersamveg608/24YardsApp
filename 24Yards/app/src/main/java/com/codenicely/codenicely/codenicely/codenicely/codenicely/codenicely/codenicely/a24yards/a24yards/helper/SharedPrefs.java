package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.helper;



import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;


public class SharedPrefs {

    // Shared preferences file name
    private static final String PREF_NAME = "welcome";
    private static final String KEY_IS_LOGGEDIN = "isLoggedIn";
    private static final String KEY_MOBILE = "contact";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    private static final String PROPERTY_CATEGORY = "PropertyCategory";
    private static final String KEY_SORT = "Sort_type";
    private static final String KEY_ACCESS_TOKEN = "access_token";
    private static final String KEY_LOCATION = "location";
    private static final String KEY_FILTER = "isFilter";
    private static final String KEY_BHK = "bhk";
    private static final String KEY_USAGE = "usage";
    private static final String KEY_MIN_PRICE = "min_price";
    private static final String KEY_MAX_PRICE = "max_price";
    private static final String KEY_SEARCH_BUY = "isBuy";
    private static final String KEY_SEARCH_RENT = "isRent";



    // LogCat tag
    private static String TAG = "Shared Preference";

    // Shared Preferences
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    public SharedPrefs(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


    public void setLogin(boolean isLoggedIn) {

        editor.putBoolean(KEY_IS_LOGGEDIN, isLoggedIn);
        // commit changes
        editor.commit();
        Log.d(TAG, "User login session modified!");
    }

    public boolean isLoggedIn() {
        return pref.getBoolean(KEY_IS_LOGGEDIN, false);
    }
    public void setSearchBuy(boolean isBuy){
        editor.putBoolean(KEY_SEARCH_BUY,isBuy);
        editor.commit();
    }
    public boolean isSearchBuy(){
        return pref.getBoolean(KEY_SEARCH_BUY,false);
    }
    public void setSearchRent(boolean isRent){
        editor.putBoolean(KEY_SEARCH_BUY,isRent);
        editor.commit();
    }
    public boolean isSearchRent(){
        return pref.getBoolean(KEY_SEARCH_BUY,false);
    }
    public void setFilter(boolean isFilter){
        editor.putBoolean(KEY_FILTER,isFilter);
        editor.commit();
    }
    public boolean isFilter(){
        return pref.getBoolean(KEY_FILTER,false);
    }

   public void setSort(String sort_type){
       editor.putString(KEY_SORT,sort_type);
       editor.commit();
   }
   public void setLocation(String location){
       editor.putString(KEY_LOCATION,location);
       editor.commit();
   }
   public String getLocation(){
       return pref.getString(KEY_LOCATION,"Raipur");
   }
   public void setUsage(String usage){
       editor.putString(KEY_USAGE,usage);
       editor.commit();
   }
   public String getUsage(){
       return pref.getString(KEY_USAGE,"Residential");
   }
   public void setMinPrice(String min_price){
       editor.putString(KEY_MIN_PRICE,min_price);
       editor.commit();
   }
   public String getMinPrice(){
       return pref.getString(KEY_MIN_PRICE,"0");
   }
   public void setMaxPrice(String max_Price){
       editor.putString(KEY_MAX_PRICE,max_Price);
       editor.commit();
   }
   public String getMaxPrice(){
       return pref.getString(KEY_MAX_PRICE,"50000000");
   }
   public String getSort(){
       return pref.getString(KEY_SORT,null);
   }
    public String getMobile() {

        return pref.getString(KEY_MOBILE, "NA");

    }

    public void setMobile(String userName) {

        editor.putString(KEY_MOBILE, userName);
        editor.commit();

    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    public String getAccessToken() {

        return pref.getString(KEY_ACCESS_TOKEN, null);
    }


    public void setAccessToken(String accessToken) {
        editor.putString(KEY_ACCESS_TOKEN, accessToken);
        editor.commit();

    }

    public void setProperty(String property){
        editor.putString(PROPERTY_CATEGORY,property);
        editor.commit();
    }

    public String getProperty() {
        return pref.getString(PROPERTY_CATEGORY,"Buy");
    }
}