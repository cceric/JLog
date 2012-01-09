package testlib.log;

public class LogCommon {
	
	/** ALL log will be output */
	public static final int LEVEL_DEB = 0x0;
	
	/** All log but LEVEL_DEB will be output */
	public static final int LEVEL_INF = LEVEL_DEB + 1;
	
	/** only WAN and ERR will be output */
	public static final int LEVEL_WAN = LEVEL_INF + 1;
	
	/** only ERR log will be output */
	public static final int LEVEL_ERR = LEVEL_WAN + 1;
	
	/** None will be output */
	public static final int LEVEL_NON = LEVEL_ERR + 1;
	
	
	public interface LogAPI {
		
		/**
		 * Regist a plugin to log system
		 * @param plugin Plugin's instance
		 * @param arrs init param for LogPluginAPI.init()
		 * @return plugin's id
		 */
		public int registPlugin(LogCommon.LogPluginAPI plugin,String... arrs);
		/**
		 * Remove plugin from the log system
		 * @param pluginID the id you will get from registPlugin's return.
		 */
		public void removePlugin(int pluginID);
		/**
		 * set the log output level <br>
		 * After setting, only the out level above the level can be output<br >
		 * LEVEL_DEB < LEVEL_INF < LEVEL_WAN < LEVEL_ERR < LEVEL_NON <br >
		 * @param mlevel out put level, if mlevel smaller than LEVEL_DEB or bigger
		 * than LEVEL_NON, will be set as LEVEL_DEB or LEVEL_NON
		 */
		public void setLevel(int mlevel);
		/**
		 * Out put the error log
		 * @param tag log's topic
		 * @param context log's context
		 */
		public void e(String tag,String context);
		/**
		 * Out put the warning log
		 * @param tag log's topic
		 * @param context log's context
		 */
		public void w(String tag,String context);
		/**
		 * Out put the information log
		 * @param tag log's topic
		 * @param context log's context
		 */
		public void i(String tag,String context);
		/**
		 * Out put the debug log
		 * @param tag log's topic
		 * @param context log's context
		 */
		public void d(String tag,String context);
		/**
		 * will call on the release
		 * @param tag log's topic
		 * @param context log's context
		 */
		public void destory();
	}
	
	public interface LogPluginAPI {
		
		/**
		 * Will be called on Logger init to initialize the plugin.
		 * @param arr params if needs
		 */
		public void init(String...arr);
		
		/**
		 * Will do while output error log
		 * @param time formated time
		 * @param tag log's topic
		 * @param context log's context
		 */
		public void e_do(String time,String tag,String context);
		
		/**
		 * Will do while output warning log
		 * @param time formated time
		 * @param tag log's topic
		 * @param context log's context
		 */
		public void w_do(String time,String tag,String context);
		
		/**
		 * Will do while output information log
		 * @param time formated time
		 * @param tag log's topic
		 * @param context log's context
		 */
		public void i_do(String time,String tag,String context);
		
		/**
		 * Will do while output debug log
		 * @param time formated time
		 * @param tag log's topic
		 * @param context log's context
		 */
		public void d_do(String time,String tag,String context);
		
		/**
		 * Will be called on Logger destory to initialize the plugin.
		 * @param arr params if needs
		 */
		public void destory();
		
	}
}
