package ru.stason.study.spring.logic;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ru.stason.study.spring.web.SecurityConfig;

@Configuration
@ComponentScan(basePackages={"ru.stason.study.spring.logic"},
        excludeFilters={
                @ComponentScan.Filter(type= FilterType.ANNOTATION, value=EnableWebMvc.class)
        })
@Import(SecurityConfig.class)
public class RootConfig {
}