package tech.bison.trainee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudStoragePersistence extends JpaRepository<CloudStorageEntity, Integer> {
}
