package cn.keets.swagger;

import io.swagger.models.Info;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by keets on 2017/8/30.
 */
@Data
@ConfigurationProperties("swagger")
public class SwaggerBean {
    String resourcePackage;
    String[] schemes;
    String title;
    String version;
    String description;
    String termsOfServiceUrl;
    String contact;
    String license;
    String licenseUrl;
    String filterClass;
    Info info;
    String host;
    String basePath;
    String scannerId;
    String configId;
    String contextId;
    private boolean usePathBasedConfig = false;

}
