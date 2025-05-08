package com.ce.ceaiagent.demo.invoke;

import com.ce.ceaiagent.exception.BusinessException;
import com.ce.ceaiagent.exception.ErrorCode;
import com.ce.ceaiagent.exception.ThrowUtils;
import jakarta.annotation.Resource;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Author hgc
 * @Date 2025/4/25/16:00
 * @ClassName SpringAiInvoke
 * @Description springAi框架调用ai
 */
@Component
public class SpringAiInvoke implements CommandLineRunner {

    @Resource
    private ChatModel dashScopeChatModel;
    @Override
    public void run(String... args) throws Exception {
        AssistantMessage assistantMessage = dashScopeChatModel.call(new Prompt("你好，我是世界上最帅的男人"))
                .getResult()
                .getOutput();
        //throw new BusinessException(ErrorCode.PARAMS_ERROR);
        System.out.println(assistantMessage.getText());
    }
}
