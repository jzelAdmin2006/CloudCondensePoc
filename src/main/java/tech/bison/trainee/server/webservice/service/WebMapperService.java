package tech.bison.trainee.server.webservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tech.bison.trainee.server.business.domain.cloud_storage.CloudStorage;
import tech.bison.trainee.server.webservice.adapter.model.cloud_storage.CloudStorageRequestDto;
import tech.bison.trainee.server.webservice.adapter.model.cloud_storage.CloudStorageResourceDto;

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
