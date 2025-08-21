package org.example.designpatterns.structural.proxy;

import org.example.designpatterns.structural.proxy.internet.Internet;
import org.example.designpatterns.structural.proxy.internet.ProxyInternet;
import org.example.designpatterns.structural.proxy.video.ProxyVideoDownloader;
import org.example.designpatterns.structural.proxy.video.VideoDownloader;

public class MainApp {

    public static void main(String[] args) {

        Internet internet = new ProxyInternet();
        internet.connectTo("google.com");
        internet.connectTo("banned.com");

        System.out.println("==========================================");

        VideoDownloader videoDownloader = new ProxyVideoDownloader();
        videoDownloader.getVideo("geekific");
        videoDownloader.getVideo("geekific");
        videoDownloader.getVideo("likeNsub");
        videoDownloader.getVideo("likeNsub");
        videoDownloader.getVideo("geekific");

    }

}
