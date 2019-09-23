package com.liyan.service.Impl;

import com.liyan.mapper.CollegeMapper;
import com.liyan.pojo.College;
import com.liyan.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jacey on 2017/6/30.
 */
@Service
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    private CollegeMapper collegeMapper;

    public List<College> finAll() throws Exception {
        College college=new College();
        return collegeMapper.selectByExample(college);
    }
}
