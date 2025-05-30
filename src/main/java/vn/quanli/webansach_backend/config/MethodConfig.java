package vn.quanli.webansach_backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import jakarta.persistence.EntityManager;
import vn.quanli.webansach_backend.entity.Category;

@Configuration
public class MethodConfig implements RepositoryRestConfigurer {

    private String url = "http://localhost:8080";
    @Autowired
    private EntityManager entityManager;
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        
        HttpMethod[] unsupportedMethods = {
            HttpMethod.PATCH,
            HttpMethod.DELETE, 
            HttpMethod.POST
        };
        config.exposeIdsFor(entityManager.getMetamodel().getEntities()
                .stream()
                .map(entityType -> entityType.getJavaType())
                .toArray(Class[]::new));
        disableHttpMethods(Category.class, config, unsupportedMethods);

    }
    private void disableHttpMethods(Class c, RepositoryRestConfiguration config, HttpMethod[] unsupportedMethods) {
        config.getExposureConfiguration()
            .forDomainType(c)
            .withItemExposure((metadata, httpMethods) -> httpMethods.disable(unsupportedMethods))
            .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(unsupportedMethods));
    }
}
