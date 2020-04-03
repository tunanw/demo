package com.example.demo.netty.hander;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * 时间服务器
 *
 * @author wangzhuang
 * @date 2020/04/03
 */
public class TimeServerHandler extends ChannelHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 创建缓冲区
        final ByteBuf time = ctx.alloc().buffer(4);
        // 构建消息
        time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));
        // 发送消息
        ChannelFuture channelFuture = ctx.writeAndFlush(time);
        // 创建监听器
        channelFuture.addListener((ChannelFutureListener) future -> {
            assert channelFuture == future;
            ctx.close();
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
