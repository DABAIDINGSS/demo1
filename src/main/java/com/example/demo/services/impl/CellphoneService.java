package com.example.demo.services.impl;


import com.example.demo.base.vo.CellphoneVO;
import com.example.demo.dao.CellphoneMapper;
import com.example.demo.services.CellphoneApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class CellphoneService implements CellphoneApi {
    @Autowired
    private CellphoneMapper cellphoneMapper;

    @Override
    public List<CellphoneVO> getAllCellphones() {
        List<CellphoneVO> cellphones;
        cellphones = cellphoneMapper.findAll();
        cellphones.forEach(
                cellphone -> {
                    if("1".equals(cellphone.getProtection() ))
                    {
                        cellphone.setProtection("七天无理由");
                    }
                    else if ("0".equals(cellphone.getProtection() )) {
                        cellphone.setProtection("无七天无理由");
                    }
                    else
                    {
                        cellphone.setProtection(null);
                    }
                }
        );
        return cellphones;
    }

    @Override
    public CellphoneVO getCellphoneById(Long id) {
        return null;
    }

    @Override
    public CellphoneVO saveOrUpdateCellphone(CellphoneVO cellphone) {
        return null;
    }

    @Override
    public void deleteCellphone(Long id) {

    }

    @Override
    public List<CellphoneVO> getCellphonesByCellphoneProtected(String Protected) {
        List<CellphoneVO> cellphones;
        cellphones = cellphoneMapper.findByProtected(Protected);
        return cellphones;
    }

    @Override
    public List<CellphoneVO> getCellphones(CellphoneVO cellphone) {
        List<CellphoneVO> cellphones;
        cellphones = cellphoneMapper.find(cellphone);
        return cellphones;
    }

    @Override
    public Integer insertCellphone(CellphoneVO cellphone) {
        cellphoneMapper.insert(cellphone);
        return 0;
    }

    @Override
    public void saveExcel(List<CellphoneVO> cellphoneVO) {
        cellphoneMapper.excelInsert(cellphoneVO);
    }


}