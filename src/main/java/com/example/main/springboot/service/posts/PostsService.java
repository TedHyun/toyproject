package com.example.main.springboot.service.posts;

import com.example.main.springboot.domain.posts.Posts;
import com.example.main.springboot.domain.posts.PostsRepository;
import com.example.main.springboot.web.dto.PostsListResponseDto;
import com.example.main.springboot.web.dto.PostsResponseDto;
import com.example.main.springboot.web.dto.PostsSaveRequestDto;
import com.example.main.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestsDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id =" + id));

        posts.update(requestsDto.getTitle(), requestsDto.getContent());

        return id;
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("NOT FOUND. id="+id));
            postsRepository.delete(posts);
    }

    public PostsResponseDto findById (Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("햬당 사용자가 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }
}

