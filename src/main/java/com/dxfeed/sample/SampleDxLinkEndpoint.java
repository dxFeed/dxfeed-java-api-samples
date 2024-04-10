package com.dxfeed.sample;

import com.dxfeed.api.DXEndpoint;
import com.dxfeed.api.DXFeedSubscription;
import com.dxfeed.event.market.Quote;

/**
 * A sample application that demonstrates how to subscribe to the data feed over a DxLink WebSocket connection
 * and print received {@link Quote} events to the console.
 */
public class SampleDxLinkEndpoint {
    public static void main(String[] args) throws InterruptedException {
        // Enable experimental feature.
        System.setProperty("dxfeed.experimental.dxlink.enable", "true");
        // Set scheme for dxLink.
        System.setProperty("scheme", "ext:opt:sysprops,resource:dxlink.xml");
        DXEndpoint dxEndpoint = DXEndpoint.create();
        // For token-based authorization, use the following address format:
        // "dxlink:wss://demo.dxfeed.com/dxlink-ws[login=dxlink:token]"
        dxEndpoint.connect("dxlink:wss://demo.dxfeed.com/dxlink-ws");
        DXFeedSubscription<Quote> subscription = dxEndpoint.getFeed().createSubscription(Quote.class);
        subscription.addEventListener(events -> {
            for (Quote event : events) {
                System.out.println(event);
            }
        });
        subscription.addSymbols("AAPL");
        Thread.sleep(Long.MAX_VALUE);
    }
}
