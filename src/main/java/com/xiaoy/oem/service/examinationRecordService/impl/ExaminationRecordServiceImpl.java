package com.xiaoy.oem.service.examinationRecordService.impl;

import com.xiaoy.oem.entity.examinationRecord.ExaminationRecord;
import com.xiaoy.oem.mapper.examinationRecordMapper.ExaminationRecordMapper;
import com.xiaoy.oem.service.examinationRecordService.ExaminationRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("examinationRecordService")
public class ExaminationRecordServiceImpl implements ExaminationRecordService {

    @Resource
    ExaminationRecordMapper examinationRecordMapper;

    @Override
    public void addExaminationRecord(ExaminationRecord examinationRecord) {
        examinationRecordMapper.addExaminationRecord(examinationRecord);
    }

    @Override
    public List<ExaminationRecord> queryExaminationRecord(ExaminationRecord examinationRecord) {
        return examinationRecordMapper.queryExaminationRecord(examinationRecord);
    }

    @Override
    public List<ExaminationRecord> queryExaminationRecordByUsername(ExaminationRecord examinationRecord) {
        return examinationRecordMapper.queryExaminationRecordByUsername(examinationRecord);
    }
}
