package io.netty.note;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.*;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;

/**
 * 一些重要的类/接口
 */
public class Entrance {

    public static void main(String[] args) {
        // 通道顶层接口 每个Channel都会被分配一个ChannelPipeline和ChannelConfig
        // Channel是独一无二的  Comparable保证顺序
        // Channel的实现是线程安全的
        Channel channel = new NioServerSocketChannel();

        // 处理注册后的所有I/O操作，通常处理多个Channel； EventLoop => EventLoopGroup
        EventLoop loop;
        EventLoopGroup group;

        // 处理所有出/入站数据的应用逻辑的容器
        //  这里的数据格式转换、active、registered、读写、flush、异常等方法
        ChannelHandler handler;

        // 为ChannelHandler链提供容器 SocketChannel.pipeline().addLast()...
        // 拦截过滤器设计模式(这个需要重点理解一下)
        ChannelPipeline pipeline;

        // 所有Netty提供的编码/解码器都实现了ChannelOutboundHandler/ChannelInboundHandler
        ChannelOutboundHandler outboundHandler;
        ChannelInboundHandler inboundHandler;
        ProtobufEncoder protobufEncoder;
        ProtobufDecoder protobufDecoder;

        // 简单的处理器，解码入站信息
        SimpleChannelInboundHandler<String> simpleChannelInboundHandler;

        // 连接到远程主机和端口
        Bootstrap bootstrap;
        // 绑定到一个本地端口
        ServerBootstrap serverBootstrap;

        // 这玩意儿实现了ReferenceCounted接口引用计数，应该是为了0拷贝实现做的
        // Netty的数据容器 这个hin重要
        // 支持自定义扩展、零拷贝、容量按需增长、读/写独立索引、链式调用、引用计数、池化等
        ByteBuf byteBuf;
        ByteBufHolder byteBufHolder;
    }
}
