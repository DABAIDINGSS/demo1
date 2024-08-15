package com.example.demo.controller;


import com.alibaba.excel.EasyExcel;
import com.example.demo.base.vo.CellphoneVO;
import com.example.demo.lisenner.DataListener;
import com.example.demo.services.CellphoneApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@RestController

@RequestMapping("/test/cellphones")
public class CellphoneController {
    @Autowired
    private CellphoneApi service;
    private static final Logger logger = LoggerFactory.getLogger(CellphoneController.class);
    @GetMapping(value = "/query")
    public List<CellphoneVO> getAllCellphones() {

        return service.getAllCellphones();
    }
    @PostMapping(value = "/queryByProtected")
    public List<CellphoneVO> getCellphonesByProtected(@RequestBody CellphoneVO cellphoneVO) {
        logger.info("Received request with protection: {}", cellphoneVO.getProtection()); // 记录收到的保护值
        if (cellphoneVO == null || cellphoneVO.getProtection() == null) {
            logger.error("Request body is null or protection is null"); // 如果VO为空或保护值为空则记录错误
        }

        return service.getCellphonesByCellphoneProtected(cellphoneVO.getProtection());
    }
    @PostMapping(value = "/query_dynamic")
    public List<CellphoneVO> getCellphonesByCellphone(@RequestBody CellphoneVO cellphoneVO) {
        logger.info("Received request with protection: {}", cellphoneVO.getProtection()); // 记录收到的保护值
        if (cellphoneVO == null) {
            logger.error("Request body is null or protection is null"); // 如果VO为空或保护值为空则记录错误
        }
        return service.getCellphones(cellphoneVO);
    }

    @PostMapping(value = "/insert")
    public Integer insertCellphone(@RequestBody CellphoneVO cellphoneVO) {
        service.insertCellphone(cellphoneVO);
        return 0;
    }


    @PostMapping("/export")
    @ResponseBody
    public void exportExcel( CellphoneVO cellphoneVO,HttpServletResponse response) throws IOException {
        List<CellphoneVO> list = service.getCellphones(cellphoneVO);
        // 设置响应的头部信息
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当客户端下载的文件名为中文时
        String fileName = URLEncoder.encode("手机数据", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");

        // 写入数据到输出流
        EasyExcel.write(response.getOutputStream(), CellphoneVO.class)
                .sheet("手机数据")
                .doWrite(list);
    }

    DataListener listener = new DataListener();
    @PostMapping("/import")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "文件不能为空";
        }
        String contentType = file.getContentType();
        if (contentType == null || (!contentType.equals("application/vnd.ms-excel") && !contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))) {
            logger.error("上传的不是Excel文件: {}", file.getOriginalFilename());
            return "文件类型错误，需要上传Excel文件";
        }
        try {
            EasyExcel.read(file.getInputStream(), CellphoneVO.class, listener).sheet().doRead();
            List<CellphoneVO> cellphoneVO = listener.getCellphoneVOS();
            service.saveExcel(cellphoneVO);
            return "文件上传并解析成功";
        } catch (Exception e) {
            logger.error("处理文件时发生错误", e);
            return "处理文件时发生错误";
        }
    }


}