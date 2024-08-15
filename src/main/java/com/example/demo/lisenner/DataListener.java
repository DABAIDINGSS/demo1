package com.example.demo.lisenner;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.demo.base.vo.CellphoneVO;

import java.util.ArrayList;
import java.util.List;

public class DataListener extends AnalysisEventListener<CellphoneVO> {
    private List<CellphoneVO> cellphoneVOS = new ArrayList<>();

    @Override
    public void invoke(CellphoneVO cellphoneVO, AnalysisContext context) {
        cellphoneVOS.add(cellphoneVO);  // 将解析的数据添加到列表中
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        //buzhidaoganmade
    }


    public List<CellphoneVO> getCellphoneVOS() {
        return cellphoneVOS;  // 获取解析后的数据
    }
}
