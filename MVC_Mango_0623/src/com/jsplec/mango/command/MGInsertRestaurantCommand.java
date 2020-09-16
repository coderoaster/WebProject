package com.jsplec.mango.command;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.jsplec.mango.dao.MGInsertRestaurantDao;

public class MGInsertRestaurantCommand implements MGCommand {
	private static final long serialVersionUID = 1L;
    
	private static final String CHARSET = "utf-8";								// 인코딩
	private static final String ATTACHES_DIR = "/Users/tj/Documents/Web01/Mango_0621/WebContent/img_review/";	// 저장 장소 (하드디스크)
	private static final int LIMIT_SIZE_BYTES = 1024 * 1024 * 10;				// 파일 받는 크

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding(CHARSET);
        PrintWriter out = response.getWriter(); 
 
        File attachesDir = new File(ATTACHES_DIR);
  
        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
        fileItemFactory.setRepository(attachesDir);
        fileItemFactory.setSizeThreshold(LIMIT_SIZE_BYTES);
        ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
        String asd[] = new String[7];
        String filename = null;
        int num=0;
        try {
        	// ServletFileUpload 클래스는 HTTP 요청에 대한 HttpServletRequest 객체로부터 
        	// multipart/form-data형식으로 넘어온 HTTP Body 부분을 다루기 쉽게 변환(parse)해주는 역할을 수행합니다.  
        	// parseRequest()메서드를 수행하면 FileItem이라는 형식으로 변환해줍니다.
            List<FileItem> items = fileUpload.parseRequest(request);
            
        	// 사용자가 업로드한 File데이터나 사용자가 input text에 입력한 일반 요청 데이터에 대한 객체입니다. 
        	// FileItem#isFormField() 메서드의 리턴값이 true이면 text같은 일반 입력 데이터이며, 
        	// false이면 파일 데이터입니다. 즉 리턴값이 false인 경우에만 업로드된 파일인것으로 인지하여 처리하면 됩니다.
            for (FileItem item : items) {
                if (item.isFormField()) {
                	// input text 값이 들어오는 곳
                    System.out.printf("파라미터 명 : %s, 파라미터 값 :  %s \n", item.getFieldName(), item.getString(CHARSET));
                    asd[num]=item.getString(CHARSET);
                    num++;
                } else {
                	// input file이 들어오는 곳
                    System.out.printf("파라미터 명 : %s, 파일 명 : %s,  파일 크기 : %s bytes \n", item.getFieldName(), item.getName(), item.getSize());
                    filename=item.getName();
                    if (item.getSize() > 0) {
                        String separator = File.separator;
                        int index =  item.getName().lastIndexOf(separator);
                        String fileName = item.getName().substring(index  + 1);
                        // 						  프로젝트 경로 	   루트 		   파일 이름
                        File uploadFile = new File(ATTACHES_DIR +  separator + fileName);
                        item.write(uploadFile);
                    }
                }
            } 
 
            out.println("<h1>파일 업로드 완료</h1>");
 
        } catch (Exception e) {
            // 파일 업로드 처리 중 오류가 발생하는 경우
            e.printStackTrace();
            out.println("<h1>파일 업로드 중 오류가  발생하였습니다.</h1>");
        }
        String category = asd[0];
        String R_name = asd[1];
        String addr = asd[2];
        String tel = asd[3];
        String kind = asd[4];
        String open_time = asd[5];
        String holiday = asd[6];
        String img = filename;

        MGInsertRestaurantDao idao = new MGInsertRestaurantDao();
        idao.insertRestaurant(category, R_name, addr, tel, kind, open_time, holiday, img);

	}

}

