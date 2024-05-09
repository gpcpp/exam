package exam.vo;

import lombok.Data;
import exam.entity.Exam;
import exam.entity.ExamRecord;
import exam.entity.User;

@Data
public class ExamRecordVo {
    /**
     * 当前考试记录对应的考试
     */
    private Exam exam;

    /**
     * 当前考试对应的内容
     */
    private ExamRecord examRecord;

    /**
     * 参加考试的用户信息
     */
    private User user;
}
