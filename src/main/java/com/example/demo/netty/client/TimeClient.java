package com.example.demo.netty.client;

import com.example.demo.netty.hander.TimeClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * 时间客户端
 *
 * @author wangzhuang
 * @date 2020/04/03
 */
public class TimeClient {

    public static void main(String[] args) {
        String host = args[0];
        int port = Integer.parseInt(args[1]);
        // 处理I/O操作的多线程事件循环器
        NioEventLoopGroup worker = new NioEventLoopGroup();
        try {
            // 创建客户端
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(worker)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            ch.pipeline().addLast(new TimeClientHandler());
                        }
                    });
            // 启动客户端
            ChannelFuture channelFuture = bootstrap.connect(host, port).sync();
            // 等待连接关闭
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
