package testlib.log.plugin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import testlib.log.LogCommon.LogPluginAPI;

public class FilePlugin implements LogPluginAPI{
	
	private BufferedWriter bw = null;

	@Override
	public void init(String... arr) {
		if(arr==null || arr[0]==null) return;
		File file = new File(arr[0]);
		try {
			bw = new BufferedWriter(new FileWriter(file,true));
		} catch (IOException e) {
			bw = null;
			e.printStackTrace();
		}
	}

	@Override
	public void e_do(String time, String tag, String context) {
		if(bw!=null) {
			try {
				bw.write(time+"\t"+"[ERR]"+tag+"\t"+context);
				bw.newLine();
				bw.flush();
			} catch (IOException e) {e.printStackTrace();}
		}
	}

	@Override
	public void w_do(String time, String tag, String context) {
		if(bw!=null) {
			try {
				bw.write(time+"\t"+"[WAN]"+tag+"\t"+context);
				bw.newLine();
				bw.flush();
			} catch (IOException e) {e.printStackTrace();}
		}
	}

	@Override
	public void i_do(String time, String tag, String context) {
		if(bw!=null) {
			try {
				bw.write(time+"\t"+"[INF]"+tag+"\t"+context);
				bw.newLine();
				bw.flush();
			} catch (IOException e) {e.printStackTrace();}
		}
		
	}

	@Override
	public void d_do(String time, String tag, String context) {
		if(bw!=null) {
			try {
				bw.write(time+"\t"+"[DEB]"+tag+"\t"+context);
				bw.newLine();
				bw.flush();
			} catch (IOException e) {e.printStackTrace();}
		}
	}

	@Override
	public void destory() {
		if(bw!=null) {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			bw=null;
		}
		
	}

}
