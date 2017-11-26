package config;

import facade.FacadePackageMarker;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import services.ServicePackageMarker;

/**
 * @author Martin Zilak, 433372@mail.muni.cz
 */

@Configuration
@ComponentScan(basePackageClasses = {ServicePackageMarker.class, FacadePackageMarker.class})
public class ServiceConfiguration {

    @Bean
    public Mapper dozer(){
        DozerBeanMapper mapper = new DozerBeanMapper();
        return mapper;
    }
}