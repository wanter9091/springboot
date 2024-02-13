package blog.of.obj.filter

import jakarta.servlet.*
import org.springframework.stereotype. Component
import java.io.IOException

@Component
class MyFilter: Filter{
    @Throws(ServletException::class)
    override fun init(filterConfig: FilterConfig?){//서버 처음 실행 시 실행 
        println("init filter")
    }

    @Throws(IOException::class, ServletException::class)
    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain){// 요청이 들어오면 실행
        println("before filter")
        chain.doFilter(request, response)
        println("after filter")
    }

    @Throws(IOException::class, ServletException::class)
    override fun destroy(){//서버 종료 시 실행
        println("destroy filter")
    }
}