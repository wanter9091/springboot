package blog.of.obj.controller

import org.springframework.web.bind.annotation.*;
import blog.of.obj.service.blogService
import blog.of.obj.service.Post

data class CreatePostReqDto(
    val title: String,
    val body: String
)

@RestController
@RequestMapping("/blog")//blog 경로를 매핑하는것 이로 인하여 /blog에 대한 응답이 가능
class BlogController(val blogService: blogService){
    @GetMapping("/{idx}")
    fun readOnePost(@PathVariable("idx") idx:Int, @RequestParam("page", required= false, defaultValue = 0.toString()) page: Int ): Post{
        val list: List<Int> = listOf(0,1,2)
        return blogService.readOnePost(idx)
    }

    @GetMapping()
    fun readAllPost(): List<Post>{
        return blogService.readAllPost()
    }

    @PostMapping()
    fun createPost(@RequestBody() createPostReqDto: CreatePostReqDto): Boolean{
        return blogService.createPost(createPostReqDto.title, createPostReqDto.body)
    }

    @PutMapping("/{idx}")
    fun modifyPost(@PathVariable("idx") idx:Int, @RequestBody() createPostReqDto: CreatePostReqDto ): Boolean{
        return blogService.modifyPost(idx, createPostReqDto.title, createPostReqDto.body)
    }

    @DeleteMapping("/{idx}")
    fun deletePost(@PathVariable("idx") idx:Int ): Boolean{
        return blogService.deletePost(idx)
    }



}