package ru.stason.study.spring.web;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import ru.stason.study.spring.model.dao.UserDAO;
import ru.stason.study.spring.model.dao.impl.UserDAOImpl;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan("ru.stason.study.spring.web")
public class AppConfig extends WebMvcConfigurerAdapter {
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
        return resolver;
    }

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");

        return dataSource;
    }

    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(final DataSource dataSource) {
        return new LocalSessionFactoryBuilder(dataSource)
                .scanPackages("ru.stason.study.spring.persist.entities")
                .setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL93Dialect")
                .buildSessionFactory();
    }

    @Autowired
    @Bean(name = "userDao")
    public UserDAO getUserDao(final SessionFactory sessionFactory) {
        return new UserDAOImpl(sessionFactory);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}