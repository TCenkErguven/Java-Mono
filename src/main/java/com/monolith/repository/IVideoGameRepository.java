package com.monolith.repository;

import com.monolith.dto.response.FindByVideoGameNameResponseDto;
import com.monolith.repository.entity.VideoGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IVideoGameRepository extends JpaRepository<VideoGame,Long> {
    @Query("select new com.monolith.dto.response.FindByVideoGameNameResponseDto(v.name,v.gameCategory,v.price,v.videoGameStock,v.ageRestriction)" +
            " from VideoGame v where v.name like ?1%")
    FindByVideoGameNameResponseDto findVideoGameByName(String name);
}
