package trilv.tool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import trilv.tool.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
    Project findByProjectIdentifier(String id);
}
