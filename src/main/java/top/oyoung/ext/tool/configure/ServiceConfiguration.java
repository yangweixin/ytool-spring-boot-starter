package top.oyoung.ext.tool.configure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import top.oyoung.ext.tool.properties.StringProperties;
import top.oyoung.ext.tool.service.ConcatStrService;

import javax.annotation.Resource;

@Configuration
@ConditionalOnClass(ConcatStrService.class)
@EnableConfigurationProperties(StringProperties.class)
public class ServiceConfiguration {

    @Resource
    private StringProperties stringProperties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "properties.string.enable", havingValue = "true")
    public ConcatStrService concatStrService(){
        if(StringUtils.isEmpty(stringProperties.getPrefix())){
            System.out.println("properties.string.prefix has not been set");
            return null;
        }
        if(StringUtils.isEmpty(stringProperties.getSubfix())){
            System.out.println("properties.string.subfix has not been set");
            return null;
        }
        return new ConcatStrService(stringProperties.getPrefix(),stringProperties.getSubfix());
    }
}
