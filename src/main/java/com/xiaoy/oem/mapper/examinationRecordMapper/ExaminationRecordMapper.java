package com.xiaoy.oem.mapper.examinationRecordMapper;

import com.xiaoy.oem.entity.examinationRecord.ExaminationRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExaminationRecordMapper {

    void addExaminationRecord(@Param("examinationRecord") ExaminationRecord examinationRecord);

    List<ExaminationRecord> queryExaminationRecord(@Param("examinationRecord") ExaminationRecord examinationRecord);

    List<ExaminationRecord> queryExaminationRecordByUsername(@Param("examinationRecord")ExaminationRecord examinationRecord);
}
