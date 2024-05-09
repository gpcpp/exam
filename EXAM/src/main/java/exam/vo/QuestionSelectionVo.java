package exam.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import exam.entity.QuestionCategory;
import exam.entity.QuestionLevel;
import exam.entity.QuestionType;

import java.util.List;

@Data
public class QuestionSelectionVo {
    @JsonProperty("types")
    private List<QuestionType> questionTypeList;

    @JsonProperty("categories")
    private List<QuestionCategory> questionCategoryList;

    @JsonProperty("levels")
    private List<QuestionLevel> questionLevelList;
}
