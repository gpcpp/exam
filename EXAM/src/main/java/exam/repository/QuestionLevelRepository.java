package exam.repository;

import exam.entity.QuestionLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionLevelRepository extends JpaRepository<QuestionLevel, Integer> {
}
