package com.example.demo.dao;

import com.example.demo.base.vo.CellphoneVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Mapper
@Repository
public interface CellphoneMapper {
    List<CellphoneVO> findAll();
    List<CellphoneVO> findByProtected(String Protected);
    List<CellphoneVO> find(CellphoneVO cellphoneVO);
    Integer     insert(CellphoneVO cellphoneVO);
    Integer excelInsert(List<CellphoneVO> cellphoneVO);
}
