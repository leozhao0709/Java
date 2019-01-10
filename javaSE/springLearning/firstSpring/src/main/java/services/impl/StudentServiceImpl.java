package services.impl;

import org.springframework.stereotype.Service;
import com.lzhao.di.services.StudentService;

@Service("studentService")
class StudentServiceImpl implements StudentService {

    @Override
    public void study() {
        System.out.println("StudentServiceImpl study");
    }
}
