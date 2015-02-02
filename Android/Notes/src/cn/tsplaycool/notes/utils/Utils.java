package cn.tsplaycool.notes.utils;

import java.util.ArrayList;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.util.Log;

/**
 * 一些Android笔记
 * @author Tans
 */
public class Utils {

	/**
	 * 判断系统中某个service是否存在
	 * @param context
	 * @param serviceName
	 * @return
	 */
	public static boolean isServiceRunning(Context context, String serviceName) {
		ActivityManager mgr = (ActivityManager) context
				.getSystemService(Context.ACTIVITY_SERVICE);
		ArrayList<RunningServiceInfo> serviceList = (ArrayList<RunningServiceInfo>) mgr
				.getRunningServices(100);
		for (int i = 0; i < serviceList.size(); i++) {
			// "cn.kuwo.service.remote.uninstall.UninstallMonitorService"
			if (serviceName.equals(serviceList.get(i).service.getClassName()
					.toString())) {
				Log.d("tanshuai", "JAVA Service 正在Running! ");
				return true;
			}
		}
		return false;
	}
}