package com.example.seb_main_project.like.postlike.service;

import com.example.seb_main_project.like.postlike.entity.PostLike;
import com.example.seb_main_project.like.postlike.repository.PostLikeRepository;
import com.example.seb_main_project.post.entity.Post;
import com.example.seb_main_project.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

//https://github.com/codestates-seb/seb39_main_051/blob/main/server/main/src/main/java/com/codestates/main/like/postlike/service/PostLikeService.java
public class PostLikeService {

    @Autowired
    private final PostLikeRepository postLikeRepository;
    @Autowired
    private final //MemberService memberService;    //이거 주석 해제해야 함. 현재 작성상태에서 해제하면 뭐 이상하게 바뀜;;나중에 해제하기!

    @Autowired
    private final PostService postService;

    public boolean postLike(Long postId) {

        Post showPost = postService.showPost(postId);
        Memeber showMember = SecurityUtils.getCurrentMember(memberService);
        Optional<PostLike> optionalPostLike = postLikeRepository.findByPostAndMember(showPost, showMember);

        optionalPostLike.ifPresentOrElse(
                postLike -> {  //만약, 기존에 이미 좋아요를 눌렀던 상태라면
                    postLikeRepository.delete(postLike); //여기서 좋아요를 다시 누르면 그건 '좋아요 취소'가 되는 것이라는 말인듯..
                }
        )
    }
}


























}
