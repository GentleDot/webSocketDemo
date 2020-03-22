package net.gentledot.websocket.models.messages;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Greeting {
    private String content;

    protected Greeting() {
    }

    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("content", content)
                .toString();
    }
}
