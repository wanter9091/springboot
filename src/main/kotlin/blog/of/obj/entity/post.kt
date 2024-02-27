package blog.of.obj.entity

import jakarta.persistence.*

@Entity
@Table(name="post")
class Post(title: String, body: String){
    @Id
    @GeneratedValue
    var id: Long?=null

    @Column
    var title: String=title

    @Column
    var body: String=body
}