package com.monolith.service;

import com.monolith.dto.request.VideoGameUpdateRequestDto;
import com.monolith.dto.response.FindByVideoGameNameResponseDto;
import com.monolith.repository.IVideoGameRepository;
import com.monolith.repository.entity.VideoGame;
import com.monolith.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoGameService extends ServiceManager<VideoGame,Long> {

    private final IVideoGameRepository repository;

    public VideoGameService(IVideoGameRepository repository){
        super(repository);
        this.repository = repository;
    }

    public FindByVideoGameNameResponseDto findVideoGameByName(String name){
        FindByVideoGameNameResponseDto result = repository.findVideoGameByName(name);
        return result;
    }

    public void update(VideoGameUpdateRequestDto dto){
        Optional<VideoGame> result = repository.findById(dto.getId());
        if(result.isPresent()){
            result.get().setPrice(dto.getPrice());
            result.get().setVideoGameStock(dto.getVideoGameStock());
            result.get().setAgeRestriction(dto.getAgeRestriction());
            repository.save(result.get());
        }
    }


}
