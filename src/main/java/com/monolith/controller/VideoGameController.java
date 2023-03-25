package com.monolith.controller;

import com.monolith.dto.request.VideoGameUpdateRequestDto;
import com.monolith.dto.response.FindByVideoGameNameResponseDto;
import com.monolith.repository.entity.VideoGame;
import com.monolith.service.VideoGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.monolith.constants.EndPointList.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(VIDEOGAME)
@RequiredArgsConstructor
public class VideoGameController {
    private final VideoGameService videoGameService;

    /**
     * http://localhost:8080/dev/v1/videogame/save?name=Wow&gameCategory=MMORPG
     * @param videoGame
     * @return
     */
    @GetMapping(SAVE)
    public ResponseEntity<VideoGame> save (VideoGame videoGame){
        videoGameService.save(videoGame);
        return ResponseEntity.ok(videoGame);
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<VideoGame>> findAll(){
        List<VideoGame> result = videoGameService.findAll();
        return ResponseEntity.ok(result);
    }
    @GetMapping(FIND_BY_ID)
    public ResponseEntity<Optional<VideoGame>> findById(Long id){
        Optional<VideoGame> result = videoGameService.findById(id);
        return ResponseEntity.ok(result);
    }
    @GetMapping(FIND_BY_NAME)
    public ResponseEntity<FindByVideoGameNameResponseDto> findByName(String name){
        FindByVideoGameNameResponseDto result = videoGameService.findVideoGameByName(name);
        return ResponseEntity.ok(result);
    }

    @GetMapping(UPDATE)
    public ResponseEntity<VideoGame> update(VideoGameUpdateRequestDto dto){
        videoGameService.update(dto);
        return ResponseEntity.ok().build();
    }

}
