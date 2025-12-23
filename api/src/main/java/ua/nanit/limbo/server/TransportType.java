package ua.nanit.limbo.server;

import io.netty.channel.ChannelFactory;
import io.netty.channel.IoHandlerFactory;
import io.netty.channel.ServerChannel;
import io.netty.channel.epoll.Epoll;
import io.netty.channel.epoll.EpollIoHandler;
import io.netty.channel.epoll.EpollServerSocketChannel;
import io.netty.channel.kqueue.KQueue;
import io.netty.channel.kqueue.KQueueIoHandler;
import io.netty.channel.kqueue.KQueueServerSocketChannel;
import io.netty.channel.nio.NioIoHandler;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.uring.IoUring;
import io.netty.channel.uring.IoUringIoHandler;
import io.netty.channel.uring.IoUringServerSocketChannel;

public enum TransportType {
    NIO {
        @Override
        public ChannelFactory<? extends ServerChannel> getChannelFactory() {
            return NioServerSocketChannel::new;
        }

        @Override
        public IoHandlerFactory getIoHandlerFactory() {
            return NioIoHandler.newFactory();
        }

        public boolean isAvailable() {
            return true;
        }
    },
    EPOLL {
        @Override
        public ChannelFactory<? extends ServerChannel> getChannelFactory() {
            return EpollServerSocketChannel::new;
        }

        @Override
        public IoHandlerFactory getIoHandlerFactory() {
            return EpollIoHandler.newFactory();
        }

        public boolean isAvailable() {
            return Epoll.isAvailable();
        }
    },
    IO_URING {
        @Override
        public ChannelFactory<? extends ServerChannel> getChannelFactory() {
            return IoUringServerSocketChannel::new;
        }

        @Override
        public IoHandlerFactory getIoHandlerFactory() {
            return IoUringIoHandler.newFactory();
        }

        public boolean isAvailable() {
            return IoUring.isAvailable();
        }
    },
    KQUEUE {
        @Override
        public ChannelFactory<? extends ServerChannel> getChannelFactory() {
            return KQueueServerSocketChannel::new;
        }

        @Override
        public IoHandlerFactory getIoHandlerFactory() {
            return KQueueIoHandler.newFactory();
        }

        public boolean isAvailable() {
            return KQueue.isAvailable();
        }
    };

    public abstract ChannelFactory<? extends ServerChannel> getChannelFactory();

    public abstract IoHandlerFactory getIoHandlerFactory();

    public abstract boolean isAvailable();
}
