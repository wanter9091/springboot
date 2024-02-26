package blog.of.obj.aop

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect

import org.springframework.stereotype.Component
import org.springframework.util.StopWatch

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
annotation class  Performance

@Aspect
@Component
class LogPerformance{
    //
    @Around("@annotation(Performance)")
    @Throws
    //
    private fun publicTarget(pjp: ProceedingJoinPoint): Any{
        println("성능 측정을 시작합니다.")
        val sw=StopWatch()
        sw.start()

        //
        val result = pjp.proceed()
        sw.stop()
        println("성능 측정이 끝났습니다.")
        //
        return result
    }
}