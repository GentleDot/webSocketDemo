package net.gentledot.websocket.models.chat;

import net.gentledot.websocket.models.response.ChatResponse;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.web.util.HtmlUtils;

public class Content {
    private String username;
    private String message;

    protected Content() {
    }

    public String getUsername() {
        return username;
    }

    public String getMessage() {
        return message;
    }

    public ChatResponse generateResponse() {
        return new ChatResponse(HtmlUtils.htmlEscape(username),
                HtmlUtils.htmlEscape(message));
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("username", username)
                .append("message", message)
                .toString();
    }
}
