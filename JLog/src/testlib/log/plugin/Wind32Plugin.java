package testlib.log.plugin;

import testlib.log.LogCommon.LogPluginAPI;

public class Wind32Plugin implements LogPluginAPI{

	@Override
	public void init(String... arr) {
		// nothing to do
		
	}

	@Override
	public void e_do(String time,String tag, String context) {
		System.err.println(time+"\t"+"[ERR]"+"\t"+tag+"\t"+context);
	}

	@Override
	public void w_do(String time,String tag, String context) {
		System.err.println(time+"\t"+"[WAN]"+"\t"+tag+"\t"+context);
		
	}

	@Override
	public void i_do(String time,String tag, String context) {
		System.err.println(time+"\t"+"[INF]"+"\t"+tag+"\t"+context);
		
	}

	@Override
	public void d_do(String time,String tag, String context) {
		System.err.println(time+"\t"+"[DEB]"+"\t"+tag+"\t"+context);
		
	}

	@Override
	public void destory() {
		// nothing to do
		
	}
	
}
