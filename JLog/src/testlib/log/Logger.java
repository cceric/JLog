package testlib.log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import testlib.log.LogCommon.LogPluginAPI;

public class Logger implements LogCommon.LogAPI{
	
	private int logLevel;
	
	private ArrayList<LogCommon.LogPluginAPI> plugins = null;
	
	private String timeFormat = "yyyy-MM-dd HH:mm:ss";
	
	public Logger() {
		logLevel = LogCommon.LEVEL_DEB; // default to set the logLevel to DEBUG
		plugins = new ArrayList<LogCommon.LogPluginAPI>();
	}
	
	@Override
	public int registPlugin(LogPluginAPI plugin, String... arrs) {
		plugin.init(arrs);
		plugins.add(plugin);
		return plugins.size()-1;
	}
	
	@Override
	public void removePlugin(int pluginID) {
		if(pluginID<0||pluginID>=plugins.size())return;
		LogCommon.LogPluginAPI plugin = plugins.remove(pluginID);
		plugin.destory();
	}
	
	@Override
	public void setLevel(int mlevel) {
		if(mlevel<LogCommon.LEVEL_DEB)
			logLevel = LogCommon.LEVEL_DEB;
		else if (mlevel>LogCommon.LEVEL_NON)
			logLevel = LogCommon.LEVEL_NON;
		else logLevel = mlevel;
	}

	@Override
	public void e(String tag, String context) {
		if(logLevel>LogCommon.LEVEL_ERR)return;
		for(int i=0;i<plugins.size();i++)
			plugins.get(i).e_do(getTime(),tag, context);
	}

	@Override
	public void w(String tag, String context) {
		if(logLevel>LogCommon.LEVEL_WAN)return;
		for(int i=0;i<plugins.size();i++)
			plugins.get(i).w_do(getTime(),tag, context);
		
	}

	@Override
	public void i(String tag, String context) {
		if(logLevel>LogCommon.LEVEL_INF)return;
		for(int i=0;i<plugins.size();i++)
			plugins.get(i).i_do(getTime(),tag, context);
		
	}

	@Override
	public void d(String tag, String context) {
		if(logLevel>LogCommon.LEVEL_DEB)return;
		for(int i=0;i<plugins.size();i++)
			plugins.get(i).d_do(getTime(),tag, context);
		
	}

	@Override
	public void destory() {
		for(int i=0;i<plugins.size();i++)
			plugins.get(i).destory();
		
	}
	
	private String getTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);
		return sdf.format(date);
	}

}
