package com.uek.utils;

import java.util.HashMap;
import java.util.Map;

import com.uek.view.LoginView;
import com.uek.view.MainView;
import com.uek.view.PrivateChatView;
import com.uek.view.RegisterView;
import com.uek.view.SearchView;

/**
 * 这个工具类缓存所有在客户端打开过的页面，以便于需要的时候使用
 * 
 * @author UEK-N
 *
 */
public class FrameUtils {
	
	public static LoginView loginView;
	
	public static RegisterView registerView;
	
	public static SearchView searchView;
	
	
	public static MainView mainView;
	
	//缓存所有打开的聊天界面
	public static Map<Integer , PrivateChatView> friendIdAndPrivateChatViews = new HashMap<>();


}

