package cn.keets.swagger;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jersey.JerseyAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;


/**
 * Created by keets on 2017/8/27.
 */
@Configuration
@ConditionalOnClass({ResourceConfig.class})
@EnableConfigurationProperties(SwaggerBean.class)
@ConditionalOnProperty(value = "swagger.enabled", matchIfMissing = true)
@AutoConfigureAfter(JerseyAutoConfiguration.class)
public class SwaggerAutoConfiguration {

    @Autowired
    private SwaggerBean swaggerBean;

    @Autowired
    private ResourceConfig resourceConfig;

    @PostConstruct
    public void init() {
        BeanConfig config = buildConfig(swaggerBean);
        //todo load resource in starter
        resourceConfig.register(ApiListingResource.class, SwaggerSerializers.class);
    }


    public ResourceConfig getResourceConfig() {
        return resourceConfig;
    }

    public void setResourceConfig(ResourceConfig resourceConfig) {
        this.resourceConfig = resourceConfig;
    }

    private BeanConfig buildConfig(SwaggerBean swaggerBean) {
        BeanConfig config = new BeanConfig();
        config.setConfigId(swaggerBean.getConfigId());
        config.setTitle(swaggerBean.getTitle());
        config.setVersion(swaggerBean.getVersion());
        config.setContact(swaggerBean.getContact());
        config.setSchemes(new String[]{"http", "https"});
        config.setBasePath(swaggerBean.getBasePath());
        config.setResourcePackage(swaggerBean.getResourcePackage());
        config.setPrettyPrint(true);
        config.setScan(true);
        return config;
    }


    public static class AutoRegisterResource {

    }
}
