package net.gentledot.websocket.models.response;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.web.util.HtmlUtils;

import java.nio.charset.StandardCharsets;

public class ChatResponse {
    private String username;
    private String message;

    public ChatResponse(String username, String message) {
        Preconditions.checkArgument(StringUtils.isNotBlank(username), "사용자 이름은 반드시 설정되어야 합니다.");
        Preconditions.checkArgument(message.getBytes(StandardCharsets.UTF_8).length <= 300, "메시지는 300bytes를 초과할 수 없습니다.");
        this.username = HtmlUtils.htmlEscape(username);
        this.message = HtmlUtils.htmlEscape(message);
    }

    public String getUsername() {
        return username;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("username", username)
                .append("message", message)
                .toString();
    }
}
