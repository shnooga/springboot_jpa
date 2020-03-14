package com.example.hellospringboot;

import com.example.hellospringboot.exception.BadRequestException;
import com.example.hellospringboot.exception.ConflictException;
import com.example.hellospringboot.exception.DataNotFoundException;
import com.example.hellospringboot.exception.IamTeaPotException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class HelloService {
    public String postHandling() {
        System.out.println("inside_postHandling");
        return "{\"Hello\": \"world\"}";
    }

    public String getHandling(String name) {
        System.out.println("inside_getHandling");
        return "{\"Hello\": \"" + name + "\"}";
    }

    public String causeExceptionByParam(String httpStatusCode) {
        System.out.println("causeExceptionByParam");
        throw createException(httpStatusCode);
    }

    private RuntimeException createException(String httpStatusCode) {
        int httpStatusNum =  StringUtils.isEmpty(httpStatusCode) ? 503 : Integer.parseInt(httpStatusCode);
        HttpStatus httpStatus = HttpStatus.valueOf(httpStatusNum);

        if (httpStatus == null) { return new RuntimeException("Unknown http status code: " + httpStatusCode);  }
        switch (httpStatus) {
            case NOT_FOUND: // 404
                return new DataNotFoundException("Data not found");
            case BAD_REQUEST: // 400
                return new BadRequestException("Bad request");
            case CONFLICT: // 409
                return new ConflictException("Conflict occured");
            default:
                return new IamTeaPotException("I am a teapot"); // 418
        }
    }
}
