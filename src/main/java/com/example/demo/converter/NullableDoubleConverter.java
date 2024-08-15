package com.example.demo.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.alibaba.excel.context.AnalysisContext;

public class NullableDoubleConverter implements Converter<Double> {

    @Override
    public Class supportJavaTypeKey() {
        return Double.class;
    }
    public Double convertToJavaData(ReadCellData<?> cellData, ExcelContentProperty contentProperty, AnalysisContext context) {
        try {
            return cellData.getNumberValue().doubleValue();
        } catch (Exception e) {
            return null;
        }
    }
    public ReadCellData<?> convertToExcelData(Double value, ExcelContentProperty contentProperty, AnalysisContext context) {
        return new ReadCellData<>(value);
    }
}