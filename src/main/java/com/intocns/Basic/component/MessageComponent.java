package com.intocns.Basic.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Locale;

@Component
public class MessageComponent {

    @Autowired
    private MessageSource messageSource;

    private MessageSourceAccessor accessor;

    @Value("${spring.mvc.locale}")
    Locale locale;

    @PostConstruct
    private void init() {
        accessor = new MessageSourceAccessor(messageSource, locale);
    }

    public String getMessage(String code) {
        return accessor.getMessage(code, "");
    }
}