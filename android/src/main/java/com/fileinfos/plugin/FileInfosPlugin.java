package com.fileinfos.plugin;

import android.Manifest;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;


@NativePlugin(
  permissions={
    Manifest.permission.READ_EXTERNAL_STORAGE
  }
)
public class FileInfosPlugin extends Plugin {

  private static final String PERMISSION_DENIED_ERROR = "Unable to do file operation, user denied permission request";

  @PluginMethod()
  public void getInfos(PluginCall call) {
    saveCall(call);
    String path = call.getString("path");

    String[] projection = {MediaStore.MediaColumns.DISPLAY_NAME,MediaStore.MediaColumns.SIZE};
    Cursor metaCursor = getContext().getContentResolver().query(Uri.parse(path), projection, null, null, null);
    JSObject data = new JSObject();

    if (metaCursor != null) {
      try {
        while (metaCursor.moveToNext()) {
          data.put("name", metaCursor.getString(0));
          data.put("size", metaCursor.getString(1));
        }
      } finally {
          metaCursor.close();
      }
    }

    call.success(data);
  }
}
