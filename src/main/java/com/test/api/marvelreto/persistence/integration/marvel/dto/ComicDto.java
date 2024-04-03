package com.test.api.marvelreto.persistence.integration.marvel.dto;

public record ComicDto(
        Long id,
        String title,
        String description,
        String modified,
        String resourceURI,
        ThumbnailDto thumbnail
) {
}
