package exam.exception;

import lombok.Getter;
import exam.enums.ResultEnum;

@Getter
public class ExamException extends RuntimeException {
    private Integer code;

    public ExamException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public ExamException( Integer code, String message) {
        super(message);
        this.code = code;
    }
}
