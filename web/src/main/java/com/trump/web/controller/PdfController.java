package com.trump.web.controller;

import com.trump.web.pdf.GeneratePdfUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.resource.HttpResource;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@RestController
@Slf4j
public class PdfController {

    @GetMapping("/getPdfFile")
    public void generatePdf(@RequestParam String fileStr, HttpServletResponse httpServletResponse){
        OutputStream outputStream = null;
        try {
            httpServletResponse.setContentType("multipart/form-data");
            httpServletResponse.setHeader("Content-Disposition", "xxx.pdf");
            httpServletResponse.setCharacterEncoding("utf-8");
            outputStream = httpServletResponse.getOutputStream();
            GeneratePdfUtils.generatePDF(outputStream);

        } catch (IOException e) {
            log.info("eee:",e);
        }finally {
            if(outputStream!=null){
                try {
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                   log.info("error:",e);
                }
            }
        }
    }
}
