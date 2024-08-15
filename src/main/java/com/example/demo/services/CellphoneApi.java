package com.example.demo.services;



import com.example.demo.base.vo.CellphoneVO;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface CellphoneApi {

    List<CellphoneVO> getAllCellphones();
    CellphoneVO getCellphoneById(Long id);
    CellphoneVO saveOrUpdateCellphone(CellphoneVO cellphone);
    void deleteCellphone(Long id);
    List<CellphoneVO> getCellphonesByCellphoneProtected(String Protected);
    List<CellphoneVO> getCellphones(CellphoneVO cellphone);
    Integer insertCellphone(CellphoneVO cellphone);
    void saveExcel(List<CellphoneVO> cellphoneVO);
}
