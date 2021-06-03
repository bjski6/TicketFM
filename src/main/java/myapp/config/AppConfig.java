package myapp.config;


import myapp.converter.*;
import myapp.model.CompanyType;
import myapp.model.InspectionCycle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.persistence.EntityManagerFactory;
import javax.validation.Validator;
import java.util.Locale;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "myapp")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "myapp.repository")
public class AppConfig implements WebMvcConfigurer {

    //definicje beanów
    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean entityManagerFactoryBean
                = new LocalEntityManagerFactoryBean();
        entityManagerFactoryBean.setPersistenceUnitName("ticketFM");
        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager jpaTransactionManager =
                new JpaTransactionManager(entityManagerFactory);
        return jpaTransactionManager;
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver =
                new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }

    @Bean(name = "localeResolver")
    public LocaleContextResolver getLocaleContextResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("pl", "PL"));
        return localeResolver;
    }

    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(getInstallationConverter());
        registry.addConverter(getEquipmentStatusConverter());
        registry.addConverter(getCompanyTypeConverter());
        registry.addConverter(getTicketTypeConverter());
        registry.addConverter(getStatusConverter());
        registry.addConverter(getPersonConverter());
        registry.addConverter(getInspectionCycleConverter());
        registry.addConverter(getInspectionTypeConverter());
    }

    @Bean
    public InstallationConverter getInstallationConverter() {
        return new InstallationConverter();
    }

    @Bean
    public EquipmentStatusConverter getEquipmentStatusConverter() {
        return new EquipmentStatusConverter();
    }

    @Bean
    public CompanyTypeConverter getCompanyTypeConverter() {
        return new CompanyTypeConverter();
    }

    @Bean
    public TicketTypeConverter getTicketTypeConverter() {
        return new TicketTypeConverter();
    }

    @Bean
    public StatusConverter getStatusConverter() {
        return new StatusConverter();
    }

    @Bean
    public PersonConverter getPersonConverter() {
        return new PersonConverter();
    }

    @Bean
    public InspectionCycleConverter getInspectionCycleConverter() {
        return new InspectionCycleConverter();
    }

    @Bean
    public InspectionTypeConverter getInspectionTypeConverter() {
        return new InspectionTypeConverter();
    }
}