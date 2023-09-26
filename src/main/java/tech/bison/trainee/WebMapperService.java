package tech.bison.trainee;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class WebMapperService {

  private static final int INVALID_ID = 0;

  public CloudStorageResourceDto toDto(CloudStorage cloudStorage) {
    return new CloudStorageResourceDto(cloudStorage.id(), cloudStorage.name(), cloudStorage.username());
  }

  public CloudStorage fromDto(CloudStorageRequestDto cloudStorageDto) {
    return new CloudStorage(INVALID_ID, cloudStorageDto.name(), cloudStorageDto.username(), cloudStorageDto.password());
  }

  public List<CloudStorageResourceDto> toDtos(List<CloudStorage> cloudStorageEntries) {
    return cloudStorageEntries.stream().map(this::toDto).toList();
  }
}
