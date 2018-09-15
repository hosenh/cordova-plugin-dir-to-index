package com.github.hosenh.dirtoindex.cordova.plugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import android.net.Uri;

/**
* This class echoes a string called from JavaScript.
*/
public class DirToIndex extends CordovaPlugin {

  private static final String TAG = "DIR_TO_INDEX";
  
  @Override
  public Uri remapUri(Uri uri) {
    if (uri.getScheme().equals("file") && uri.getPath().endsWith("/")) {
      String str = uri.toString();
      if (!str.startsWith("file:///android_asset/")) {
        str = str.replaceFirst("^file:///", "file:///android_asset/www/");
      }
      Uri newuri = Uri.parse(str);
      str = newuri.getEncodedQuery();
      if (str == null || str.length() == 0) {
	str = "file://" + newuri.getPath() + "index.html";
      } else {
	str = "file://" + newuri.getPath() + "index.html?" + str;
      }
      return Uri.parse(str);
    }
    return null;
  }
  
}
