package com.greenfox.endpointpdf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class WebContoller {

    @GetMapping(value = "downloadFile")
    public StreamingResponseBody getSteamingFile(HttpServletResponse response) {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"MySQL_commands.pdf\"");
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File("C:\\Users\\kazai\\Desktop\\MySQL_commands.pdf"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStream finalInputStream = inputStream;
        return outputStream -> {
            int nRead;
            byte[] data = new byte[1024];
            while ((nRead = finalInputStream.read(data, 0, data.length)) != -1) {
                System.out.println("Writing some bytes..");
                outputStream.write(data, 0, nRead);
            }
        };
    }
}
