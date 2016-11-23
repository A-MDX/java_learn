package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

/**
 * Created by A-mdx on 2016/11/23.
 */
public class NioServer {

    public static void main(String[] args) throws IOException {
        
        // 创建，并监听8080端口
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress(8080));
        
        // 设置非阻塞模式
        ssc.configureBlocking(false);
        
        // 为ssc注册选择器
        Selector selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        
        // 创建处理器
        Handler handler = new Handler(1024);
        while (true){
            // 等待请求，每次等待阻塞3s，超过3s线程继续向下运行，如果传入0或者不传入则一致阻塞。
            if (selector.select(3000) == 0){
                System.out.println(" waiting request timeout...");
                continue;
            }
            System.out.println("is working for request...");
            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
            while (keyIterator.hasNext()){
                SelectionKey key = keyIterator.next();
                try {
                    
                    // 接收到了
                    if (key.isAcceptable()){
                        handler.handlerAccept(key);
                    }
                    // 读数据
                    if (key.isReadable()){
                        handler.handlerRead(key);
                    }
                    
                }catch (Exception e){
                    keyIterator.remove();
                    continue;
                }
                // 处理完了，从待处理的SelectionKey迭代器中移除当前所使用的key
                keyIterator.remove();
            }
                
        }
        
        
    }
    
}

class Handler {
    private int bufferSize = 1024;
    private String localCharset = "utf-8";
    public Handler(){
        
    }
    public Handler(int bufferSize){
        this(bufferSize,null);
    }
    public Handler(String localCharset){
        this(-1,localCharset);
    }
    public Handler(int bufferSize,String localCharset){
        if (bufferSize > 0){
            this.bufferSize = bufferSize;
        }
        if (localCharset != null){
            this.localCharset = localCharset;
        }
    }
    public void handlerAccept(SelectionKey key) throws IOException {
        SocketChannel sc = ((ServerSocketChannel)key.channel()).accept();
        sc.configureBlocking(false);
        sc.register(key.selector(),SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));
        // 不懂这是什么意思。
    }
    
    public void handlerRead(SelectionKey key) throws IOException {
        // get channel
        SocketChannel sc = (SocketChannel) key.channel();
        //get buffer and reset.
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        buffer.clear();
        // if 没有读到内容，关闭
        if (sc.read(buffer) == -1){
            sc.close();
        }else {
            // buffer 转为读
            buffer.flip();
            // 将buffer中收到的值按照charset格式编码后保存到..
            String received = Charset.forName(localCharset).newDecoder().decode(buffer).toString();
            System.out.println("received from client... --> "+received);
            
            //返回数据给客户端
            String sendStr = "received from you : --> "+received;
            buffer = ByteBuffer.wrap(sendStr.getBytes(localCharset));
            sc.write(buffer);
            sc.close();
        }
        
    }
    
}
