package com.example.leon.rssreader.content;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Leon on 15.11.2015.
 */
@Root(strict = false)
public class RssFeed {

    @Element
    RssChannel channel;

    public RssChannel getChannel() {
        return channel;
    }
}
