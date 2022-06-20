package com.lhj.utils;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 测试Socket连接
 *
 * @author lhj on 2022/6/16
 */
public class SocketConnectTest {
    //Socket实例
    public static void main(String[] args) {
//        try {
//            InetAddress addr;
//            Socket sock = new Socket("www.runoob.com", 80);
//            addr = sock.getInetAddress();
//            System.out.println("连接到 " + addr);
//            sock.close();
//        } catch (java.io.IOException e) {
//            System.out.println("无法连接 " + args[0]);
//            System.out.println(e);
//        }
//    }

    //Socket客户端请求服务端
//    try {
//        Socket s = new Socket("127.0.0.1",8888);
//
//        //构建IO
//        InputStream is = s.getInputStream();
//        OutputStream os = s.getOutputStream();
//
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
//        //向服务器端发送一条消息
//        bw.write("测试客户端和服务器通信，服务器接收到消息返回到客户端\n");
//        bw.flush();
//
//        //读取服务器返回的消息
//        BufferedReader br = new BufferedReader(new InputStreamReader(is));
//        String mess = br.readLine();
//        System.out.println("服务器："+mess);
//    } catch (UnknownHostException e) {
//        e.printStackTrace();
//    } catch (IOException e) {
//        e.printStackTrace();
//    }


        final int PORT = 8888;//服务器的端口
        final String IP = "127.0.0.1";//服务器的IP
        Socket socket = null;//net包下的一个类,用于处理连接事务
        PrintWriter writer = null;
        BufferedReader reader = null;
        System.out.println("======Client======");
        System.out.println("Connecting...");
        try {
            /*通过IP，和端口进行连接*/
            socket = new Socket(IP, PORT);
            System.out.println("Connect success");
            /*从socket中，我们可以获取到输入输出流*/
            writer = new PrintWriter(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            /*现在可以收发消息了*/
            writer.println("我是lhj");
            writer.flush();//这个方法必不可少，暂且可以理解为发送键
            String msg = reader.readLine();//读取一行消息
            System.out.println("Client received :"+msg);
            /*首个简单实例，到这边连接就断开程序结束*/
            System.out.println("Client close");
            System.out.println("================");
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                if(reader!=null)
                    reader.close();
                if(writer!=null)
                    writer.close();
                if(socket!=null)
                    socket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


}


}
