package net.gentledot.websocket.models.messages;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class HelloMessage {
    private String name;

    protected HelloMessage() {
    }

    public HelloMessage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .toString();
    }
}
