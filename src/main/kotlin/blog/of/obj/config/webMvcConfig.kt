package blog.of.obj.config

import blog.of.obj.interceptor.HttpInterceptor
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebMvcCofig : WebMvcConfigurer{
    override  fun addInterceptors(registry: InterceptorRegistry){
        registry.addInterceptor(HttpInterceptor())
    }
}