package blog.of.obj.controller

import blog.of.obj.aop.NativeKotlinPerformence
import blog.of.obj.aop.Performance
import org.springframework.web.bind.annotation.*;
import blog.of.obj.service.BlogService
import blog.of.obj.entity.Post

import java.util.*

data class CreatePostReqDto(
    val title: String,
    val body: String
)

@RestController
@RequestMapping("/blog")//blog 경로를 매핑하는것 이로 인하여 /blog에 대한 응답이 가능
class BlogController(val blogService: BlogService){
    @GetMapping("/{idx}")
    fun readOnePost(@PathVariable("idx") idx:String, @RequestParam("page", required= false, defaultValue = 0.toString()) page: Int ): Post{
        return blogService.readOnePost(idx)
    }

    @GetMapping()
    @Performance
    fun readAllPost(): List<Post>{
        return blogService.readAllPost()
    }

    @PostMapping()
    @Performance
    fun createPost(@RequestBody() createPostReqDto: CreatePostReqDto)= NativeKotlinPerformence("test") {
        return@NativeKotlinPerformence blogService.createPost(createPostReqDto.title, createPostReqDto.body)
    }

    @PutMapping("/{idx}")
    fun modifyPost(@PathVariable("idx") idx:String, @RequestBody() createPostReqDto: CreatePostReqDto ): Boolean{
        return blogService.modifyPost(idx, createPostReqDto.title, createPostReqDto.body)
    }

    @DeleteMapping("/{idx}")
    fun deletePost(@PathVariable("idx") idx:String ): Boolean{
        return blogService.deletePost(idx)
    }



}