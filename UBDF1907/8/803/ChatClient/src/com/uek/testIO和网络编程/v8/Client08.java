package com.uek.testIO和网络编程.v8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.uek.utils.FrameUtils;
import com.uek.view.LoginView;
import com.uek.view.MainView;
import com.uek.view.RegisterView;
import com.uek.view.SearchView;

public class Client08 {
	
	//客户端任意时刻想要和服务器通信，都可以拿这个socket
	public static Socket selfSocket;
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket socket = new Socket("localhost" , 8888);
		
		Client08.selfSocket = socket;
		
		//启动一条线程负责读取服务器任意时刻的返回信息
		Thread t = new ClientThread(socket);
		t.start();
		
		
		LoginView lv = new LoginView();//创建界面
		lv.init();//显示界面
		
		FrameUtils.loginView = lv;//缓存到工具类FrameUtils.loginView
		
		
	}
}

class ClientThread extends Thread
{
	private Socket socket;
	
	public ClientThread(Socket socket)
	{
		this.socket = socket;
		
	}
	
	@Override
	public void run() {
		//不停的读取网络（服务器）发送过来的数据 echo+原本的信息
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String line = null;
			
			while( (line = br.readLine()) != null )
			{
				
				System.out.println("客户端收到服务器的数据: "+line);
				
				String[] strs = line.split(",");
				
				//客户端要注册 1,ok 或 1,nook
				if("1".equals(strs[0]))
				{
					if("ok".equals(strs[1]))
					{
						JOptionPane.showMessageDialog(null, "注册成功!");
						
						//setVisiable是隐藏 内存还在
						//FrameUtils.registerView.setVisible(false);
		
						//disponse直接内存销毁
						RegisterView rv = FrameUtils.registerView;
						
						
						
						
						LoginView lv = FrameUtils.loginView;
						lv.getJtf().setText(rv.getJtf1().getText());
						
						rv.dispose();
						
						lv.setVisible(true);
						
					}else
					{
						JOptionPane.showMessageDialog(null, "注册失败!");
					}
				}
				
				
				if("2".equals(strs[0]))
				{
					if("ok".equals(strs[1]))
					{
						String usersStr = line.substring(5);
						
						//包括自己和好友
						String[] users = usersStr.split(";");
						
						
						//从缓存界面的工具类找到登录界面
						LoginView rv = FrameUtils.loginView;
						
						//直接从内存中销毁 当然也就不显示了
						rv.dispose();
						
						
						MainView mv  = new MainView();
						mv.init(users);
						
						FrameUtils.mainView = mv;
						
					}else
					{
						JOptionPane.showMessageDialog(null, "登录失败!");
					}
				}
				
				
				
				if("3".equals(strs[0]))
				{
					if("ok".equals(strs[1]))
					{
						//line 3,ok,1,zs,iamzs,1.jpg;2,ls,iamls,1.jpg;ww,111,iamww,1.jpg
						String usersStr = line.substring(5);
						
						//usersStr 1,zs,iamzs,1.jpg;2,ls,iamls,1.jpg;ww,111,iamww,1.jpg
						String[] users = usersStr.split(";");
						
						//
						//Vector就类似与ArryList
						Vector<String> columnNames = new Vector<>();
						columnNames.add("id");
						columnNames.add("名字");
						columnNames.add("签名");
						columnNames.add("头像");
						
						Vector<Vector<String>> rows = new Vector<Vector<String>>();
						
						for (String user : users) {
							
							String[] ss = user.split(",");
							
							//user 1,zs,iamzs,1.jpg
							Vector<String> row = new Vector<>();
							row.add(ss[0]);
							row.add(ss[1]);
							row.add(ss[2]);
							row.add(ss[3]);
							
							rows.add(row);
							
						}
						
						JTable jt = new JTable(rows, columnNames);
						JScrollPane jsp = new JScrollPane(jt);
						
						SearchView searchView = FrameUtils.searchView;
								
						JPanel jp2 = searchView.getJp2();
						
						//清空面板原来的内容
						jp2.removeAll();
						
						//加入新的内容
						jp2.add(jsp);
						
						//调用Jpanel的更新方法 更新ui
						jp2.updateUI();
						
					}else
					{
						JOptionPane.showMessageDialog(null, "没有找到!");
					}
				}
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
