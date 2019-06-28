package com.xiaoy.oem.service.examinationRecordService;

import com.xiaoy.oem.entity.examinationRecord.ExaminationRecord;

import java.util.List;

public interface ExaminationRecordService {

    void addExaminationRecord( ExaminationRecord examinationRecord);

     List<ExaminationRecord> queryExaminationRecord(ExaminationRecord examinationRecord);

    List<ExaminationRecord> queryExaminationRecordByUsername(ExaminationRecord examinationRecord);
}
