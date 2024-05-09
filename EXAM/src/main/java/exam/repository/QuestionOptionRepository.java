package exam.repository;

import exam.entity.QuestionOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionOptionRepository extends JpaRepository<QuestionOption, String> {
}
