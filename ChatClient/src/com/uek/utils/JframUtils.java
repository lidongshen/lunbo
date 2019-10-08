package com.uek.utils;

import java.util.HashMap;
import java.util.Map;

import com.uek.view.CrowdChatView;
import com.uek.view.LoginView;
import com.uek.view.MainView;
import com.uek.view.PrivateChatView;
import com.uek.view.RegisterView;
import com.uek.view.SearchView;

public class JframUtils {
	public static LoginView loginView;
	public static RegisterView registerView;
	public static SearchView searchView;
	public static MainView mainView;
	public static Map<String, PrivateChatView> friendIdAndChat = new HashMap<String, PrivateChatView>();
	public static Map<String, CrowdChatView> crowdAndChat = new HashMap<>();
}
