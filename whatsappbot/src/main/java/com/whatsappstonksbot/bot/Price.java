package com.whatsappstonksbot.bot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Price {
    public final String open;
    public final String high;
    public final String low;
    public final String current;
    public final String close;
    public final String time;

    public Price(@JsonProperty("o") String open,
            @JsonProperty("h") String high,
            @JsonProperty("l") String low,
            @JsonProperty("c") String current,
            @JsonProperty("pc") String close,
            @JsonProperty("t") String time) {
        this.open = open;
        this.high = high;
        this.low = low;
        this.current = current;
        this.close = close;
        this.time = time;
    }
}
